package com.example.cet6vocabulary.data.dao;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.cet6vocabulary.data.entities.LearningRecord;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Float;
import java.lang.Integer;
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
public final class LearningRecordDao_Impl implements LearningRecordDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<LearningRecord> __insertionAdapterOfLearningRecord;

  public LearningRecordDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfLearningRecord = new EntityInsertionAdapter<LearningRecord>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `learning_records` (`id`,`date`,`wordsLearned`,`wordsReviewed`,`masteryRate`) VALUES (nullif(?, 0),?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final LearningRecord entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getDate() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getDate());
        }
        statement.bindLong(3, entity.getWordsLearned());
        statement.bindLong(4, entity.getWordsReviewed());
        statement.bindDouble(5, entity.getMasteryRate());
      }
    };
  }

  @Override
  public Object insertRecord(final LearningRecord record, final Continuation<? super Unit> arg1) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfLearningRecord.insert(record);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, arg1);
  }

  @Override
  public Flow<List<LearningRecord>> getAllRecords() {
    final String _sql = "SELECT * FROM learning_records ORDER BY date DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"learning_records"}, new Callable<List<LearningRecord>>() {
      @Override
      @NonNull
      public List<LearningRecord> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final int _cursorIndexOfWordsLearned = CursorUtil.getColumnIndexOrThrow(_cursor, "wordsLearned");
          final int _cursorIndexOfWordsReviewed = CursorUtil.getColumnIndexOrThrow(_cursor, "wordsReviewed");
          final int _cursorIndexOfMasteryRate = CursorUtil.getColumnIndexOrThrow(_cursor, "masteryRate");
          final List<LearningRecord> _result = new ArrayList<LearningRecord>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final LearningRecord _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpDate;
            if (_cursor.isNull(_cursorIndexOfDate)) {
              _tmpDate = null;
            } else {
              _tmpDate = _cursor.getString(_cursorIndexOfDate);
            }
            final int _tmpWordsLearned;
            _tmpWordsLearned = _cursor.getInt(_cursorIndexOfWordsLearned);
            final int _tmpWordsReviewed;
            _tmpWordsReviewed = _cursor.getInt(_cursorIndexOfWordsReviewed);
            final float _tmpMasteryRate;
            _tmpMasteryRate = _cursor.getFloat(_cursorIndexOfMasteryRate);
            _item = new LearningRecord(_tmpId,_tmpDate,_tmpWordsLearned,_tmpWordsReviewed,_tmpMasteryRate);
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
  public Flow<LearningRecord> getRecordByDate(final String date) {
    final String _sql = "SELECT * FROM learning_records WHERE date = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (date == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, date);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[] {"learning_records"}, new Callable<LearningRecord>() {
      @Override
      @Nullable
      public LearningRecord call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final int _cursorIndexOfWordsLearned = CursorUtil.getColumnIndexOrThrow(_cursor, "wordsLearned");
          final int _cursorIndexOfWordsReviewed = CursorUtil.getColumnIndexOrThrow(_cursor, "wordsReviewed");
          final int _cursorIndexOfMasteryRate = CursorUtil.getColumnIndexOrThrow(_cursor, "masteryRate");
          final LearningRecord _result;
          if (_cursor.moveToFirst()) {
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpDate;
            if (_cursor.isNull(_cursorIndexOfDate)) {
              _tmpDate = null;
            } else {
              _tmpDate = _cursor.getString(_cursorIndexOfDate);
            }
            final int _tmpWordsLearned;
            _tmpWordsLearned = _cursor.getInt(_cursorIndexOfWordsLearned);
            final int _tmpWordsReviewed;
            _tmpWordsReviewed = _cursor.getInt(_cursorIndexOfWordsReviewed);
            final float _tmpMasteryRate;
            _tmpMasteryRate = _cursor.getFloat(_cursorIndexOfMasteryRate);
            _result = new LearningRecord(_tmpId,_tmpDate,_tmpWordsLearned,_tmpWordsReviewed,_tmpMasteryRate);
          } else {
            _result = null;
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
  public Flow<List<LearningRecord>> getRecordsByDateRange(final String startDate,
      final String endDate) {
    final String _sql = "SELECT * FROM learning_records WHERE date >= ? AND date <= ? ORDER BY date ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (startDate == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, startDate);
    }
    _argIndex = 2;
    if (endDate == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, endDate);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[] {"learning_records"}, new Callable<List<LearningRecord>>() {
      @Override
      @NonNull
      public List<LearningRecord> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final int _cursorIndexOfWordsLearned = CursorUtil.getColumnIndexOrThrow(_cursor, "wordsLearned");
          final int _cursorIndexOfWordsReviewed = CursorUtil.getColumnIndexOrThrow(_cursor, "wordsReviewed");
          final int _cursorIndexOfMasteryRate = CursorUtil.getColumnIndexOrThrow(_cursor, "masteryRate");
          final List<LearningRecord> _result = new ArrayList<LearningRecord>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final LearningRecord _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpDate;
            if (_cursor.isNull(_cursorIndexOfDate)) {
              _tmpDate = null;
            } else {
              _tmpDate = _cursor.getString(_cursorIndexOfDate);
            }
            final int _tmpWordsLearned;
            _tmpWordsLearned = _cursor.getInt(_cursorIndexOfWordsLearned);
            final int _tmpWordsReviewed;
            _tmpWordsReviewed = _cursor.getInt(_cursorIndexOfWordsReviewed);
            final float _tmpMasteryRate;
            _tmpMasteryRate = _cursor.getFloat(_cursorIndexOfMasteryRate);
            _item = new LearningRecord(_tmpId,_tmpDate,_tmpWordsLearned,_tmpWordsReviewed,_tmpMasteryRate);
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
  public Flow<Integer> getTotalWordsLearned(final String startDate, final String endDate) {
    final String _sql = "SELECT SUM(wordsLearned) FROM learning_records WHERE date >= ? AND date <= ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (startDate == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, startDate);
    }
    _argIndex = 2;
    if (endDate == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, endDate);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[] {"learning_records"}, new Callable<Integer>() {
      @Override
      @NonNull
      public Integer call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Integer _result;
          if (_cursor.moveToFirst()) {
            final Integer _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(0);
            }
            _result = _tmp;
          } else {
            _result = null;
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
  public Flow<Float> getAverageMasteryRate(final String startDate, final String endDate) {
    final String _sql = "SELECT AVG(masteryRate) FROM learning_records WHERE date >= ? AND date <= ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (startDate == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, startDate);
    }
    _argIndex = 2;
    if (endDate == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, endDate);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[] {"learning_records"}, new Callable<Float>() {
      @Override
      @NonNull
      public Float call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Float _result;
          if (_cursor.moveToFirst()) {
            final Float _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getFloat(0);
            }
            _result = _tmp;
          } else {
            _result = null;
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
