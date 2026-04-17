package com.example.cet6vocabulary.data.database

import android.content.Context
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
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun wordDao(): WordDao
    abstract fun learningRecordDao(): LearningRecordDao

    companion object {
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
                    .build()
                INSTANCE = instance
                instance
            }
        }

        private class DatabaseCallback(private val context: Context) : RoomDatabase.Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                val scope = CoroutineScope(Dispatchers.IO)
                scope.launch {
                    val database = getDatabase(context)
                    val vocabularyLoader = VocabularyLoader(context)
                    
                    vocabularyLoader.loadVocabularyFromAssets("cet6_words.csv")
                        .onSuccess { words ->
                            database.wordDao().apply {
                                words.forEach { word ->
                                    insertWord(word)
                                }
                            }
                        }
                        .onFailure { exception ->
                            exception.printStackTrace()
                        }
                }
            }
        }
    }
}
