package com.example.cet6vocabulary.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\nJ\u0006\u0010\u0018\u001a\u00020\u0016J\u0006\u0010\u0019\u001a\u00020\u0016J\u0006\u0010\u001a\u001a\u00020\u0016J\u0016\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001dJ\u0006\u0010\u001f\u001a\u00020\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\f0\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010\u00a8\u0006 "}, d2 = {"Lcom/example/cet6vocabulary/viewmodel/LearningRecordViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/example/cet6vocabulary/data/repository/WordRepository;", "(Lcom/example/cet6vocabulary/data/repository/WordRepository;)V", "_averageMasteryRate", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "_learningRecords", "", "Lcom/example/cet6vocabulary/data/entities/LearningRecord;", "_totalWordsLearned", "", "averageMasteryRate", "Lkotlinx/coroutines/flow/StateFlow;", "getAverageMasteryRate", "()Lkotlinx/coroutines/flow/StateFlow;", "learningRecords", "getLearningRecords", "totalWordsLearned", "getTotalWordsLearned", "addLearningRecord", "", "record", "calculateMonthlyStats", "calculateTodayStats", "calculateWeeklyStats", "getRecordsByDateRange", "startDate", "", "endDate", "loadLearningRecords", "app_debug"})
public final class LearningRecordViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.example.cet6vocabulary.data.repository.WordRepository repository = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.example.cet6vocabulary.data.entities.LearningRecord>> _learningRecords = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.example.cet6vocabulary.data.entities.LearningRecord>> learningRecords = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Integer> _totalWordsLearned = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Integer> totalWordsLearned = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Float> _averageMasteryRate = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Float> averageMasteryRate = null;
    
    public LearningRecordViewModel(@org.jetbrains.annotations.NotNull
    com.example.cet6vocabulary.data.repository.WordRepository repository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.example.cet6vocabulary.data.entities.LearningRecord>> getLearningRecords() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Integer> getTotalWordsLearned() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Float> getAverageMasteryRate() {
        return null;
    }
    
    public final void loadLearningRecords() {
    }
    
    public final void calculateTodayStats() {
    }
    
    public final void calculateWeeklyStats() {
    }
    
    public final void calculateMonthlyStats() {
    }
    
    public final void addLearningRecord(@org.jetbrains.annotations.NotNull
    com.example.cet6vocabulary.data.entities.LearningRecord record) {
    }
    
    public final void getRecordsByDateRange(@org.jetbrains.annotations.NotNull
    java.lang.String startDate, @org.jetbrains.annotations.NotNull
    java.lang.String endDate) {
    }
}