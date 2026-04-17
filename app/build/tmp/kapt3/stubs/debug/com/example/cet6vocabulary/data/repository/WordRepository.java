package com.example.cet6vocabulary.data.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0010\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0086@\u00a2\u0006\u0002\u0010\u000bJ\u0012\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\rJ\u0012\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u000e0\rJ\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\r2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014J\u0016\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\r2\u0006\u0010\u0017\u001a\u00020\u0014J\"\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\r2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014J\u001c\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\r2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014J\u0012\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u000e0\rJ\u001a\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u000e0\r2\u0006\u0010\u001d\u001a\u00020\u001eJ\u001a\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u000e0\r2\u0006\u0010 \u001a\u00020!J\u0016\u0010\"\u001a\u00020\b2\u0006\u0010#\u001a\u00020\u000fH\u0086@\u00a2\u0006\u0002\u0010$J\u0016\u0010%\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0086@\u00a2\u0006\u0002\u0010\u000bJ\u001a\u0010&\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u000e0\r2\u0006\u0010\'\u001a\u00020\u0014J\u001e\u0010(\u001a\u00020\b2\u0006\u0010)\u001a\u00020\u001a2\u0006\u0010*\u001a\u00020\u001eH\u0086@\u00a2\u0006\u0002\u0010+J\u0016\u0010,\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0086@\u00a2\u0006\u0002\u0010\u000bJ0\u0010-\u001a\u00020\b2\u0006\u0010)\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010.\u001a\u00020!2\b\u0010/\u001a\u0004\u0018\u00010!H\u0086@\u00a2\u0006\u0002\u00100R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00061"}, d2 = {"Lcom/example/cet6vocabulary/data/repository/WordRepository;", "", "wordDao", "Lcom/example/cet6vocabulary/data/dao/WordDao;", "learningRecordDao", "Lcom/example/cet6vocabulary/data/dao/LearningRecordDao;", "(Lcom/example/cet6vocabulary/data/dao/WordDao;Lcom/example/cet6vocabulary/data/dao/LearningRecordDao;)V", "deleteWord", "", "word", "Lcom/example/cet6vocabulary/data/entities/Word;", "(Lcom/example/cet6vocabulary/data/entities/Word;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllLearningRecords", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/example/cet6vocabulary/data/entities/LearningRecord;", "getAllWords", "getAverageMasteryRate", "", "startDate", "", "endDate", "getRecordByDate", "date", "getRecordsByDateRange", "getTotalWordsLearned", "", "getVocabularyListWords", "getWordsByMasteredStatus", "isMastered", "", "getWordsForReview", "currentTime", "", "insertLearningRecord", "record", "(Lcom/example/cet6vocabulary/data/entities/LearningRecord;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertWord", "searchWords", "searchQuery", "updateVocabularyListStatus", "wordId", "isInVocabularyList", "(IZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateWord", "updateWordMasteryStatus", "lastReviewedAt", "nextReviewAt", "(IZJLjava/lang/Long;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class WordRepository {
    @org.jetbrains.annotations.NotNull
    private final com.example.cet6vocabulary.data.dao.WordDao wordDao = null;
    @org.jetbrains.annotations.NotNull
    private final com.example.cet6vocabulary.data.dao.LearningRecordDao learningRecordDao = null;
    
    public WordRepository(@org.jetbrains.annotations.NotNull
    com.example.cet6vocabulary.data.dao.WordDao wordDao, @org.jetbrains.annotations.NotNull
    com.example.cet6vocabulary.data.dao.LearningRecordDao learningRecordDao) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.example.cet6vocabulary.data.entities.Word>> getAllWords() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.example.cet6vocabulary.data.entities.Word>> getWordsByMasteredStatus(boolean isMastered) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.example.cet6vocabulary.data.entities.Word>> getVocabularyListWords() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.example.cet6vocabulary.data.entities.Word>> getWordsForReview(long currentTime) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.example.cet6vocabulary.data.entities.Word>> searchWords(@org.jetbrains.annotations.NotNull
    java.lang.String searchQuery) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object insertWord(@org.jetbrains.annotations.NotNull
    com.example.cet6vocabulary.data.entities.Word word, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object updateWord(@org.jetbrains.annotations.NotNull
    com.example.cet6vocabulary.data.entities.Word word, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object deleteWord(@org.jetbrains.annotations.NotNull
    com.example.cet6vocabulary.data.entities.Word word, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object updateWordMasteryStatus(int wordId, boolean isMastered, long lastReviewedAt, @org.jetbrains.annotations.Nullable
    java.lang.Long nextReviewAt, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object updateVocabularyListStatus(int wordId, boolean isInVocabularyList, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.example.cet6vocabulary.data.entities.LearningRecord>> getAllLearningRecords() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<com.example.cet6vocabulary.data.entities.LearningRecord> getRecordByDate(@org.jetbrains.annotations.NotNull
    java.lang.String date) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.example.cet6vocabulary.data.entities.LearningRecord>> getRecordsByDateRange(@org.jetbrains.annotations.NotNull
    java.lang.String startDate, @org.jetbrains.annotations.NotNull
    java.lang.String endDate) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.lang.Integer> getTotalWordsLearned(@org.jetbrains.annotations.NotNull
    java.lang.String startDate, @org.jetbrains.annotations.NotNull
    java.lang.String endDate) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.lang.Float> getAverageMasteryRate(@org.jetbrains.annotations.NotNull
    java.lang.String startDate, @org.jetbrains.annotations.NotNull
    java.lang.String endDate) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object insertLearningRecord(@org.jetbrains.annotations.NotNull
    com.example.cet6vocabulary.data.entities.LearningRecord record, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}