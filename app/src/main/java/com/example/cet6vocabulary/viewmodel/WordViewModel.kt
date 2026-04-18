package com.example.cet6vocabulary.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cet6vocabulary.data.entities.Word
import com.example.cet6vocabulary.data.repository.WordRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.util.Calendar

class WordViewModel(private val repository: WordRepository) : ViewModel() {
    private val _words = MutableStateFlow<List<Word>>(emptyList())
    val words: StateFlow<List<Word>> = _words.asStateFlow()

    private val _vocabularyList = MutableStateFlow<List<Word>>(emptyList())
    val vocabularyList: StateFlow<List<Word>> = _vocabularyList.asStateFlow()

    private val _reviewWords = MutableStateFlow<List<Word>>(emptyList())
    val reviewWords: StateFlow<List<Word>> = _reviewWords.asStateFlow()

    private val _searchResults = MutableStateFlow<List<Word>>(emptyList())
    val searchResults: StateFlow<List<Word>> = _searchResults.asStateFlow()

    init {
        loadAllWords()
        loadVocabularyList()
        loadReviewWords()
    }

    fun loadAllWords() {
        viewModelScope.launch {
            repository.getAllWords().collect {
                _words.value = it
            }
        }
    }

    fun loadVocabularyList() {
        viewModelScope.launch {
            repository.getAllWords().collect {
                _vocabularyList.value = it
            }
        }
    }

    fun loadReviewWords() {
        viewModelScope.launch {
            val currentTime = System.currentTimeMillis()
            repository.getAllWords().collect { allWords ->
                // 过滤出需要复习的单词：nextReviewAt <= currentTime 或 nextReviewAt为null
                val reviewWords = allWords.filter { it.nextReviewAt == null || it.nextReviewAt <= currentTime }
                _reviewWords.value = reviewWords
            }
        }
    }

    fun searchWords(query: String) {
        viewModelScope.launch {
            repository.searchWords(query).collect {
                _searchResults.value = it
            }
        }
    }

    fun markWordAsMastered(word: Word) {
        viewModelScope.launch {
            val currentTime = System.currentTimeMillis()
            val nextReviewAt = calculateNextReviewTime(word.reviewCount)
            repository.updateWordMasteryStatus(word.id, true, currentTime, nextReviewAt)
        }
    }

    fun markWordAsNotMastered(word: Word) {
        viewModelScope.launch {
            val currentTime = System.currentTimeMillis()
            repository.updateWordMasteryStatus(word.id, false, currentTime, null)
            repository.updateVocabularyListStatus(word.id, true)
        }
    }

    fun addToVocabularyList(word: Word) {
        viewModelScope.launch {
            repository.updateVocabularyListStatus(word.id, true)
        }
    }

    fun removeFromVocabularyList(word: Word) {
        viewModelScope.launch {
            repository.updateVocabularyListStatus(word.id, false)
        }
    }

    private fun calculateNextReviewTime(reviewCount: Int): Long {
        val calendar = Calendar.getInstance()
        when (reviewCount) {
            0 -> calendar.add(Calendar.DAY_OF_YEAR, 1)
            1 -> calendar.add(Calendar.DAY_OF_YEAR, 3)
            2 -> calendar.add(Calendar.DAY_OF_YEAR, 7)
            3 -> calendar.add(Calendar.DAY_OF_YEAR, 14)
            else -> calendar.add(Calendar.DAY_OF_YEAR, 30)
        }
        return calendar.timeInMillis
    }

    fun insertWord(word: Word) {
        viewModelScope.launch {
            repository.insertWord(word)
        }
    }

    fun deleteWord(word: Word) {
        viewModelScope.launch {
            repository.deleteWord(word)
        }
    }
}
