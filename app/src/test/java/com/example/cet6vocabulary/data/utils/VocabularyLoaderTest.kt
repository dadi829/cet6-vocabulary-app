package com.example.cet6vocabulary.data.utils

import android.content.Context
import com.example.cet6vocabulary.data.entities.Word
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.junit.Assert.*
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations

class VocabularyLoaderTest {

    @Mock
    private lateinit var mockContext: Context

    private lateinit var vocabularyLoader: VocabularyLoader

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        vocabularyLoader = VocabularyLoader(mockContext)
    }

    @Test
    fun `parseCSVLine should return Word object when line has valid format`() = runTest {
        val line = "abandon,/əˈbændən/,vt.,放弃，抛弃,He abandoned his car in the snow."
        
        val result = vocabularyLoader.parseCSVLine(line)
        
        assertNotNull(result)
        assertEquals("abandon", result?.word)
        assertEquals("/əˈbændən/", result?.phonetic)
        assertEquals("vt.", result?.partOfSpeech)
        assertEquals("放弃，抛弃", result?.definition)
        assertEquals("He abandoned his car in the snow.", result?.example)
        assertFalse(result?.isMastered ?: true)
        assertFalse(result?.isInVocabularyList ?: true)
        assertEquals(0, result?.reviewCount)
    }

    @Test
    fun `parseCSVLine should return null when line has insufficient parts`() = runTest {
        val line = "abandon,/əˈbændən/,vt."
        
        val result = vocabularyLoader.parseCSVLine(line)
        
        assertNull(result)
    }

    @Test
    fun `validateVocabularyData should filter out invalid words`() = runTest {
        val validWord = Word(
            word = "test",
            phonetic = "/test/",
            partOfSpeech = "n.",
            definition = "测试",
            example = "This is a test."
        )
        val invalidWord1 = Word(
            word = "",
            phonetic = "",
            partOfSpeech = "",
            definition = "",
            example = ""
        )
        val invalidWord2 = Word(
            word = "   ",
            phonetic = "",
            partOfSpeech = "",
            definition = "",
            example = ""
        )
        
        val words = listOf(validWord, invalidWord1, invalidWord2)
        val result = vocabularyLoader.validateVocabularyData(words)
        
        assertTrue(result.isSuccess)
        assertEquals(1, result.getOrNull()?.size)
        assertEquals("test", result.getOrNull()?.first()?.word)
    }

    @Test
    fun `validateVocabularyData should return failure when all words are invalid`() = runTest {
        val invalidWord = Word(
            word = "",
            phonetic = "",
            partOfSpeech = "",
            definition = "",
            example = ""
        )
        
        val words = listOf(invalidWord)
        val result = vocabularyLoader.validateVocabularyData(words)
        
        assertTrue(result.isFailure)
    }

    @Test
    fun `validateVocabularyData should preserve word properties`() = runTest {
        val originalWord = Word(
            word = "abandon",
            phonetic = "/əˈbændən/",
            partOfSpeech = "vt.",
            definition = "放弃，抛弃",
            example = "He abandoned his car in the snow.",
            isMastered = true,
            isInVocabularyList = true,
            lastReviewedAt = 123456789L,
            reviewCount = 5,
            nextReviewAt = 987654321L
        )
        
        val result = vocabularyLoader.validateVocabularyData(listOf(originalWord))
        
        assertTrue(result.isSuccess)
        val validatedWord = result.getOrNull()?.first()
        assertEquals("abandon", validatedWord?.word)
        assertEquals("/əˈbændən/", validatedWord?.phonetic)
        assertEquals("vt.", validatedWord?.partOfSpeech)
        assertEquals("放弃，抛弃", validatedWord?.definition)
        assertEquals("He abandoned his car in the snow.", validatedWord?.example)
        assertTrue(validatedWord?.isMastered ?: false)
        assertTrue(validatedWord?.isInVocabularyList ?: false)
        assertEquals(123456789L, validatedWord?.lastReviewedAt)
        assertEquals(5, validatedWord?.reviewCount)
        assertEquals(987654321L, validatedWord?.nextReviewAt)
    }
}