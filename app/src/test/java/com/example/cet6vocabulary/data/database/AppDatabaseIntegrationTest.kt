package com.example.cet6vocabulary.data.database

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.example.cet6vocabulary.data.dao.WordDao
import com.example.cet6vocabulary.data.entities.Word
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.Assert.*

class AppDatabaseIntegrationTest {

    private lateinit var database: AppDatabase
    private lateinit var wordDao: WordDao
    private lateinit var context: Context

    @Before
    fun setup() {
        context = ApplicationProvider.getApplicationContext<Context>()
        database = Room.inMemoryDatabaseBuilder(
            context,
            AppDatabase::class.java
        ).build()
        wordDao = database.wordDao()
    }

    @After
    fun tearDown() {
        database.close()
    }

    @Test
    fun `database should be created successfully`() {
        assertNotNull(database)
        assertNotNull(wordDao)
    }

    @Test
    fun `insertWord should add word to database`() = runTest {
        val word = Word(
            word = "test",
            phonetic = "/test/",
            partOfSpeech = "n.",
            definition = "测试",
            example = "This is a test."
        )
        
        wordDao.insertWord(word)
        val words = wordDao.getAllWords().first()
        
        assertEquals(1, words.size)
        assertEquals("test", words[0].word)
    }

    @Test
    fun `getAllWords should return all words in database`() = runTest {
        val word1 = Word(word = "test1", phonetic = "/test1/", partOfSpeech = "n.", definition = "测试1", example = "Example 1")
        val word2 = Word(word = "test2", phonetic = "/test2/", partOfSpeech = "v.", definition = "测试2", example = "Example 2")
        
        wordDao.insertWord(word1)
        wordDao.insertWord(word2)
        val words = wordDao.getAllWords().first()
        
        assertEquals(2, words.size)
    }

    @Test
    fun `updateWord should modify existing word`() = runTest {
        val word = Word(word = "test", phonetic = "/test/", partOfSpeech = "n.", definition = "测试", example = "Example")
        wordDao.insertWord(word)
        
        val updatedWord = word.copy(definition = "更新后的测试")
        wordDao.updateWord(updatedWord)
        
        val words = wordDao.getAllWords().first()
        assertEquals("更新后的测试", words[0].definition)
    }

    @Test
    fun `deleteWord should remove word from database`() = runTest {
        val word = Word(word = "test", phonetic = "/test/", partOfSpeech = "n.", definition = "测试", example = "Example")
        wordDao.insertWord(word)
        
        wordDao.deleteWord(word)
        val words = wordDao.getAllWords().first()
        
        assertTrue(words.isEmpty())
    }

    @Test
    fun `getWordsByMasteredStatus should filter by mastery status`() = runTest {
        val masteredWord = Word(word = "mastered", phonetic = "/mastered/", partOfSpeech = "n.", definition = "已掌握", example = "Example", isMastered = true)
        val unmasteredWord = Word(word = "unmastered", phonetic = "/unmastered/", partOfSpeech = "n.", definition = "未掌握", example = "Example", isMastered = false)
        
        wordDao.insertWord(masteredWord)
        wordDao.insertWord(unmasteredWord)
        
        val masteredWords = wordDao.getWordsByMasteredStatus(true).first()
        val unmasteredWords = wordDao.getWordsByMasteredStatus(false).first()
        
        assertEquals(1, masteredWords.size)
        assertEquals(1, unmasteredWords.size)
        assertEquals("mastered", masteredWords[0].word)
        assertEquals("unmastered", unmasteredWords[0].word)
    }

    @Test
    fun `searchWords should find words matching query`() = runTest {
        val word1 = Word(word = "apple", phonetic = "/apple/", partOfSpeech = "n.", definition = "苹果", example = "Example")
        val word2 = Word(word = "application", phonetic = "/application/", partOfSpeech = "n.", definition = "应用", example = "Example")
        val word3 = Word(word = "banana", phonetic = "/banana/", partOfSpeech = "n.", definition = "香蕉", example = "Example")
        
        wordDao.insertWord(word1)
        wordDao.insertWord(word2)
        wordDao.insertWord(word3)
        
        val results = wordDao.searchWords("app").first()
        
        assertEquals(2, results.size)
    }

    @Test
    fun `updateWordMasteryStatus should update word mastery information`() = runTest {
        val word = Word(word = "test", phonetic = "/test/", partOfSpeech = "n.", definition = "测试", example = "Example")
        wordDao.insertWord(word)
        
        val currentTime = System.currentTimeMillis()
        val nextReviewTime = currentTime + 86400000L
        wordDao.updateWordMasteryStatus(1, true, currentTime, nextReviewTime)
        
        val words = wordDao.getAllWords().first()
        assertTrue(words[0].isMastered)
        assertEquals(currentTime, words[0].lastReviewedAt)
        assertEquals(1, words[0].reviewCount)
        assertEquals(nextReviewTime, words[0].nextReviewAt)
    }

    @Test
    fun `getWordsForReview should return words due for review`() = runTest {
        val pastTime = System.currentTimeMillis() - 1000
        val futureTime = System.currentTimeMillis() + 1000000
        
        val dueWord = Word(word = "due", phonetic = "/due/", partOfSpeech = "n.", definition = "到期", example = "Example", nextReviewAt = pastTime)
        val futureWord = Word(word = "future", phonetic = "/future/", partOfSpeech = "n.", definition = "未来", example = "Example", nextReviewAt = futureTime)
        
        wordDao.insertWord(dueWord)
        wordDao.insertWord(futureWord)
        
        val reviewWords = wordDao.getWordsForReview(System.currentTimeMillis()).first()
        
        assertEquals(1, reviewWords.size)
        assertEquals("due", reviewWords[0].word)
    }

    @Test
    fun `database should handle large number of words efficiently`() = runTest {
        val words = (1..100).map { index ->
            Word(
                word = "word$index",
                phonetic = "/word$index/",
                partOfSpeech = "n.",
                definition = "单词$index",
                example = "Example $index"
            )
        }
        
        words.forEach { wordDao.insertWord(it) }
        val allWords = wordDao.getAllWords().first()
        
        assertEquals(100, allWords.size)
    }
}