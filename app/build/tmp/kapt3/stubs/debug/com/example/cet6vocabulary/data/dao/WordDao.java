package com.example.cet6vocabulary.data.dao;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0014\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\bH\'J\u001e\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\b2\b\b\u0002\u0010\u000b\u001a\u00020\fH\'J\u001c\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\b2\u0006\u0010\u000e\u001a\u00020\fH\'J\u001c\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\b2\u0006\u0010\u0010\u001a\u00020\u0011H\'J\u0016\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u001c\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\b2\u0006\u0010\u0014\u001a\u00020\u0015H\'J\u001e\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u000b\u001a\u00020\fH\u00a7@\u00a2\u0006\u0002\u0010\u0019J\u0016\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J0\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u00112\b\u0010\u001d\u001a\u0004\u0018\u00010\u0011H\u00a7@\u00a2\u0006\u0002\u0010\u001e\u00a8\u0006\u001f"}, d2 = {"Lcom/example/cet6vocabulary/data/dao/WordDao;", "", "deleteWord", "", "word", "Lcom/example/cet6vocabulary/data/entities/Word;", "(Lcom/example/cet6vocabulary/data/entities/Word;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllWords", "Lkotlinx/coroutines/flow/Flow;", "", "getVocabularyListWords", "isInVocabularyList", "", "getWordsByMasteredStatus", "isMastered", "getWordsForReview", "currentTime", "", "insertWord", "searchWords", "searchQuery", "", "updateVocabularyListStatus", "wordId", "", "(IZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateWord", "updateWordMasteryStatus", "lastReviewedAt", "nextReviewAt", "(IZJLjava/lang/Long;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
@androidx.room.Dao
public abstract interface WordDao {
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object insertWord(@org.jetbrains.annotations.NotNull
    com.example.cet6vocabulary.data.entities.Word word, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Update
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object updateWord(@org.jetbrains.annotations.NotNull
    com.example.cet6vocabulary.data.entities.Word word, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Delete
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object deleteWord(@org.jetbrains.annotations.NotNull
    com.example.cet6vocabulary.data.entities.Word word, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM words ORDER BY id ASC")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.example.cet6vocabulary.data.entities.Word>> getAllWords();
    
    @androidx.room.Query(value = "SELECT * FROM words WHERE isMastered = :isMastered")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.example.cet6vocabulary.data.entities.Word>> getWordsByMasteredStatus(boolean isMastered);
    
    @androidx.room.Query(value = "SELECT * FROM words WHERE isInVocabularyList = :isInVocabularyList")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.example.cet6vocabulary.data.entities.Word>> getVocabularyListWords(boolean isInVocabularyList);
    
    @androidx.room.Query(value = "SELECT * FROM words WHERE nextReviewAt <= :currentTime AND nextReviewAt IS NOT NULL")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.example.cet6vocabulary.data.entities.Word>> getWordsForReview(long currentTime);
    
    @androidx.room.Query(value = "SELECT * FROM words WHERE word LIKE :searchQuery")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.example.cet6vocabulary.data.entities.Word>> searchWords(@org.jetbrains.annotations.NotNull
    java.lang.String searchQuery);
    
    @androidx.room.Query(value = "UPDATE words SET isMastered = :isMastered, lastReviewedAt = :lastReviewedAt, reviewCount = reviewCount + 1, nextReviewAt = :nextReviewAt WHERE id = :wordId")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object updateWordMasteryStatus(int wordId, boolean isMastered, long lastReviewedAt, @org.jetbrains.annotations.Nullable
    java.lang.Long nextReviewAt, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "UPDATE words SET isInVocabularyList = :isInVocabularyList WHERE id = :wordId")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object updateVocabularyListStatus(int wordId, boolean isInVocabularyList, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 3, xi = 48)
    public static final class DefaultImpls {
    }
}