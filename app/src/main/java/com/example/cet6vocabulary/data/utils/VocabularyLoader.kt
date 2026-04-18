package com.example.cet6vocabulary.data.utils

import android.content.Context
import com.example.cet6vocabulary.data.entities.Word
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.BufferedReader
import java.io.InputStreamReader

class VocabularyLoader(private val context: Context) {
    
    private val jsonParser = YoudaoJSONParser(context)
    
    suspend fun loadVocabularyFromAssets(fileName: String): Result<List<Word>> = withContext(Dispatchers.IO) {
        try {
            if (fileName.endsWith(".json")) {
                loadVocabularyFromJSON(fileName)
            } else {
                loadVocabularyFromCSV(fileName)
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
    
    private suspend fun loadVocabularyFromCSV(fileName: String): Result<List<Word>> = withContext(Dispatchers.IO) {
        try {
            val words = mutableListOf<Word>()
            val inputStream = context.assets.open(fileName)
            val reader = BufferedReader(InputStreamReader(inputStream))
            
            reader.useLines { lines ->
                lines.forEachIndexed { index, line ->
                    if (index > 0) { 
                        val parts = line.split(",")
                        if (parts.size >= 5) {
                            val word = Word(
                                word = parts[0].trim(),
                                phonetic = parts[1].trim(),
                                partOfSpeech = parts[2].trim(),
                                definition = parts[3].trim(),
                                example = parts[4].trim(),
                                isMastered = false,
                                isInVocabularyList = false,
                                lastReviewedAt = null,
                                reviewCount = 0,
                                nextReviewAt = null
                            )
                            words.add(word)
                        }
                    }
                }
            }
            
            Result.success(words)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
    
    private suspend fun loadVocabularyFromJSON(fileName: String): Result<List<Word>> = withContext(Dispatchers.IO) {
        jsonParser.parseYoudaoJSON(fileName)
    }
    
    suspend fun parseCSVLine(line: String): Word? = withContext(Dispatchers.Default) {
        try {
            val parts = line.split(",")
            if (parts.size >= 5) {
                Word(
                    word = parts[0].trim(),
                    phonetic = parts[1].trim(),
                    partOfSpeech = parts[2].trim(),
                    definition = parts[3].trim(),
                    example = parts[4].trim(),
                    isMastered = false,
                    isInVocabularyList = false,
                    lastReviewedAt = null,
                    reviewCount = 0,
                    nextReviewAt = null
                )
            } else {
                null
            }
        } catch (e: Exception) {
            null
        }
    }
    
    suspend fun validateVocabularyData(words: List<Word>): Result<List<Word>> = withContext(Dispatchers.Default) {
        val validWords = words.filter {
            it.word.isNotBlank() &&
            it.definition.isNotBlank()
        }
        
        if (validWords.isEmpty()) {
            Result.failure(Exception("No valid vocabulary data found"))
        } else {
            Result.success(validWords)
        }
    }
}