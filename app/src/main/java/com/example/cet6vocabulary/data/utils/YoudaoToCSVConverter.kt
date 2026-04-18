package com.example.cet6vocabulary.data.utils

import android.content.Context
import com.example.cet6vocabulary.data.entities.Word
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.json.JSONArray
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class YoudaoToCSVConverter(private val context: Context) {

    suspend fun convertJSONToCSV(jsonFileName: String, csvFileName: String): Result<Int> = withContext(Dispatchers.IO) {
        try {
            val words = mutableListOf<Word>()
            val jsonContent = readJSONFromAssets(jsonFileName)
            val jsonArray = JSONArray("[$jsonContent]")
            
            for (i in 0 until jsonArray.length()) {
                val wordObject = jsonArray.getJSONObject(i)
                val word = parseWordFromJSON(wordObject)
                if (word != null) {
                    words.add(word)
                }
            }
            
            writeCSVToFile(csvFileName, words)
            Result.success(words.size)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    private fun readJSONFromAssets(fileName: String): String {
        val inputStream = context.assets.open(fileName)
        val reader = BufferedReader(InputStreamReader(inputStream))
        val content = StringBuilder()
        
        var line: String?
        while (reader.readLine().also { line = it } != null) {
            content.append(line)
        }
        reader.close()
        return content.toString()
    }

    private fun parseWordFromJSON(jsonObject: JSONObject): Word? {
        return try {
            val headWord = jsonObject.optString("headWord", "")
            if (headWord.isBlank()) return null
            
            val content = jsonObject.optJSONObject("content") ?: return null
            val wordObj = content.optJSONObject("word") ?: return null
            
            val wordHead = wordObj.optString("wordHead", headWord)
            val usphone = wordObj.optString("usphone", "")
            val ukphone = wordObj.optString("ukphone", "")
            val phonetic = formatPhonetic(usphone, ukphone)
            
            val wordContent = wordObj.optJSONObject("content") ?: return null
            
            val partOfSpeech = extractPartOfSpeech(wordContent)
            val definition = extractDefinition(wordContent)
            val example = extractExample(wordContent)
            
            Word(
                word = wordHead.trim(),
                phonetic = phonetic,
                partOfSpeech = partOfSpeech,
                definition = definition,
                example = example,
                isMastered = false,
                isInVocabularyList = false,
                lastReviewedAt = null,
                reviewCount = 0,
                nextReviewAt = null
            )
        } catch (e: Exception) {
            null
        }
    }

    private fun formatPhonetic(usphone: String, ukphone: String): String {
        return when {
            usphone.isNotBlank() && ukphone.isNotBlank() -> "$ukphone / $usphone"
            usphone.isNotBlank() -> "/$usphone/"
            ukphone.isNotBlank() -> "/$ukphone/"
            else -> ""
        }
    }

    private fun extractPartOfSpeech(wordContent: JSONObject): String {
        return try {
            val trans = wordContent.optJSONArray("trans")
            if (trans != null && trans.length() > 0) {
                val firstTrans = trans.getJSONObject(0)
                firstTrans.optString("pos", "")
            } else {
                ""
            }
        } catch (e: Exception) {
            ""
        }
    }

    private fun extractDefinition(wordContent: JSONObject): String {
        return try {
            val trans = wordContent.optJSONArray("trans")
            if (trans != null && trans.length() > 0) {
                val definitions = mutableListOf<String>()
                for (i in 0 until trans.length()) {
                    val transObj = trans.getJSONObject(i)
                    val pos = transObj.optString("pos", "")
                    val tranCn = transObj.optString("tranCn", "")
                    if (tranCn.isNotBlank()) {
                        definitions.add("$pos $tranCn".trim())
                    }
                }
                definitions.joinToString("；")
            } else {
                ""
            }
        } catch (e: Exception) {
            ""
        }
    }

    private fun extractExample(wordContent: JSONObject): String {
        return try {
            val sentence = wordContent.optJSONObject("sentence")
            if (sentence != null) {
                val sentences = sentence.optJSONArray("sentences")
                if (sentences != null && sentences.length() > 0) {
                    val firstSentence = sentences.getJSONObject(0)
                    val sContent = firstSentence.optString("sContent", "")
                    val sCn = firstSentence.optString("sCn", "")
                    if (sContent.isNotBlank()) {
                        "$sContent\n$sCn"
                    } else {
                        ""
                    }
                } else {
                    ""
                }
            } else {
                ""
            }
        } catch (e: Exception) {
            ""
        }
    }

    private fun writeCSVToFile(fileName: String, words: List<Word>) {
        val outputStream = context.openFileOutput(fileName, Context.MODE_PRIVATE)
        val writer = OutputStreamWriter(outputStream, Charsets.UTF_8)
        
        writer.write("word,phonetic,partOfSpeech,definition,example\n")
        
        words.forEach { word ->
            val line = buildCSVLine(word)
            writer.write(line)
            writer.write("\n")
        }
        
        writer.close()
    }

    private fun buildCSVLine(word: Word): String {
        return listOf(
            escapeCSV(word.word),
            escapeCSV(word.phonetic),
            escapeCSV(word.partOfSpeech),
            escapeCSV(word.definition),
            escapeCSV(word.example)
        ).joinToString(",")
    }

    private fun escapeCSV(value: String): String {
        return if (value.contains(",") || value.contains("\"") || value.contains("\n")) {
            "\"${value.replace("\"", "\"\"")}\""
        } else {
            value
        }
    }

    suspend fun convertAllCET6Files(): Result<Map<String, Int>> = withContext(Dispatchers.IO) {
        try {
            val results = mutableMapOf<String, Int>()
            val cet6Files = listOf(
                "CET6_3.json"
            )
            
            cet6Files.forEach { fileName ->
                convertJSONToCSV(fileName, fileName.replace(".json", ".csv"))
                    .onSuccess { count -> results[fileName] = count }
                    .onFailure { results[fileName] = -1 }
            }
            
            Result.success(results)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun mergeMultipleJSONToCSV(jsonFileNames: List<String>, outputFileName: String): Result<Int> = withContext(Dispatchers.IO) {
        try {
            val allWords = mutableListOf<Word>()
            
            jsonFileNames.forEach { fileName ->
                try {
                    val jsonContent = readJSONFromAssets(fileName)
                    val jsonArray = JSONArray("[$jsonContent]")
                    
                    for (i in 0 until jsonArray.length()) {
                        val wordObject = jsonArray.getJSONObject(i)
                        val word = parseWordFromJSON(wordObject)
                        if (word != null) {
                            allWords.add(word)
                        }
                    }
                } catch (e: Exception) {
                    // Skip files that can't be parsed
                }
            }
            
            val distinctWords = allWords.distinctBy { it.word.lowercase() }
            writeCSVToFile(outputFileName, distinctWords)
            
            Result.success(distinctWords.size)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}