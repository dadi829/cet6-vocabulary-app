package com.example.cet6vocabulary.data.database

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.cet6vocabulary.data.dao.LearningRecordDao
import com.example.cet6vocabulary.data.dao.WordDao
import com.example.cet6vocabulary.data.entities.LearningRecord
import com.example.cet6vocabulary.data.entities.Word
import com.example.cet6vocabulary.data.utils.VocabularyLoader
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(
    entities = [Word::class, LearningRecord::class],
    version = 3,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun wordDao(): WordDao
    abstract fun learningRecordDao(): LearningRecordDao

    companion object {
        private const val TAG = "AppDatabase"
        
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "cet6_vocabulary_database"
                )
                    .addCallback(DatabaseCallback(context))
                    .addMigrations(MIGRATION_1_2, MIGRATION_2_3)
                    .build()
                INSTANCE = instance
                instance
            }
        }

        private val MIGRATION_1_2 = androidx.room.migration.Migration(1, 2) { database ->
            Log.d(TAG, "Migrating from version 1 to 2: clearing words table")
            database.execSQL("DELETE FROM words")
        }

        private val MIGRATION_2_3 = androidx.room.migration.Migration(2, 3) { database ->
            Log.d(TAG, "Migrating from version 2 to 3: clearing words table")
            database.execSQL("DELETE FROM words")
        }

        private class DatabaseCallback(private val context: Context) : RoomDatabase.Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                Log.d(TAG, "Database created, loading vocabulary data")
                loadVocabularyData()
            }

            override fun onOpen(db: SupportSQLiteDatabase) {
                super.onOpen(db)
                Log.d(TAG, "Database opened, checking vocabulary data")
                loadVocabularyData()
            }

            private fun loadVocabularyData() {
                val scope = CoroutineScope(Dispatchers.IO)
                scope.launch {
                    try {
                        val database = getDatabase(context)
                        val vocabularyLoader = VocabularyLoader(context)
                        
                        val wordCount = database.wordDao().getWordCount()
                        Log.d(TAG, "Current word count: $wordCount")
                        
                        if (wordCount == 0) {
                            Log.d(TAG, "Loading vocabulary from CET6_3.json")
                            vocabularyLoader.loadVocabularyFromAssets("CET6_3.json")
                                .onSuccess { words ->
                                    Log.d(TAG, "Loaded ${words.size} words from JSON")
                                    if (words.isNotEmpty()) {
                                        // 批量插入，每500个单词一个批次
                                        val batchSize = 500
                                        words.chunked(batchSize).forEachIndexed { index, batch ->
                                            Log.d(TAG, "Inserting batch ${index + 1}: ${batch.size} words")
                                            database.wordDao().insertWords(batch)
                                            // 让出时间片，避免阻塞主线程
                                            kotlinx.coroutines.yield()
                                        }
                                        Log.d(TAG, "Vocabulary loaded successfully")
                                    } else {
                                        Log.w(TAG, "No words loaded from JSON")
                                    }
                                }
                                .onFailure { exception ->
                                    Log.e(TAG, "Failed to load vocabulary", exception)
                                }
                        } else {
                            Log.d(TAG, "Vocabulary already loaded, skipping")
                        }
                    } catch (e: Exception) {
                        Log.e(TAG, "Error in loadVocabularyData", e)
                    }
                }
            }
        }
    }
}
