package com.example.cet6vocabulary.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "words")
data class Word(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val word: String,
    val phonetic: String,
    val partOfSpeech: String,
    val definition: String,
    val example: String,
    val isMastered: Boolean = false,
    val isInVocabularyList: Boolean = false,
    val lastReviewedAt: Long? = null,
    val reviewCount: Int = 0,
    val nextReviewAt: Long? = null
)
