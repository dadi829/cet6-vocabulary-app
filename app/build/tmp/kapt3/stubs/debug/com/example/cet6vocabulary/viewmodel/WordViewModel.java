package com.example.cet6vocabulary.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\bJ\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u000e\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\bJ\u000e\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\bJ\u0006\u0010\u001f\u001a\u00020\u0017J\u0006\u0010 \u001a\u00020\u0017J\u0006\u0010!\u001a\u00020\u0017J\u000e\u0010\"\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\bJ\u000e\u0010#\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\bJ\u000e\u0010$\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\bJ\u000e\u0010%\u001a\u00020\u00172\u0006\u0010&\u001a\u00020\'R\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u001d\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u001d\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000f\u00a8\u0006("}, d2 = {"Lcom/example/cet6vocabulary/viewmodel/WordViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/example/cet6vocabulary/data/repository/WordRepository;", "(Lcom/example/cet6vocabulary/data/repository/WordRepository;)V", "_reviewWords", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lcom/example/cet6vocabulary/data/entities/Word;", "_searchResults", "_vocabularyList", "_words", "reviewWords", "Lkotlinx/coroutines/flow/StateFlow;", "getReviewWords", "()Lkotlinx/coroutines/flow/StateFlow;", "searchResults", "getSearchResults", "vocabularyList", "getVocabularyList", "words", "getWords", "addToVocabularyList", "", "word", "calculateNextReviewTime", "", "reviewCount", "", "deleteWord", "insertWord", "loadAllWords", "loadReviewWords", "loadVocabularyList", "markWordAsMastered", "markWordAsNotMastered", "removeFromVocabularyList", "searchWords", "query", "", "app_debug"})
public final class WordViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.example.cet6vocabulary.data.repository.WordRepository repository = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.example.cet6vocabulary.data.entities.Word>> _words = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.example.cet6vocabulary.data.entities.Word>> words = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.example.cet6vocabulary.data.entities.Word>> _vocabularyList = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.example.cet6vocabulary.data.entities.Word>> vocabularyList = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.example.cet6vocabulary.data.entities.Word>> _reviewWords = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.example.cet6vocabulary.data.entities.Word>> reviewWords = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<com.example.cet6vocabulary.data.entities.Word>> _searchResults = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.example.cet6vocabulary.data.entities.Word>> searchResults = null;
    
    public WordViewModel(@org.jetbrains.annotations.NotNull
    com.example.cet6vocabulary.data.repository.WordRepository repository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.example.cet6vocabulary.data.entities.Word>> getWords() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.example.cet6vocabulary.data.entities.Word>> getVocabularyList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.example.cet6vocabulary.data.entities.Word>> getReviewWords() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.example.cet6vocabulary.data.entities.Word>> getSearchResults() {
        return null;
    }
    
    public final void loadAllWords() {
    }
    
    public final void loadVocabularyList() {
    }
    
    public final void loadReviewWords() {
    }
    
    public final void searchWords(@org.jetbrains.annotations.NotNull
    java.lang.String query) {
    }
    
    public final void markWordAsMastered(@org.jetbrains.annotations.NotNull
    com.example.cet6vocabulary.data.entities.Word word) {
    }
    
    public final void markWordAsNotMastered(@org.jetbrains.annotations.NotNull
    com.example.cet6vocabulary.data.entities.Word word) {
    }
    
    public final void addToVocabularyList(@org.jetbrains.annotations.NotNull
    com.example.cet6vocabulary.data.entities.Word word) {
    }
    
    public final void removeFromVocabularyList(@org.jetbrains.annotations.NotNull
    com.example.cet6vocabulary.data.entities.Word word) {
    }
    
    private final long calculateNextReviewTime(int reviewCount) {
        return 0L;
    }
    
    public final void insertWord(@org.jetbrains.annotations.NotNull
    com.example.cet6vocabulary.data.entities.Word word) {
    }
    
    public final void deleteWord(@org.jetbrains.annotations.NotNull
    com.example.cet6vocabulary.data.entities.Word word) {
    }
}