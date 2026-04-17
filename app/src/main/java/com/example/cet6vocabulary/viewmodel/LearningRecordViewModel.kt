package com.example.cet6vocabulary.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cet6vocabulary.data.entities.LearningRecord
import com.example.cet6vocabulary.data.repository.WordRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class LearningRecordViewModel(private val repository: WordRepository) : ViewModel() {
    private val _learningRecords = MutableStateFlow<List<LearningRecord>>(emptyList())
    val learningRecords: StateFlow<List<LearningRecord>> = _learningRecords.asStateFlow()

    private val _totalWordsLearned = MutableStateFlow(0)
    val totalWordsLearned: StateFlow<Int> = _totalWordsLearned.asStateFlow()

    private val _averageMasteryRate = MutableStateFlow(0f)
    val averageMasteryRate: StateFlow<Float> = _averageMasteryRate.asStateFlow()

    init {
        loadLearningRecords()
        calculateTodayStats()
    }

    fun loadLearningRecords() {
        viewModelScope.launch {
            repository.getAllLearningRecords().collect {
                _learningRecords.value = it
            }
        }
    }

    fun calculateTodayStats() {
        val today = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date())
        viewModelScope.launch {
            repository.getTotalWordsLearned(today, today).collect {
                _totalWordsLearned.value = it ?: 0
            }
            repository.getAverageMasteryRate(today, today).collect {
                _averageMasteryRate.value = it ?: 0f
            }
        }
    }

    fun calculateWeeklyStats() {
        val calendar = java.util.Calendar.getInstance()
        calendar.add(java.util.Calendar.DAY_OF_YEAR, -7)
        val startDate = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(calendar.time)
        val endDate = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date())

        viewModelScope.launch {
            repository.getTotalWordsLearned(startDate, endDate).collect {
                _totalWordsLearned.value = it ?: 0
            }
            repository.getAverageMasteryRate(startDate, endDate).collect {
                _averageMasteryRate.value = it ?: 0f
            }
        }
    }

    fun calculateMonthlyStats() {
        val calendar = java.util.Calendar.getInstance()
        calendar.add(java.util.Calendar.MONTH, -1)
        val startDate = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(calendar.time)
        val endDate = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date())

        viewModelScope.launch {
            repository.getTotalWordsLearned(startDate, endDate).collect {
                _totalWordsLearned.value = it ?: 0
            }
            repository.getAverageMasteryRate(startDate, endDate).collect {
                _averageMasteryRate.value = it ?: 0f
            }
        }
    }

    fun addLearningRecord(record: LearningRecord) {
        viewModelScope.launch {
            repository.insertLearningRecord(record)
        }
    }

    fun getRecordsByDateRange(startDate: String, endDate: String) {
        viewModelScope.launch {
            repository.getRecordsByDateRange(startDate, endDate).collect {
                _learningRecords.value = it
            }
        }
    }
}
