package com.example.cet6vocabulary.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.cet6vocabulary.data.entities.LearningRecord
import kotlinx.coroutines.flow.Flow

@Dao
interface LearningRecordDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRecord(record: LearningRecord)

    @Query("SELECT * FROM learning_records ORDER BY date DESC")
    fun getAllRecords(): Flow<List<LearningRecord>>

    @Query("SELECT * FROM learning_records WHERE date = :date")
    fun getRecordByDate(date: String): Flow<LearningRecord?>

    @Query("SELECT * FROM learning_records WHERE date >= :startDate AND date <= :endDate ORDER BY date ASC")
    fun getRecordsByDateRange(startDate: String, endDate: String): Flow<List<LearningRecord>>

    @Query("SELECT SUM(wordsLearned) FROM learning_records WHERE date >= :startDate AND date <= :endDate")
    fun getTotalWordsLearned(startDate: String, endDate: String): Flow<Int>

    @Query("SELECT AVG(masteryRate) FROM learning_records WHERE date >= :startDate AND date <= :endDate")
    fun getAverageMasteryRate(startDate: String, endDate: String): Flow<Float>
}
