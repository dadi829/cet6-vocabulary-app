package com.example.cet6vocabulary.data.repository

import com.example.cet6vocabulary.data.dao.LearningRecordDao
import com.example.cet6vocabulary.data.dao.WordDao
import com.example.cet6vocabulary.data.entities.LearningRecord
import com.example.cet6vocabulary.data.entities.Word
import kotlinx.coroutines.flow.Flow

class WordRepository(
    private val wordDao: WordDao,
    private val learningRecordDao: LearningRecordDao
) {
    // Word operations
    fun getAllWords(): Flow<List<Word>> = wordDao.getAllWords()
    fun getWordsByMasteredStatus(isMastered: Boolean): Flow<List<Word>> = wordDao.getWordsByMasteredStatus(isMastered)
    fun getVocabularyListWords(): Flow<List<Word>> = wordDao.getVocabularyListWords()
    fun getWordsForReview(currentTime: Long): Flow<List<Word>> = wordDao.getWordsForReview(currentTime)
    fun searchWords(searchQuery: String): Flow<List<Word>> = wordDao.searchWords("%$searchQuery%")

    suspend fun insertWord(word: Word) = wordDao.insertWord(word)
    suspend fun updateWord(word: Word) = wordDao.updateWord(word)
    suspend fun deleteWord(word: Word) = wordDao.deleteWord(word)
    suspend fun updateWordMasteryStatus(wordId: Int, isMastered: Boolean, lastReviewedAt: Long, nextReviewAt: Long?) = wordDao.updateWordMasteryStatus(wordId, isMastered, lastReviewedAt, nextReviewAt)
    suspend fun updateVocabularyListStatus(wordId: Int, isInVocabularyList: Boolean) = wordDao.updateVocabularyListStatus(wordId, isInVocabularyList)

    // Learning record operations
    fun getAllLearningRecords(): Flow<List<LearningRecord>> = learningRecordDao.getAllRecords()
    fun getRecordByDate(date: String): Flow<LearningRecord?> = learningRecordDao.getRecordByDate(date)
    fun getRecordsByDateRange(startDate: String, endDate: String): Flow<List<LearningRecord>> = learningRecordDao.getRecordsByDateRange(startDate, endDate)
    fun getTotalWordsLearned(startDate: String, endDate: String): Flow<Int> = learningRecordDao.getTotalWordsLearned(startDate, endDate)
    fun getAverageMasteryRate(startDate: String, endDate: String): Flow<Float> = learningRecordDao.getAverageMasteryRate(startDate, endDate)

    suspend fun insertLearningRecord(record: LearningRecord) = learningRecordDao.insertRecord(record)
}
