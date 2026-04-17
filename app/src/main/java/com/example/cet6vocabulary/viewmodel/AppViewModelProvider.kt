package com.example.cet6vocabulary.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cet6vocabulary.data.database.AppDatabase
import com.example.cet6vocabulary.data.repository.WordRepository

class AppViewModelProvider(private val context: Context) : ViewModelProvider.Factory {
    private val database by lazy {
        AppDatabase.getDatabase(context)
    }

    private val repository by lazy {
        WordRepository(
            database.wordDao(),
            database.learningRecordDao()
        )
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(WordViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return WordViewModel(repository) as T
        } else if (modelClass.isAssignableFrom(LearningRecordViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return LearningRecordViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
