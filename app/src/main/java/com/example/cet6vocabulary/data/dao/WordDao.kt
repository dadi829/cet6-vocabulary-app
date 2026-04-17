package com.example.cet6vocabulary.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.cet6vocabulary.data.entities.Word
import kotlinx.coroutines.flow.Flow

@Dao
interface WordDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWord(word: Word)

    @Update
    suspend fun updateWord(word: Word)

    @Delete
    suspend fun deleteWord(word: Word)

    @Query("SELECT * FROM words ORDER BY id ASC")
    fun getAllWords(): Flow<List<Word>>

    @Query("SELECT * FROM words WHERE isMastered = :isMastered")
    fun getWordsByMasteredStatus(isMastered: Boolean): Flow<List<Word>>

    @Query("SELECT * FROM words WHERE isInVocabularyList = :isInVocabularyList")
    fun getVocabularyListWords(isInVocabularyList: Boolean = true): Flow<List<Word>>

    @Query("SELECT * FROM words WHERE nextReviewAt <= :currentTime AND nextReviewAt IS NOT NULL")
    fun getWordsForReview(currentTime: Long): Flow<List<Word>>

    @Query("SELECT * FROM words WHERE word LIKE :searchQuery")
    fun searchWords(searchQuery: String): Flow<List<Word>>

    @Query("UPDATE words SET isMastered = :isMastered, lastReviewedAt = :lastReviewedAt, reviewCount = reviewCount + 1, nextReviewAt = :nextReviewAt WHERE id = :wordId")
    suspend fun updateWordMasteryStatus(wordId: Int, isMastered: Boolean, lastReviewedAt: Long, nextReviewAt: Long?)

    @Query("UPDATE words SET isInVocabularyList = :isInVocabularyList WHERE id = :wordId")
    suspend fun updateVocabularyListStatus(wordId: Int, isInVocabularyList: Boolean)
}
