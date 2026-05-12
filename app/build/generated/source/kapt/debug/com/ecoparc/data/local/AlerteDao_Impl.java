package com.ecoparc.data.local;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.ecoparc.data.model.Alerte;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Integer;
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

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class AlerteDao_Impl implements AlerteDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Alerte> __insertionAdapterOfAlerte;

  private final EntityDeletionOrUpdateAdapter<Alerte> __deletionAdapterOfAlerte;

  private final SharedSQLiteStatement __preparedStmtOfMarquerCommeLue;

  private final SharedSQLiteStatement __preparedStmtOfMarquerToutesLues;

  private final SharedSQLiteStatement __preparedStmtOfDeleteOldAlertes;

  public AlerteDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfAlerte = new EntityInsertionAdapter<Alerte>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `alertes` (`id`,`especeId`,`especeNom`,`type`,`valeurMesuree`,`seuilDepasse`,`valeurSeuil`,`niveauAlerte`,`message`,`conseil`,`timestamp`,`estLue`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Alerte entity) {
        statement.bindLong(1, entity.getId());
        statement.bindLong(2, entity.getEspeceId());
        if (entity.getEspeceNom() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getEspeceNom());
        }
        if (entity.getType() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getType());
        }
        statement.bindDouble(5, entity.getValeurMesuree());
        if (entity.getSeuilDepasse() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getSeuilDepasse());
        }
        statement.bindDouble(7, entity.getValeurSeuil());
        statement.bindLong(8, entity.getNiveauAlerte());
        if (entity.getMessage() == null) {
          statement.bindNull(9);
        } else {
          statement.bindString(9, entity.getMessage());
        }
        if (entity.getConseil() == null) {
          statement.bindNull(10);
        } else {
          statement.bindString(10, entity.getConseil());
        }
        statement.bindLong(11, entity.getTimestamp());
        final int _tmp = entity.getEstLue() ? 1 : 0;
        statement.bindLong(12, _tmp);
      }
    };
    this.__deletionAdapterOfAlerte = new EntityDeletionOrUpdateAdapter<Alerte>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `alertes` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Alerte entity) {
        statement.bindLong(1, entity.getId());
      }
    };
    this.__preparedStmtOfMarquerCommeLue = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE alertes SET estLue = 1 WHERE id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfMarquerToutesLues = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE alertes SET estLue = 1";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteOldAlertes = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM alertes WHERE timestamp < ?";
        return _query;
      }
    };
  }

  @Override
  public Object insertAlerte(final Alerte alerte, final Continuation<? super Long> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      @NonNull
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          final Long _result = __insertionAdapterOfAlerte.insertAndReturnId(alerte);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteAlerte(final Alerte alerte, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfAlerte.handle(alerte);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object marquerCommeLue(final int id, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfMarquerCommeLue.acquire();
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, id);
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
          __preparedStmtOfMarquerCommeLue.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object marquerToutesLues(final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfMarquerToutesLues.acquire();
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
          __preparedStmtOfMarquerToutesLues.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteOldAlertes(final long timestamp,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteOldAlertes.acquire();
        int _argIndex = 1;
        _stmt.bindLong(_argIndex, timestamp);
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
          __preparedStmtOfDeleteOldAlertes.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public LiveData<List<Alerte>> getAllAlertes() {
    final String _sql = "SELECT * FROM alertes ORDER BY timestamp DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[] {"alertes"}, false, new Callable<List<Alerte>>() {
      @Override
      @Nullable
      public List<Alerte> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfEspeceId = CursorUtil.getColumnIndexOrThrow(_cursor, "especeId");
          final int _cursorIndexOfEspeceNom = CursorUtil.getColumnIndexOrThrow(_cursor, "especeNom");
          final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
          final int _cursorIndexOfValeurMesuree = CursorUtil.getColumnIndexOrThrow(_cursor, "valeurMesuree");
          final int _cursorIndexOfSeuilDepasse = CursorUtil.getColumnIndexOrThrow(_cursor, "seuilDepasse");
          final int _cursorIndexOfValeurSeuil = CursorUtil.getColumnIndexOrThrow(_cursor, "valeurSeuil");
          final int _cursorIndexOfNiveauAlerte = CursorUtil.getColumnIndexOrThrow(_cursor, "niveauAlerte");
          final int _cursorIndexOfMessage = CursorUtil.getColumnIndexOrThrow(_cursor, "message");
          final int _cursorIndexOfConseil = CursorUtil.getColumnIndexOrThrow(_cursor, "conseil");
          final int _cursorIndexOfTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "timestamp");
          final int _cursorIndexOfEstLue = CursorUtil.getColumnIndexOrThrow(_cursor, "estLue");
          final List<Alerte> _result = new ArrayList<Alerte>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Alerte _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final int _tmpEspeceId;
            _tmpEspeceId = _cursor.getInt(_cursorIndexOfEspeceId);
            final String _tmpEspeceNom;
            if (_cursor.isNull(_cursorIndexOfEspeceNom)) {
              _tmpEspeceNom = null;
            } else {
              _tmpEspeceNom = _cursor.getString(_cursorIndexOfEspeceNom);
            }
            final String _tmpType;
            if (_cursor.isNull(_cursorIndexOfType)) {
              _tmpType = null;
            } else {
              _tmpType = _cursor.getString(_cursorIndexOfType);
            }
            final double _tmpValeurMesuree;
            _tmpValeurMesuree = _cursor.getDouble(_cursorIndexOfValeurMesuree);
            final String _tmpSeuilDepasse;
            if (_cursor.isNull(_cursorIndexOfSeuilDepasse)) {
              _tmpSeuilDepasse = null;
            } else {
              _tmpSeuilDepasse = _cursor.getString(_cursorIndexOfSeuilDepasse);
            }
            final double _tmpValeurSeuil;
            _tmpValeurSeuil = _cursor.getDouble(_cursorIndexOfValeurSeuil);
            final int _tmpNiveauAlerte;
            _tmpNiveauAlerte = _cursor.getInt(_cursorIndexOfNiveauAlerte);
            final String _tmpMessage;
            if (_cursor.isNull(_cursorIndexOfMessage)) {
              _tmpMessage = null;
            } else {
              _tmpMessage = _cursor.getString(_cursorIndexOfMessage);
            }
            final String _tmpConseil;
            if (_cursor.isNull(_cursorIndexOfConseil)) {
              _tmpConseil = null;
            } else {
              _tmpConseil = _cursor.getString(_cursorIndexOfConseil);
            }
            final long _tmpTimestamp;
            _tmpTimestamp = _cursor.getLong(_cursorIndexOfTimestamp);
            final boolean _tmpEstLue;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfEstLue);
            _tmpEstLue = _tmp != 0;
            _item = new Alerte(_tmpId,_tmpEspeceId,_tmpEspeceNom,_tmpType,_tmpValeurMesuree,_tmpSeuilDepasse,_tmpValeurSeuil,_tmpNiveauAlerte,_tmpMessage,_tmpConseil,_tmpTimestamp,_tmpEstLue);
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
  public LiveData<List<Alerte>> getAlertesNonLues() {
    final String _sql = "SELECT * FROM alertes WHERE estLue = 0 ORDER BY niveauAlerte DESC, timestamp DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[] {"alertes"}, false, new Callable<List<Alerte>>() {
      @Override
      @Nullable
      public List<Alerte> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfEspeceId = CursorUtil.getColumnIndexOrThrow(_cursor, "especeId");
          final int _cursorIndexOfEspeceNom = CursorUtil.getColumnIndexOrThrow(_cursor, "especeNom");
          final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
          final int _cursorIndexOfValeurMesuree = CursorUtil.getColumnIndexOrThrow(_cursor, "valeurMesuree");
          final int _cursorIndexOfSeuilDepasse = CursorUtil.getColumnIndexOrThrow(_cursor, "seuilDepasse");
          final int _cursorIndexOfValeurSeuil = CursorUtil.getColumnIndexOrThrow(_cursor, "valeurSeuil");
          final int _cursorIndexOfNiveauAlerte = CursorUtil.getColumnIndexOrThrow(_cursor, "niveauAlerte");
          final int _cursorIndexOfMessage = CursorUtil.getColumnIndexOrThrow(_cursor, "message");
          final int _cursorIndexOfConseil = CursorUtil.getColumnIndexOrThrow(_cursor, "conseil");
          final int _cursorIndexOfTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "timestamp");
          final int _cursorIndexOfEstLue = CursorUtil.getColumnIndexOrThrow(_cursor, "estLue");
          final List<Alerte> _result = new ArrayList<Alerte>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Alerte _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final int _tmpEspeceId;
            _tmpEspeceId = _cursor.getInt(_cursorIndexOfEspeceId);
            final String _tmpEspeceNom;
            if (_cursor.isNull(_cursorIndexOfEspeceNom)) {
              _tmpEspeceNom = null;
            } else {
              _tmpEspeceNom = _cursor.getString(_cursorIndexOfEspeceNom);
            }
            final String _tmpType;
            if (_cursor.isNull(_cursorIndexOfType)) {
              _tmpType = null;
            } else {
              _tmpType = _cursor.getString(_cursorIndexOfType);
            }
            final double _tmpValeurMesuree;
            _tmpValeurMesuree = _cursor.getDouble(_cursorIndexOfValeurMesuree);
            final String _tmpSeuilDepasse;
            if (_cursor.isNull(_cursorIndexOfSeuilDepasse)) {
              _tmpSeuilDepasse = null;
            } else {
              _tmpSeuilDepasse = _cursor.getString(_cursorIndexOfSeuilDepasse);
            }
            final double _tmpValeurSeuil;
            _tmpValeurSeuil = _cursor.getDouble(_cursorIndexOfValeurSeuil);
            final int _tmpNiveauAlerte;
            _tmpNiveauAlerte = _cursor.getInt(_cursorIndexOfNiveauAlerte);
            final String _tmpMessage;
            if (_cursor.isNull(_cursorIndexOfMessage)) {
              _tmpMessage = null;
            } else {
              _tmpMessage = _cursor.getString(_cursorIndexOfMessage);
            }
            final String _tmpConseil;
            if (_cursor.isNull(_cursorIndexOfConseil)) {
              _tmpConseil = null;
            } else {
              _tmpConseil = _cursor.getString(_cursorIndexOfConseil);
            }
            final long _tmpTimestamp;
            _tmpTimestamp = _cursor.getLong(_cursorIndexOfTimestamp);
            final boolean _tmpEstLue;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfEstLue);
            _tmpEstLue = _tmp != 0;
            _item = new Alerte(_tmpId,_tmpEspeceId,_tmpEspeceNom,_tmpType,_tmpValeurMesuree,_tmpSeuilDepasse,_tmpValeurSeuil,_tmpNiveauAlerte,_tmpMessage,_tmpConseil,_tmpTimestamp,_tmpEstLue);
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
  public LiveData<Integer> countAlertesNonLues() {
    final String _sql = "SELECT COUNT(*) FROM alertes WHERE estLue = 0";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[] {"alertes"}, false, new Callable<Integer>() {
      @Override
      @Nullable
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
  public LiveData<List<Alerte>> getAlertesForEspece(final int especeId) {
    final String _sql = "SELECT * FROM alertes WHERE especeId = ? ORDER BY timestamp DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, especeId);
    return __db.getInvalidationTracker().createLiveData(new String[] {"alertes"}, false, new Callable<List<Alerte>>() {
      @Override
      @Nullable
      public List<Alerte> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfEspeceId = CursorUtil.getColumnIndexOrThrow(_cursor, "especeId");
          final int _cursorIndexOfEspeceNom = CursorUtil.getColumnIndexOrThrow(_cursor, "especeNom");
          final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
          final int _cursorIndexOfValeurMesuree = CursorUtil.getColumnIndexOrThrow(_cursor, "valeurMesuree");
          final int _cursorIndexOfSeuilDepasse = CursorUtil.getColumnIndexOrThrow(_cursor, "seuilDepasse");
          final int _cursorIndexOfValeurSeuil = CursorUtil.getColumnIndexOrThrow(_cursor, "valeurSeuil");
          final int _cursorIndexOfNiveauAlerte = CursorUtil.getColumnIndexOrThrow(_cursor, "niveauAlerte");
          final int _cursorIndexOfMessage = CursorUtil.getColumnIndexOrThrow(_cursor, "message");
          final int _cursorIndexOfConseil = CursorUtil.getColumnIndexOrThrow(_cursor, "conseil");
          final int _cursorIndexOfTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "timestamp");
          final int _cursorIndexOfEstLue = CursorUtil.getColumnIndexOrThrow(_cursor, "estLue");
          final List<Alerte> _result = new ArrayList<Alerte>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Alerte _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final int _tmpEspeceId;
            _tmpEspeceId = _cursor.getInt(_cursorIndexOfEspeceId);
            final String _tmpEspeceNom;
            if (_cursor.isNull(_cursorIndexOfEspeceNom)) {
              _tmpEspeceNom = null;
            } else {
              _tmpEspeceNom = _cursor.getString(_cursorIndexOfEspeceNom);
            }
            final String _tmpType;
            if (_cursor.isNull(_cursorIndexOfType)) {
              _tmpType = null;
            } else {
              _tmpType = _cursor.getString(_cursorIndexOfType);
            }
            final double _tmpValeurMesuree;
            _tmpValeurMesuree = _cursor.getDouble(_cursorIndexOfValeurMesuree);
            final String _tmpSeuilDepasse;
            if (_cursor.isNull(_cursorIndexOfSeuilDepasse)) {
              _tmpSeuilDepasse = null;
            } else {
              _tmpSeuilDepasse = _cursor.getString(_cursorIndexOfSeuilDepasse);
            }
            final double _tmpValeurSeuil;
            _tmpValeurSeuil = _cursor.getDouble(_cursorIndexOfValeurSeuil);
            final int _tmpNiveauAlerte;
            _tmpNiveauAlerte = _cursor.getInt(_cursorIndexOfNiveauAlerte);
            final String _tmpMessage;
            if (_cursor.isNull(_cursorIndexOfMessage)) {
              _tmpMessage = null;
            } else {
              _tmpMessage = _cursor.getString(_cursorIndexOfMessage);
            }
            final String _tmpConseil;
            if (_cursor.isNull(_cursorIndexOfConseil)) {
              _tmpConseil = null;
            } else {
              _tmpConseil = _cursor.getString(_cursorIndexOfConseil);
            }
            final long _tmpTimestamp;
            _tmpTimestamp = _cursor.getLong(_cursorIndexOfTimestamp);
            final boolean _tmpEstLue;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfEstLue);
            _tmpEstLue = _tmp != 0;
            _item = new Alerte(_tmpId,_tmpEspeceId,_tmpEspeceNom,_tmpType,_tmpValeurMesuree,_tmpSeuilDepasse,_tmpValeurSeuil,_tmpNiveauAlerte,_tmpMessage,_tmpConseil,_tmpTimestamp,_tmpEstLue);
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
