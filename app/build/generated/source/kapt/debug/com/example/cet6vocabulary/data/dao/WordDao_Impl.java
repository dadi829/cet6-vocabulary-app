package com.example.cet6vocabulary.data.dao;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.cet6vocabulary.data.entities.Word;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class WordDao_Impl implements WordDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Word> __insertionAdapterOfWord;

  private final EntityDeletionOrUpdateAdapter<Word> __deletionAdapterOfWord;

  private final EntityDeletionOrUpdateAdapter<Word> __updateAdapterOfWord;

  private final SharedSQLiteStatement __preparedStmtOfUpdateWordMasteryStatus;

  private final SharedSQLiteStatement __preparedStmtOfUpdateVocabularyListStatus;

  public WordDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfWord = new EntityInsertionAdapter<Word>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `words` (`id`,`word`,`phonetic`,`partOfSpeech`,`definition`,`example`,`isMastered`,`isInVocabularyList`,`lastReviewedAt`,`reviewCount`,`nextReviewAt`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Word entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getWord() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getWord());
        }
        if (entity.getPhonetic() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getPhonetic());
        }
        if (entity.getPartOfSpeech() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getPartOfSpeech());
        }
        if (entity.getDefinition() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getDefinition());
        }
        if (entity.getExample() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getExample());
        }
        final int _tmp = entity.isMastered() ? 1 : 0;
        statement.bindLong(7, _tmp);
        final int _tmp_1 = entity.isInVocabularyList() ? 1 : 0;
        statement.bindLong(8, _tmp_1);
        if (entity.getLastReviewedAt() == null) {
          statement.bindNull(9);
        } else {
          statement.bindLong(9, entity.getLastReviewedAt());
        }
        statement.bindLong(10, entity.getReviewCount());
        if (entity.getNextReviewAt() == null) {
          statement.bindNull(11);
        } else {
          statement.bindLong(11, entity.getNextReviewAt());
        }
      }
    };
    this.__deletionAdapterOfWord = new EntityDeletionOrUpdateAdapter<Word>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `words` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Word entity) {
        statement.bindLong(1, entity.getId());
      }
    };
    this.__updateAdapterOfWord = new EntityDeletionOrUpdateAdapter<Word>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `words` SET `id` = ?,`word` = ?,`phonetic` = ?,`partOfSpeech` = ?,`definition` = ?,`example` = ?,`isMastered` = ?,`isInVocabularyList` = ?,`lastReviewedAt` = ?,`reviewCount` = ?,`nextReviewAt` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Word entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getWord() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getWord());
        }
        if (entity.getPhonetic() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getPhonetic());
        }
        if (entity.getPartOfSpeech() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getPartOfSpeech());
        }
        if (entity.getDefinition() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getDefinition());
        }
        if (entity.getExample() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getExample());
        }
        final int _tmp = entity.isMastered() ? 1 : 0;
        statement.bindLong(7, _tmp);
        final int _tmp_1 = entity.isInVocabularyList() ? 1 : 0;
        statement.bindLong(8, _tmp_1);
        if (entity.getLastReviewedAt() == null) {
          statement.bindNull(9);
        } else {
          statement.bindLong(9, entity.getLastReviewedAt());
        }
        statement.bindLong(10, entity.getReviewCount());
        if (entity.getNextReviewAt() == null) {
          statement.bindNull(11);
        } else {
          statement.bindLong(11, entity.getNextReviewAt());
        }
        statement.bindLong(12, entity.getId());
      }
    };
    this.__preparedStmtOfUpdateWordMasteryStatus = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE words SET isMastered = ?, lastReviewedAt = ?, reviewCount = reviewCount + 1, nextReviewAt = ? WHERE id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateVocabularyListStatus = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE words SET isInVocabularyList = ? WHERE id = ?";
        return _query;
      }
    };
  }

  @Override
  public Object insertWord(final Word word, final Continuation<? super Unit> arg1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfWord.insert(word);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, arg1);
  }

  @Override
  public Object deleteWord(final Word word, final Continuation<? super Unit> arg1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfWord.handle(word);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, arg1);
  }

  @Override
  public Object updateWord(final Word word, final Continuation<? super Unit> arg1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfWord.handle(word);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, arg1);
  }

  @Override
  public Object updateWordMasteryStatus(final int wordId, final boolean isMastered,
      final long lastReviewedAt, final Long nextReviewAt, final Continuation<? super Unit> arg4) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateWordMasteryStatus.acquire();
        int _argIndex = 1;
        final int _tmp = isMastered ? 1 : 0;
        _stmt.bindLong(_argIndex, _tmp);
        _argIndex = 2;
        _stmt.bindLong(_argIndex, lastReviewedAt);
        _argIndex = 3;
        if (nextReviewAt == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindLong(_argIndex, nextReviewAt);
        }
        _argIndex = 4;
        _stmt.bindLong(_argIndex, wordId);
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfUpdateWordMasteryStatus.release(_stmt);
        }
      }
    }, arg4);
  }

  @Override
  public Object updateVocabularyListStatus(final int wordId, final boolean isInVocabularyList,
      final Continuation<? super Unit> arg2) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateVocabularyListStatus.acquire();
        int _argIndex = 1;
        final int _tmp = isInVocabularyList ? 1 : 0;
        _stmt.bindLong(_argIndex, _tmp);
        _argIndex = 2;
        _stmt.bindLong(_argIndex, wordId);
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfUpdateVocabularyListStatus.release(_stmt);
        }
      }
    }, arg2);
  }

  @Override
  public Flow<List<Word>> getAllWords() {
    final String _sql = "SELECT * FROM words ORDER BY id ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"words"}, new Callable<List<Word>>() {
      @Override
      @NonNull
      public List<Word> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfWord = CursorUtil.getColumnIndexOrThrow(_cursor, "word");
          final int _cursorIndexOfPhonetic = CursorUtil.getColumnIndexOrThrow(_cursor, "phonetic");
          final int _cursorIndexOfPartOfSpeech = CursorUtil.getColumnIndexOrThrow(_cursor, "partOfSpeech");
          final int _cursorIndexOfDefinition = CursorUtil.getColumnIndexOrThrow(_cursor, "definition");
          final int _cursorIndexOfExample = CursorUtil.getColumnIndexOrThrow(_cursor, "example");
          final int _cursorIndexOfIsMastered = CursorUtil.getColumnIndexOrThrow(_cursor, "isMastered");
          final int _cursorIndexOfIsInVocabularyList = CursorUtil.getColumnIndexOrThrow(_cursor, "isInVocabularyList");
          final int _cursorIndexOfLastReviewedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "lastReviewedAt");
          final int _cursorIndexOfReviewCount = CursorUtil.getColumnIndexOrThrow(_cursor, "reviewCount");
          final int _cursorIndexOfNextReviewAt = CursorUtil.getColumnIndexOrThrow(_cursor, "nextReviewAt");
          final List<Word> _result = new ArrayList<Word>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Word _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpWord;
            if (_cursor.isNull(_cursorIndexOfWord)) {
              _tmpWord = null;
            } else {
              _tmpWord = _cursor.getString(_cursorIndexOfWord);
            }
            final String _tmpPhonetic;
            if (_cursor.isNull(_cursorIndexOfPhonetic)) {
              _tmpPhonetic = null;
            } else {
              _tmpPhonetic = _cursor.getString(_cursorIndexOfPhonetic);
            }
            final String _tmpPartOfSpeech;
            if (_cursor.isNull(_cursorIndexOfPartOfSpeech)) {
              _tmpPartOfSpeech = null;
            } else {
              _tmpPartOfSpeech = _cursor.getString(_cursorIndexOfPartOfSpeech);
            }
            final String _tmpDefinition;
            if (_cursor.isNull(_cursorIndexOfDefinition)) {
              _tmpDefinition = null;
            } else {
              _tmpDefinition = _cursor.getString(_cursorIndexOfDefinition);
            }
            final String _tmpExample;
            if (_cursor.isNull(_cursorIndexOfExample)) {
              _tmpExample = null;
            } else {
              _tmpExample = _cursor.getString(_cursorIndexOfExample);
            }
            final boolean _tmpIsMastered;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsMastered);
            _tmpIsMastered = _tmp != 0;
            final boolean _tmpIsInVocabularyList;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsInVocabularyList);
            _tmpIsInVocabularyList = _tmp_1 != 0;
            final Long _tmpLastReviewedAt;
            if (_cursor.isNull(_cursorIndexOfLastReviewedAt)) {
              _tmpLastReviewedAt = null;
            } else {
              _tmpLastReviewedAt = _cursor.getLong(_cursorIndexOfLastReviewedAt);
            }
            final int _tmpReviewCount;
            _tmpReviewCount = _cursor.getInt(_cursorIndexOfReviewCount);
            final Long _tmpNextReviewAt;
            if (_cursor.isNull(_cursorIndexOfNextReviewAt)) {
              _tmpNextReviewAt = null;
            } else {
              _tmpNextReviewAt = _cursor.getLong(_cursorIndexOfNextReviewAt);
            }
            _item = new Word(_tmpId,_tmpWord,_tmpPhonetic,_tmpPartOfSpeech,_tmpDefinition,_tmpExample,_tmpIsMastered,_tmpIsInVocabularyList,_tmpLastReviewedAt,_tmpReviewCount,_tmpNextReviewAt);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<List<Word>> getWordsByMasteredStatus(final boolean isMastered) {
    final String _sql = "SELECT * FROM words WHERE isMastered = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    final int _tmp = isMastered ? 1 : 0;
    _statement.bindLong(_argIndex, _tmp);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"words"}, new Callable<List<Word>>() {
      @Override
      @NonNull
      public List<Word> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfWord = CursorUtil.getColumnIndexOrThrow(_cursor, "word");
          final int _cursorIndexOfPhonetic = CursorUtil.getColumnIndexOrThrow(_cursor, "phonetic");
          final int _cursorIndexOfPartOfSpeech = CursorUtil.getColumnIndexOrThrow(_cursor, "partOfSpeech");
          final int _cursorIndexOfDefinition = CursorUtil.getColumnIndexOrThrow(_cursor, "definition");
          final int _cursorIndexOfExample = CursorUtil.getColumnIndexOrThrow(_cursor, "example");
          final int _cursorIndexOfIsMastered = CursorUtil.getColumnIndexOrThrow(_cursor, "isMastered");
          final int _cursorIndexOfIsInVocabularyList = CursorUtil.getColumnIndexOrThrow(_cursor, "isInVocabularyList");
          final int _cursorIndexOfLastReviewedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "lastReviewedAt");
          final int _cursorIndexOfReviewCount = CursorUtil.getColumnIndexOrThrow(_cursor, "reviewCount");
          final int _cursorIndexOfNextReviewAt = CursorUtil.getColumnIndexOrThrow(_cursor, "nextReviewAt");
          final List<Word> _result = new ArrayList<Word>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Word _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpWord;
            if (_cursor.isNull(_cursorIndexOfWord)) {
              _tmpWord = null;
            } else {
              _tmpWord = _cursor.getString(_cursorIndexOfWord);
            }
            final String _tmpPhonetic;
            if (_cursor.isNull(_cursorIndexOfPhonetic)) {
              _tmpPhonetic = null;
            } else {
              _tmpPhonetic = _cursor.getString(_cursorIndexOfPhonetic);
            }
            final String _tmpPartOfSpeech;
            if (_cursor.isNull(_cursorIndexOfPartOfSpeech)) {
              _tmpPartOfSpeech = null;
            } else {
              _tmpPartOfSpeech = _cursor.getString(_cursorIndexOfPartOfSpeech);
            }
            final String _tmpDefinition;
            if (_cursor.isNull(_cursorIndexOfDefinition)) {
              _tmpDefinition = null;
            } else {
              _tmpDefinition = _cursor.getString(_cursorIndexOfDefinition);
            }
            final String _tmpExample;
            if (_cursor.isNull(_cursorIndexOfExample)) {
              _tmpExample = null;
            } else {
              _tmpExample = _cursor.getString(_cursorIndexOfExample);
            }
            final boolean _tmpIsMastered;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsMastered);
            _tmpIsMastered = _tmp_1 != 0;
            final boolean _tmpIsInVocabularyList;
            final int _tmp_2;
            _tmp_2 = _cursor.getInt(_cursorIndexOfIsInVocabularyList);
            _tmpIsInVocabularyList = _tmp_2 != 0;
            final Long _tmpLastReviewedAt;
            if (_cursor.isNull(_cursorIndexOfLastReviewedAt)) {
              _tmpLastReviewedAt = null;
            } else {
              _tmpLastReviewedAt = _cursor.getLong(_cursorIndexOfLastReviewedAt);
            }
            final int _tmpReviewCount;
            _tmpReviewCount = _cursor.getInt(_cursorIndexOfReviewCount);
            final Long _tmpNextReviewAt;
            if (_cursor.isNull(_cursorIndexOfNextReviewAt)) {
              _tmpNextReviewAt = null;
            } else {
              _tmpNextReviewAt = _cursor.getLong(_cursorIndexOfNextReviewAt);
            }
            _item = new Word(_tmpId,_tmpWord,_tmpPhonetic,_tmpPartOfSpeech,_tmpDefinition,_tmpExample,_tmpIsMastered,_tmpIsInVocabularyList,_tmpLastReviewedAt,_tmpReviewCount,_tmpNextReviewAt);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<List<Word>> getVocabularyListWords(final boolean isInVocabularyList) {
    final String _sql = "SELECT * FROM words WHERE isInVocabularyList = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    final int _tmp = isInVocabularyList ? 1 : 0;
    _statement.bindLong(_argIndex, _tmp);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"words"}, new Callable<List<Word>>() {
      @Override
      @NonNull
      public List<Word> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfWord = CursorUtil.getColumnIndexOrThrow(_cursor, "word");
          final int _cursorIndexOfPhonetic = CursorUtil.getColumnIndexOrThrow(_cursor, "phonetic");
          final int _cursorIndexOfPartOfSpeech = CursorUtil.getColumnIndexOrThrow(_cursor, "partOfSpeech");
          final int _cursorIndexOfDefinition = CursorUtil.getColumnIndexOrThrow(_cursor, "definition");
          final int _cursorIndexOfExample = CursorUtil.getColumnIndexOrThrow(_cursor, "example");
          final int _cursorIndexOfIsMastered = CursorUtil.getColumnIndexOrThrow(_cursor, "isMastered");
          final int _cursorIndexOfIsInVocabularyList = CursorUtil.getColumnIndexOrThrow(_cursor, "isInVocabularyList");
          final int _cursorIndexOfLastReviewedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "lastReviewedAt");
          final int _cursorIndexOfReviewCount = CursorUtil.getColumnIndexOrThrow(_cursor, "reviewCount");
          final int _cursorIndexOfNextReviewAt = CursorUtil.getColumnIndexOrThrow(_cursor, "nextReviewAt");
          final List<Word> _result = new ArrayList<Word>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Word _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpWord;
            if (_cursor.isNull(_cursorIndexOfWord)) {
              _tmpWord = null;
            } else {
              _tmpWord = _cursor.getString(_cursorIndexOfWord);
            }
            final String _tmpPhonetic;
            if (_cursor.isNull(_cursorIndexOfPhonetic)) {
              _tmpPhonetic = null;
            } else {
              _tmpPhonetic = _cursor.getString(_cursorIndexOfPhonetic);
            }
            final String _tmpPartOfSpeech;
            if (_cursor.isNull(_cursorIndexOfPartOfSpeech)) {
              _tmpPartOfSpeech = null;
            } else {
              _tmpPartOfSpeech = _cursor.getString(_cursorIndexOfPartOfSpeech);
            }
            final String _tmpDefinition;
            if (_cursor.isNull(_cursorIndexOfDefinition)) {
              _tmpDefinition = null;
            } else {
              _tmpDefinition = _cursor.getString(_cursorIndexOfDefinition);
            }
            final String _tmpExample;
            if (_cursor.isNull(_cursorIndexOfExample)) {
              _tmpExample = null;
            } else {
              _tmpExample = _cursor.getString(_cursorIndexOfExample);
            }
            final boolean _tmpIsMastered;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsMastered);
            _tmpIsMastered = _tmp_1 != 0;
            final boolean _tmpIsInVocabularyList;
            final int _tmp_2;
            _tmp_2 = _cursor.getInt(_cursorIndexOfIsInVocabularyList);
            _tmpIsInVocabularyList = _tmp_2 != 0;
            final Long _tmpLastReviewedAt;
            if (_cursor.isNull(_cursorIndexOfLastReviewedAt)) {
              _tmpLastReviewedAt = null;
            } else {
              _tmpLastReviewedAt = _cursor.getLong(_cursorIndexOfLastReviewedAt);
            }
            final int _tmpReviewCount;
            _tmpReviewCount = _cursor.getInt(_cursorIndexOfReviewCount);
            final Long _tmpNextReviewAt;
            if (_cursor.isNull(_cursorIndexOfNextReviewAt)) {
              _tmpNextReviewAt = null;
            } else {
              _tmpNextReviewAt = _cursor.getLong(_cursorIndexOfNextReviewAt);
            }
            _item = new Word(_tmpId,_tmpWord,_tmpPhonetic,_tmpPartOfSpeech,_tmpDefinition,_tmpExample,_tmpIsMastered,_tmpIsInVocabularyList,_tmpLastReviewedAt,_tmpReviewCount,_tmpNextReviewAt);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<List<Word>> getWordsForReview(final long currentTime) {
    final String _sql = "SELECT * FROM words WHERE nextReviewAt <= ? AND nextReviewAt IS NOT NULL";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, currentTime);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"words"}, new Callable<List<Word>>() {
      @Override
      @NonNull
      public List<Word> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfWord = CursorUtil.getColumnIndexOrThrow(_cursor, "word");
          final int _cursorIndexOfPhonetic = CursorUtil.getColumnIndexOrThrow(_cursor, "phonetic");
          final int _cursorIndexOfPartOfSpeech = CursorUtil.getColumnIndexOrThrow(_cursor, "partOfSpeech");
          final int _cursorIndexOfDefinition = CursorUtil.getColumnIndexOrThrow(_cursor, "definition");
          final int _cursorIndexOfExample = CursorUtil.getColumnIndexOrThrow(_cursor, "example");
          final int _cursorIndexOfIsMastered = CursorUtil.getColumnIndexOrThrow(_cursor, "isMastered");
          final int _cursorIndexOfIsInVocabularyList = CursorUtil.getColumnIndexOrThrow(_cursor, "isInVocabularyList");
          final int _cursorIndexOfLastReviewedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "lastReviewedAt");
          final int _cursorIndexOfReviewCount = CursorUtil.getColumnIndexOrThrow(_cursor, "reviewCount");
          final int _cursorIndexOfNextReviewAt = CursorUtil.getColumnIndexOrThrow(_cursor, "nextReviewAt");
          final List<Word> _result = new ArrayList<Word>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Word _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpWord;
            if (_cursor.isNull(_cursorIndexOfWord)) {
              _tmpWord = null;
            } else {
              _tmpWord = _cursor.getString(_cursorIndexOfWord);
            }
            final String _tmpPhonetic;
            if (_cursor.isNull(_cursorIndexOfPhonetic)) {
              _tmpPhonetic = null;
            } else {
              _tmpPhonetic = _cursor.getString(_cursorIndexOfPhonetic);
            }
            final String _tmpPartOfSpeech;
            if (_cursor.isNull(_cursorIndexOfPartOfSpeech)) {
              _tmpPartOfSpeech = null;
            } else {
              _tmpPartOfSpeech = _cursor.getString(_cursorIndexOfPartOfSpeech);
            }
            final String _tmpDefinition;
            if (_cursor.isNull(_cursorIndexOfDefinition)) {
              _tmpDefinition = null;
            } else {
              _tmpDefinition = _cursor.getString(_cursorIndexOfDefinition);
            }
            final String _tmpExample;
            if (_cursor.isNull(_cursorIndexOfExample)) {
              _tmpExample = null;
            } else {
              _tmpExample = _cursor.getString(_cursorIndexOfExample);
            }
            final boolean _tmpIsMastered;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsMastered);
            _tmpIsMastered = _tmp != 0;
            final boolean _tmpIsInVocabularyList;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsInVocabularyList);
            _tmpIsInVocabularyList = _tmp_1 != 0;
            final Long _tmpLastReviewedAt;
            if (_cursor.isNull(_cursorIndexOfLastReviewedAt)) {
              _tmpLastReviewedAt = null;
            } else {
              _tmpLastReviewedAt = _cursor.getLong(_cursorIndexOfLastReviewedAt);
            }
            final int _tmpReviewCount;
            _tmpReviewCount = _cursor.getInt(_cursorIndexOfReviewCount);
            final Long _tmpNextReviewAt;
            if (_cursor.isNull(_cursorIndexOfNextReviewAt)) {
              _tmpNextReviewAt = null;
            } else {
              _tmpNextReviewAt = _cursor.getLong(_cursorIndexOfNextReviewAt);
            }
            _item = new Word(_tmpId,_tmpWord,_tmpPhonetic,_tmpPartOfSpeech,_tmpDefinition,_tmpExample,_tmpIsMastered,_tmpIsInVocabularyList,_tmpLastReviewedAt,_tmpReviewCount,_tmpNextReviewAt);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<List<Word>> searchWords(final String searchQuery) {
    final String _sql = "SELECT * FROM words WHERE word LIKE ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (searchQuery == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, searchQuery);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[] {"words"}, new Callable<List<Word>>() {
      @Override
      @NonNull
      public List<Word> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfWord = CursorUtil.getColumnIndexOrThrow(_cursor, "word");
          final int _cursorIndexOfPhonetic = CursorUtil.getColumnIndexOrThrow(_cursor, "phonetic");
          final int _cursorIndexOfPartOfSpeech = CursorUtil.getColumnIndexOrThrow(_cursor, "partOfSpeech");
          final int _cursorIndexOfDefinition = CursorUtil.getColumnIndexOrThrow(_cursor, "definition");
          final int _cursorIndexOfExample = CursorUtil.getColumnIndexOrThrow(_cursor, "example");
          final int _cursorIndexOfIsMastered = CursorUtil.getColumnIndexOrThrow(_cursor, "isMastered");
          final int _cursorIndexOfIsInVocabularyList = CursorUtil.getColumnIndexOrThrow(_cursor, "isInVocabularyList");
          final int _cursorIndexOfLastReviewedAt = CursorUtil.getColumnIndexOrThrow(_cursor, "lastReviewedAt");
          final int _cursorIndexOfReviewCount = CursorUtil.getColumnIndexOrThrow(_cursor, "reviewCount");
          final int _cursorIndexOfNextReviewAt = CursorUtil.getColumnIndexOrThrow(_cursor, "nextReviewAt");
          final List<Word> _result = new ArrayList<Word>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Word _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpWord;
            if (_cursor.isNull(_cursorIndexOfWord)) {
              _tmpWord = null;
            } else {
              _tmpWord = _cursor.getString(_cursorIndexOfWord);
            }
            final String _tmpPhonetic;
            if (_cursor.isNull(_cursorIndexOfPhonetic)) {
              _tmpPhonetic = null;
            } else {
              _tmpPhonetic = _cursor.getString(_cursorIndexOfPhonetic);
            }
            final String _tmpPartOfSpeech;
            if (_cursor.isNull(_cursorIndexOfPartOfSpeech)) {
              _tmpPartOfSpeech = null;
            } else {
              _tmpPartOfSpeech = _cursor.getString(_cursorIndexOfPartOfSpeech);
            }
            final String _tmpDefinition;
            if (_cursor.isNull(_cursorIndexOfDefinition)) {
              _tmpDefinition = null;
            } else {
              _tmpDefinition = _cursor.getString(_cursorIndexOfDefinition);
            }
            final String _tmpExample;
            if (_cursor.isNull(_cursorIndexOfExample)) {
              _tmpExample = null;
            } else {
              _tmpExample = _cursor.getString(_cursorIndexOfExample);
            }
            final boolean _tmpIsMastered;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsMastered);
            _tmpIsMastered = _tmp != 0;
            final boolean _tmpIsInVocabularyList;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfIsInVocabularyList);
            _tmpIsInVocabularyList = _tmp_1 != 0;
            final Long _tmpLastReviewedAt;
            if (_cursor.isNull(_cursorIndexOfLastReviewedAt)) {
              _tmpLastReviewedAt = null;
            } else {
              _tmpLastReviewedAt = _cursor.getLong(_cursorIndexOfLastReviewedAt);
            }
            final int _tmpReviewCount;
            _tmpReviewCount = _cursor.getInt(_cursorIndexOfReviewCount);
            final Long _tmpNextReviewAt;
            if (_cursor.isNull(_cursorIndexOfNextReviewAt)) {
              _tmpNextReviewAt = null;
            } else {
              _tmpNextReviewAt = _cursor.getLong(_cursorIndexOfNextReviewAt);
            }
            _item = new Word(_tmpId,_tmpWord,_tmpPhonetic,_tmpPartOfSpeech,_tmpDefinition,_tmpExample,_tmpIsMastered,_tmpIsInVocabularyList,_tmpLastReviewedAt,_tmpReviewCount,_tmpNextReviewAt);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
