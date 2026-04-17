package com.example.cet6vocabulary.data.dao;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H\'J\u001e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\'J\u0018\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00032\u0006\u0010\f\u001a\u00020\tH\'J$\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\'J\u001e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\'J\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0013\u00a8\u0006\u0014"}, d2 = {"Lcom/example/cet6vocabulary/data/dao/LearningRecordDao;", "", "getAllRecords", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/example/cet6vocabulary/data/entities/LearningRecord;", "getAverageMasteryRate", "", "startDate", "", "endDate", "getRecordByDate", "date", "getRecordsByDateRange", "getTotalWordsLearned", "", "insertRecord", "", "record", "(Lcom/example/cet6vocabulary/data/entities/LearningRecord;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
@androidx.room.Dao
public abstract interface LearningRecordDao {
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object insertRecord(@org.jetbrains.annotations.NotNull
    com.example.cet6vocabulary.data.entities.LearningRecord record, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM learning_records ORDER BY date DESC")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.example.cet6vocabulary.data.entities.LearningRecord>> getAllRecords();
    
    @androidx.room.Query(value = "SELECT * FROM learning_records WHERE date = :date")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<com.example.cet6vocabulary.data.entities.LearningRecord> getRecordByDate(@org.jetbrains.annotations.NotNull
    java.lang.String date);
    
    @androidx.room.Query(value = "SELECT * FROM learning_records WHERE date >= :startDate AND date <= :endDate ORDER BY date ASC")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.example.cet6vocabulary.data.entities.LearningRecord>> getRecordsByDateRange(@org.jetbrains.annotations.NotNull
    java.lang.String startDate, @org.jetbrains.annotations.NotNull
    java.lang.String endDate);
    
    @androidx.room.Query(value = "SELECT SUM(wordsLearned) FROM learning_records WHERE date >= :startDate AND date <= :endDate")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.lang.Integer> getTotalWordsLearned(@org.jetbrains.annotations.NotNull
    java.lang.String startDate, @org.jetbrains.annotations.NotNull
    java.lang.String endDate);
    
    @androidx.room.Query(value = "SELECT AVG(masteryRate) FROM learning_records WHERE date >= :startDate AND date <= :endDate")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.lang.Float> getAverageMasteryRate(@org.jetbrains.annotations.NotNull
    java.lang.String startDate, @org.jetbrains.annotations.NotNull
    java.lang.String endDate);
}