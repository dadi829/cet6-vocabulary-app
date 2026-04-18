package com.example.cet6vocabulary.data.utils

import android.content.Context
import android.os.Environment
import java.io.File

class YoudaoConverterManager(private val context: Context) {

    private val converter = YoudaoToCSVConverter(context)
    
    suspend fun convertYoudaoJSONToCSV(jsonFileName: String, csvFileName: String): Result<Int> {
        return converter.convertJSONToCSV(jsonFileName, csvFileName)
    }
    
    suspend fun convertAllCET6Files(): Result<Map<String, Int>> {
        return converter.convertAllCET6Files()
    }
    
    suspend fun mergeAndConvertCET6Files(outputFileName: String): Result<Int> {
        val jsonFiles = listOf(
            "CET6_3.json"
        )
        return converter.mergeMultipleJSONToCSV(jsonFiles, outputFileName)
    }
    
    fun getConvertedFilePaths(): List<String> {
        val filesDir = context.filesDir
        return filesDir.listFiles()?.filter { it.name.endsWith(".csv") }?.map { it.absolutePath } ?: emptyList()
    }
    
    fun getYoudaoFilesFromDownloads(): List<String> {
        val downloadsDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
        val youdaoDir = File(downloadsDir, "youdaokaoshendict-master")
        
        val jsonFiles = mutableListOf<String>()
        
        if (youdaoDir.exists() && youdaoDir.isDirectory) {
            youdaoDir.walk().forEach { file ->
                if (file.isFile && file.name.endsWith(".json")) {
                    jsonFiles.add(file.absolutePath)
                }
            }
        }
        
        return jsonFiles
    }
    
    suspend fun copyYoudaoFilesToAssets(): Result<List<String>> {
        val youdaoFiles = getYoudaoFilesFromDownloads()
        val copiedFiles = mutableListOf<String>()
        
        youdaoFiles.forEach { sourcePath ->
            val fileName = File(sourcePath).name
            val destFile = File(context.filesDir, fileName)
            
            try {
                File(sourcePath).copyTo(destFile, overwrite = true)
                copiedFiles.add(fileName)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        
        return if (copiedFiles.isEmpty()) {
            Result.failure(Exception("No Youdao files copied to assets"))
        } else {
            Result.success(copiedFiles)
        }
    }
    
    fun getAvailableVocabularyFiles(): List<String> {
        val assetsFiles = try {
            context.assets.list("")?.filter { 
                it.endsWith(".json") || it.endsWith(".csv") 
            } ?: emptyList()
        } catch (e: Exception) {
            emptyList()
        }
        
        val internalFiles = getConvertedFilePaths()
        
        return assetsFiles + internalFiles
    }
}