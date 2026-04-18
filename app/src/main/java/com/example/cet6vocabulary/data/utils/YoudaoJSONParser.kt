package com.example.cet6vocabulary.data.utils

import android.content.Context
import android.util.JsonReader
import android.util.Log
import com.example.cet6vocabulary.data.entities.Word
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.StringReader

class YoudaoJSONParser(private val context: Context) {

    companion object {
        private const val TAG = "YoudaoJSONParser"
    }

    suspend fun parseYoudaoJSON(fileName: String): Result<List<Word>> = withContext(Dispatchers.IO) {
        try {
            val words = mutableListOf<Word>()
            var successCount = 0
            var errorCount = 0
            var totalCount = 0
            
            context.assets.open(fileName).use { inputStream ->
                BufferedReader(InputStreamReader(inputStream, Charsets.UTF_8)).use { reader ->
                    var line: String?
                    while (reader.readLine().also { line = it } != null) {
                        if (line.isNullOrBlank()) continue
                        
                        totalCount++
                        try {
                            val word = parseJsonLine(line!!)
                            if (word != null) {
                                words.add(word)
                                successCount++
                            }
                        } catch (e: Exception) {
                            errorCount++
                            Log.e(TAG, "Error parsing line $totalCount", e)
                        }
                        
                        if (totalCount % 100 == 0) {
                            kotlinx.coroutines.yield()
                        }
                    }
                }
            }
            
            Log.d(TAG, "JSON parsing complete. Total: $totalCount, Success: $successCount, Errors: $errorCount")
            Result.success(words)
        } catch (e: Exception) {
            Log.e(TAG, "Failed to parse JSON file", e)
            Result.failure(e)
        }
    }

    private fun parseJsonLine(line: String): Word? {
        return StringReader(line).use { stringReader ->
            JsonReader(stringReader).use { reader ->
                parseSingleWord(reader)
            }
        }
    }

    private fun parseSingleWord(reader: JsonReader): Word? {
        var headWord = ""
        var wordHead = ""
        var usphone = ""
        var ukphone = ""
        var partOfSpeech = ""
        var definition = ""
        var example = ""
        
        reader.beginObject()
        
        while (reader.hasNext()) {
            when (reader.nextName()) {
                "headWord" -> headWord = reader.nextString()
                "content" -> {
                    reader.beginObject()
                    while (reader.hasNext()) {
                        when (reader.nextName()) {
                            "word" -> {
                                reader.beginObject()
                                while (reader.hasNext()) {
                                    when (reader.nextName()) {
                                        "wordHead" -> wordHead = reader.nextString()
                                        "usphone" -> usphone = reader.nextString()
                                        "ukphone" -> ukphone = reader.nextString()
                                        "content" -> {
                                            val content = parseWordContent(reader)
                                            partOfSpeech = content.first
                                            definition = content.second
                                            example = content.third
                                        }
                                        else -> reader.skipValue()
                                    }
                                }
                                reader.endObject()
                            }
                            else -> reader.skipValue()
                        }
                    }
                    reader.endObject()
                }
                else -> reader.skipValue()
            }
        }
        
        reader.endObject()
        
        val finalWord = wordHead.ifBlank { headWord }
        if (finalWord.isBlank()) return null
        
        return Word(
            word = finalWord.trim(),
            phonetic = formatPhonetic(usphone, ukphone),
            partOfSpeech = partOfSpeech,
            definition = definition,
            example = example,
            isMastered = false,
            isInVocabularyList = false,
            lastReviewedAt = null,
            reviewCount = 0,
            nextReviewAt = null
        )
    }

    private fun parseWordContent(reader: JsonReader): Triple<String, String, String> {
        var partOfSpeech = ""
        var definition = ""
        var example = ""
        
        reader.beginObject()
        
        while (reader.hasNext()) {
            when (reader.nextName()) {
                "trans" -> {
                    val definitions = mutableListOf<String>()
                    reader.beginArray()
                    while (reader.hasNext()) {
                        reader.beginObject()
                        var pos = ""
                        var tranCn = ""
                        while (reader.hasNext()) {
                            when (reader.nextName()) {
                                "pos" -> pos = reader.nextString()
                                "tranCn" -> tranCn = reader.nextString()
                                else -> reader.skipValue()
                            }
                        }
                        reader.endObject()
                        if (tranCn.isNotBlank()) {
                            definitions.add("$pos $tranCn".trim())
                        }
                        if (partOfSpeech.isBlank() && pos.isNotBlank()) {
                            partOfSpeech = pos
                        }
                    }
                    reader.endArray()
                    definition = definitions.joinToString("；")
                }
                "sentence" -> {
                    reader.beginObject()
                    while (reader.hasNext()) {
                        when (reader.nextName()) {
                            "sentences" -> {
                                reader.beginArray()
                                if (reader.hasNext()) {
                                    reader.beginObject()
                                    var sContent = ""
                                    var sCn = ""
                                    while (reader.hasNext()) {
                                        when (reader.nextName()) {
                                            "sContent" -> sContent = reader.nextString()
                                            "sCn" -> sCn = reader.nextString()
                                            else -> reader.skipValue()
                                        }
                                    }
                                    reader.endObject()
                                    if (sContent.isNotBlank()) {
                                        example = "$sContent\n$sCn"
                                    }
                                }
                                while (reader.hasNext()) {
                                    reader.skipValue()
                                }
                                reader.endArray()
                            }
                            else -> reader.skipValue()
                        }
                    }
                    reader.endObject()
                }
                else -> reader.skipValue()
            }
        }
        
        reader.endObject()
        
        return Triple(partOfSpeech, definition, example)
    }

    private fun formatPhonetic(usphone: String, ukphone: String): String {
        return when {
            usphone.isNotBlank() && ukphone.isNotBlank() -> "$ukphone / $usphone"
            usphone.isNotBlank() -> "/$usphone/"
            ukphone.isNotBlank() -> "/$ukphone/"
            else -> ""
        }
    }

    suspend fun parseMultipleFiles(fileNames: List<String>): Result<List<Word>> = withContext(Dispatchers.IO) {
        try {
            val allWords = mutableListOf<Word>()
            fileNames.forEach { fileName ->
                parseYoudaoJSON(fileName).onSuccess { words ->
                    allWords.addAll(words)
                }
            }
            Result.success(allWords.distinctBy { it.word.lowercase() })
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    fun getCET6Files(): List<String> {
        return listOf(
            "CET6_3.json",
            "CET6_1.zip",
            "CET6_2.zip",
            "CET6luan_1.zip"
        )
    }
}
