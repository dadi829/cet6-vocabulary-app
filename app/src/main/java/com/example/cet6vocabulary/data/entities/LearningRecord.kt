package com.example.cet6vocabulary.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "learning_records")
data class LearningRecord(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val date: String, // 格式：yyyy-MM-dd
    val wordsLearned: Int,
    val wordsReviewed: Int,
    val masteryRate: Float
)
