package com.ecoparc.data.local;

import android.database.Cursor;
import android.os.CancellationSignal;
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
import com.ecoparc.data.model.Espece;
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
public final class EspeceDao_Impl implements EspeceDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Espece> __insertionAdapterOfEspece;

  private final EntityDeletionOrUpdateAdapter<Espece> __deletionAdapterOfEspece;

  private final EntityDeletionOrUpdateAdapter<Espece> __updateAdapterOfEspece;

  private final SharedSQLiteStatement __preparedStmtOfUpdateSyncStatus;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  public EspeceDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfEspece = new EntityInsertionAdapter<Espece>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `especes` (`id`,`nom`,`nomScientifique`,`statutConservation`,`populationEstimee`,`latitude`,`longitude`,`adresse`,`temperatureMin`,`temperatureMax`,`humiditeMin`,`humiditeMax`,`notes`,`dateCreation`,`dateModification`,`firebaseId`,`syncStatus`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Espece entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getNom() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getNom());
        }
        if (entity.getNomScientifique() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getNomScientifique());
        }
        if (entity.getStatutConservation() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getStatutConservation());
        }
        statement.bindLong(5, entity.getPopulationEstimee());
        statement.bindDouble(6, entity.getLatitude());
        statement.bindDouble(7, entity.getLongitude());
        if (entity.getAdresse() == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, entity.getAdresse());
        }
        statement.bindDouble(9, entity.getTemperatureMin());
        statement.bindDouble(10, entity.getTemperatureMax());
        statement.bindDouble(11, entity.getHumiditeMin());
        statement.bindDouble(12, entity.getHumiditeMax());
        if (entity.getNotes() == null) {
          statement.bindNull(13);
        } else {
          statement.bindString(13, entity.getNotes());
        }
        statement.bindLong(14, entity.getDateCreation());
        statement.bindLong(15, entity.getDateModification());
        if (entity.getFirebaseId() == null) {
          statement.bindNull(16);
        } else {
          statement.bindString(16, entity.getFirebaseId());
        }
        statement.bindLong(17, entity.getSyncStatus());
      }
    };
    this.__deletionAdapterOfEspece = new EntityDeletionOrUpdateAdapter<Espece>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `especes` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Espece entity) {
        statement.bindLong(1, entity.getId());
      }
    };
    this.__updateAdapterOfEspece = new EntityDeletionOrUpdateAdapter<Espece>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `especes` SET `id` = ?,`nom` = ?,`nomScientifique` = ?,`statutConservation` = ?,`populationEstimee` = ?,`latitude` = ?,`longitude` = ?,`adresse` = ?,`temperatureMin` = ?,`temperatureMax` = ?,`humiditeMin` = ?,`humiditeMax` = ?,`notes` = ?,`dateCreation` = ?,`dateModification` = ?,`firebaseId` = ?,`syncStatus` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Espece entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getNom() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getNom());
        }
        if (entity.getNomScientifique() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getNomScientifique());
        }
        if (entity.getStatutConservation() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getStatutConservation());
        }
        statement.bindLong(5, entity.getPopulationEstimee());
        statement.bindDouble(6, entity.getLatitude());
        statement.bindDouble(7, entity.getLongitude());
        if (entity.getAdresse() == null) {
          statement.bindNull(8);
        } else {
          statement.bindString(8, entity.getAdresse());
        }
        statement.bindDouble(9, entity.getTemperatureMin());
        statement.bindDouble(10, entity.getTemperatureMax());
        statement.bindDouble(11, entity.getHumiditeMin());
        statement.bindDouble(12, entity.getHumiditeMax());
        if (entity.getNotes() == null) {
          statement.bindNull(13);
        } else {
          statement.bindString(13, entity.getNotes());
        }
        statement.bindLong(14, entity.getDateCreation());
        statement.bindLong(15, entity.getDateModification());
        if (entity.getFirebaseId() == null) {
          statement.bindNull(16);
        } else {
          statement.bindString(16, entity.getFirebaseId());
        }
        statement.bindLong(17, entity.getSyncStatus());
        statement.bindLong(18, entity.getId());
      }
    };
    this.__preparedStmtOfUpdateSyncStatus = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE especes SET firebaseId = ?, syncStatus = ? WHERE id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM especes";
        return _query;
      }
    };
  }

  @Override
  public Object insertEspece(final Espece espece, final Continuation<? super Long> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      @NonNull
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          final Long _result = __insertionAdapterOfEspece.insertAndReturnId(espece);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object insertEspeces(final List<Espece> especes,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfEspece.insert(especes);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteEspece(final Espece espece, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfEspece.handle(espece);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updateEspece(final Espece espece, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfEspece.handle(espece);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updateSyncStatus(final int localId, final String firebaseId, final int status,
      final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateSyncStatus.acquire();
        int _argIndex = 1;
        if (firebaseId == null) {
          _stmt.bindNull(_argIndex);
        } else {
          _stmt.bindString(_argIndex, firebaseId);
        }
        _argIndex = 2;
        _stmt.bindLong(_argIndex, status);
        _argIndex = 3;
        _stmt.bindLong(_argIndex, localId);
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
          __preparedStmtOfUpdateSyncStatus.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteAll(final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAll.acquire();
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
          __preparedStmtOfDeleteAll.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public LiveData<List<Espece>> getAllEspeces() {
    final String _sql = "SELECT * FROM especes ORDER BY dateModification DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[] {"especes"}, false, new Callable<List<Espece>>() {
      @Override
      @Nullable
      public List<Espece> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfNom = CursorUtil.getColumnIndexOrThrow(_cursor, "nom");
          final int _cursorIndexOfNomScientifique = CursorUtil.getColumnIndexOrThrow(_cursor, "nomScientifique");
          final int _cursorIndexOfStatutConservation = CursorUtil.getColumnIndexOrThrow(_cursor, "statutConservation");
          final int _cursorIndexOfPopulationEstimee = CursorUtil.getColumnIndexOrThrow(_cursor, "populationEstimee");
          final int _cursorIndexOfLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "latitude");
          final int _cursorIndexOfLongitude = CursorUtil.getColumnIndexOrThrow(_cursor, "longitude");
          final int _cursorIndexOfAdresse = CursorUtil.getColumnIndexOrThrow(_cursor, "adresse");
          final int _cursorIndexOfTemperatureMin = CursorUtil.getColumnIndexOrThrow(_cursor, "temperatureMin");
          final int _cursorIndexOfTemperatureMax = CursorUtil.getColumnIndexOrThrow(_cursor, "temperatureMax");
          final int _cursorIndexOfHumiditeMin = CursorUtil.getColumnIndexOrThrow(_cursor, "humiditeMin");
          final int _cursorIndexOfHumiditeMax = CursorUtil.getColumnIndexOrThrow(_cursor, "humiditeMax");
          final int _cursorIndexOfNotes = CursorUtil.getColumnIndexOrThrow(_cursor, "notes");
          final int _cursorIndexOfDateCreation = CursorUtil.getColumnIndexOrThrow(_cursor, "dateCreation");
          final int _cursorIndexOfDateModification = CursorUtil.getColumnIndexOrThrow(_cursor, "dateModification");
          final int _cursorIndexOfFirebaseId = CursorUtil.getColumnIndexOrThrow(_cursor, "firebaseId");
          final int _cursorIndexOfSyncStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "syncStatus");
          final List<Espece> _result = new ArrayList<Espece>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Espece _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpNom;
            if (_cursor.isNull(_cursorIndexOfNom)) {
              _tmpNom = null;
            } else {
              _tmpNom = _cursor.getString(_cursorIndexOfNom);
            }
            final String _tmpNomScientifique;
            if (_cursor.isNull(_cursorIndexOfNomScientifique)) {
              _tmpNomScientifique = null;
            } else {
              _tmpNomScientifique = _cursor.getString(_cursorIndexOfNomScientifique);
            }
            final String _tmpStatutConservation;
            if (_cursor.isNull(_cursorIndexOfStatutConservation)) {
              _tmpStatutConservation = null;
            } else {
              _tmpStatutConservation = _cursor.getString(_cursorIndexOfStatutConservation);
            }
            final int _tmpPopulationEstimee;
            _tmpPopulationEstimee = _cursor.getInt(_cursorIndexOfPopulationEstimee);
            final double _tmpLatitude;
            _tmpLatitude = _cursor.getDouble(_cursorIndexOfLatitude);
            final double _tmpLongitude;
            _tmpLongitude = _cursor.getDouble(_cursorIndexOfLongitude);
            final String _tmpAdresse;
            if (_cursor.isNull(_cursorIndexOfAdresse)) {
              _tmpAdresse = null;
            } else {
              _tmpAdresse = _cursor.getString(_cursorIndexOfAdresse);
            }
            final double _tmpTemperatureMin;
            _tmpTemperatureMin = _cursor.getDouble(_cursorIndexOfTemperatureMin);
            final double _tmpTemperatureMax;
            _tmpTemperatureMax = _cursor.getDouble(_cursorIndexOfTemperatureMax);
            final double _tmpHumiditeMin;
            _tmpHumiditeMin = _cursor.getDouble(_cursorIndexOfHumiditeMin);
            final double _tmpHumiditeMax;
            _tmpHumiditeMax = _cursor.getDouble(_cursorIndexOfHumiditeMax);
            final String _tmpNotes;
            if (_cursor.isNull(_cursorIndexOfNotes)) {
              _tmpNotes = null;
            } else {
              _tmpNotes = _cursor.getString(_cursorIndexOfNotes);
            }
            final long _tmpDateCreation;
            _tmpDateCreation = _cursor.getLong(_cursorIndexOfDateCreation);
            final long _tmpDateModification;
            _tmpDateModification = _cursor.getLong(_cursorIndexOfDateModification);
            final String _tmpFirebaseId;
            if (_cursor.isNull(_cursorIndexOfFirebaseId)) {
              _tmpFirebaseId = null;
            } else {
              _tmpFirebaseId = _cursor.getString(_cursorIndexOfFirebaseId);
            }
            final int _tmpSyncStatus;
            _tmpSyncStatus = _cursor.getInt(_cursorIndexOfSyncStatus);
            _item = new Espece(_tmpId,_tmpNom,_tmpNomScientifique,_tmpStatutConservation,_tmpPopulationEstimee,_tmpLatitude,_tmpLongitude,_tmpAdresse,_tmpTemperatureMin,_tmpTemperatureMax,_tmpHumiditeMin,_tmpHumiditeMax,_tmpNotes,_tmpDateCreation,_tmpDateModification,_tmpFirebaseId,_tmpSyncStatus);
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
  public Object getAllEspecesList(final Continuation<? super List<Espece>> $completion) {
    final String _sql = "SELECT * FROM especes ORDER BY dateModification DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<Espece>>() {
      @Override
      @NonNull
      public List<Espece> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfNom = CursorUtil.getColumnIndexOrThrow(_cursor, "nom");
          final int _cursorIndexOfNomScientifique = CursorUtil.getColumnIndexOrThrow(_cursor, "nomScientifique");
          final int _cursorIndexOfStatutConservation = CursorUtil.getColumnIndexOrThrow(_cursor, "statutConservation");
          final int _cursorIndexOfPopulationEstimee = CursorUtil.getColumnIndexOrThrow(_cursor, "populationEstimee");
          final int _cursorIndexOfLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "latitude");
          final int _cursorIndexOfLongitude = CursorUtil.getColumnIndexOrThrow(_cursor, "longitude");
          final int _cursorIndexOfAdresse = CursorUtil.getColumnIndexOrThrow(_cursor, "adresse");
          final int _cursorIndexOfTemperatureMin = CursorUtil.getColumnIndexOrThrow(_cursor, "temperatureMin");
          final int _cursorIndexOfTemperatureMax = CursorUtil.getColumnIndexOrThrow(_cursor, "temperatureMax");
          final int _cursorIndexOfHumiditeMin = CursorUtil.getColumnIndexOrThrow(_cursor, "humiditeMin");
          final int _cursorIndexOfHumiditeMax = CursorUtil.getColumnIndexOrThrow(_cursor, "humiditeMax");
          final int _cursorIndexOfNotes = CursorUtil.getColumnIndexOrThrow(_cursor, "notes");
          final int _cursorIndexOfDateCreation = CursorUtil.getColumnIndexOrThrow(_cursor, "dateCreation");
          final int _cursorIndexOfDateModification = CursorUtil.getColumnIndexOrThrow(_cursor, "dateModification");
          final int _cursorIndexOfFirebaseId = CursorUtil.getColumnIndexOrThrow(_cursor, "firebaseId");
          final int _cursorIndexOfSyncStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "syncStatus");
          final List<Espece> _result = new ArrayList<Espece>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Espece _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpNom;
            if (_cursor.isNull(_cursorIndexOfNom)) {
              _tmpNom = null;
            } else {
              _tmpNom = _cursor.getString(_cursorIndexOfNom);
            }
            final String _tmpNomScientifique;
            if (_cursor.isNull(_cursorIndexOfNomScientifique)) {
              _tmpNomScientifique = null;
            } else {
              _tmpNomScientifique = _cursor.getString(_cursorIndexOfNomScientifique);
            }
            final String _tmpStatutConservation;
            if (_cursor.isNull(_cursorIndexOfStatutConservation)) {
              _tmpStatutConservation = null;
            } else {
              _tmpStatutConservation = _cursor.getString(_cursorIndexOfStatutConservation);
            }
            final int _tmpPopulationEstimee;
            _tmpPopulationEstimee = _cursor.getInt(_cursorIndexOfPopulationEstimee);
            final double _tmpLatitude;
            _tmpLatitude = _cursor.getDouble(_cursorIndexOfLatitude);
            final double _tmpLongitude;
            _tmpLongitude = _cursor.getDouble(_cursorIndexOfLongitude);
            final String _tmpAdresse;
            if (_cursor.isNull(_cursorIndexOfAdresse)) {
              _tmpAdresse = null;
            } else {
              _tmpAdresse = _cursor.getString(_cursorIndexOfAdresse);
            }
            final double _tmpTemperatureMin;
            _tmpTemperatureMin = _cursor.getDouble(_cursorIndexOfTemperatureMin);
            final double _tmpTemperatureMax;
            _tmpTemperatureMax = _cursor.getDouble(_cursorIndexOfTemperatureMax);
            final double _tmpHumiditeMin;
            _tmpHumiditeMin = _cursor.getDouble(_cursorIndexOfHumiditeMin);
            final double _tmpHumiditeMax;
            _tmpHumiditeMax = _cursor.getDouble(_cursorIndexOfHumiditeMax);
            final String _tmpNotes;
            if (_cursor.isNull(_cursorIndexOfNotes)) {
              _tmpNotes = null;
            } else {
              _tmpNotes = _cursor.getString(_cursorIndexOfNotes);
            }
            final long _tmpDateCreation;
            _tmpDateCreation = _cursor.getLong(_cursorIndexOfDateCreation);
            final long _tmpDateModification;
            _tmpDateModification = _cursor.getLong(_cursorIndexOfDateModification);
            final String _tmpFirebaseId;
            if (_cursor.isNull(_cursorIndexOfFirebaseId)) {
              _tmpFirebaseId = null;
            } else {
              _tmpFirebaseId = _cursor.getString(_cursorIndexOfFirebaseId);
            }
            final int _tmpSyncStatus;
            _tmpSyncStatus = _cursor.getInt(_cursorIndexOfSyncStatus);
            _item = new Espece(_tmpId,_tmpNom,_tmpNomScientifique,_tmpStatutConservation,_tmpPopulationEstimee,_tmpLatitude,_tmpLongitude,_tmpAdresse,_tmpTemperatureMin,_tmpTemperatureMax,_tmpHumiditeMin,_tmpHumiditeMax,_tmpNotes,_tmpDateCreation,_tmpDateModification,_tmpFirebaseId,_tmpSyncStatus);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public LiveData<Espece> getEspeceById(final int id) {
    final String _sql = "SELECT * FROM especes WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    return __db.getInvalidationTracker().createLiveData(new String[] {"especes"}, false, new Callable<Espece>() {
      @Override
      @Nullable
      public Espece call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfNom = CursorUtil.getColumnIndexOrThrow(_cursor, "nom");
          final int _cursorIndexOfNomScientifique = CursorUtil.getColumnIndexOrThrow(_cursor, "nomScientifique");
          final int _cursorIndexOfStatutConservation = CursorUtil.getColumnIndexOrThrow(_cursor, "statutConservation");
          final int _cursorIndexOfPopulationEstimee = CursorUtil.getColumnIndexOrThrow(_cursor, "populationEstimee");
          final int _cursorIndexOfLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "latitude");
          final int _cursorIndexOfLongitude = CursorUtil.getColumnIndexOrThrow(_cursor, "longitude");
          final int _cursorIndexOfAdresse = CursorUtil.getColumnIndexOrThrow(_cursor, "adresse");
          final int _cursorIndexOfTemperatureMin = CursorUtil.getColumnIndexOrThrow(_cursor, "temperatureMin");
          final int _cursorIndexOfTemperatureMax = CursorUtil.getColumnIndexOrThrow(_cursor, "temperatureMax");
          final int _cursorIndexOfHumiditeMin = CursorUtil.getColumnIndexOrThrow(_cursor, "humiditeMin");
          final int _cursorIndexOfHumiditeMax = CursorUtil.getColumnIndexOrThrow(_cursor, "humiditeMax");
          final int _cursorIndexOfNotes = CursorUtil.getColumnIndexOrThrow(_cursor, "notes");
          final int _cursorIndexOfDateCreation = CursorUtil.getColumnIndexOrThrow(_cursor, "dateCreation");
          final int _cursorIndexOfDateModification = CursorUtil.getColumnIndexOrThrow(_cursor, "dateModification");
          final int _cursorIndexOfFirebaseId = CursorUtil.getColumnIndexOrThrow(_cursor, "firebaseId");
          final int _cursorIndexOfSyncStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "syncStatus");
          final Espece _result;
          if (_cursor.moveToFirst()) {
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpNom;
            if (_cursor.isNull(_cursorIndexOfNom)) {
              _tmpNom = null;
            } else {
              _tmpNom = _cursor.getString(_cursorIndexOfNom);
            }
            final String _tmpNomScientifique;
            if (_cursor.isNull(_cursorIndexOfNomScientifique)) {
              _tmpNomScientifique = null;
            } else {
              _tmpNomScientifique = _cursor.getString(_cursorIndexOfNomScientifique);
            }
            final String _tmpStatutConservation;
            if (_cursor.isNull(_cursorIndexOfStatutConservation)) {
              _tmpStatutConservation = null;
            } else {
              _tmpStatutConservation = _cursor.getString(_cursorIndexOfStatutConservation);
            }
            final int _tmpPopulationEstimee;
            _tmpPopulationEstimee = _cursor.getInt(_cursorIndexOfPopulationEstimee);
            final double _tmpLatitude;
            _tmpLatitude = _cursor.getDouble(_cursorIndexOfLatitude);
            final double _tmpLongitude;
            _tmpLongitude = _cursor.getDouble(_cursorIndexOfLongitude);
            final String _tmpAdresse;
            if (_cursor.isNull(_cursorIndexOfAdresse)) {
              _tmpAdresse = null;
            } else {
              _tmpAdresse = _cursor.getString(_cursorIndexOfAdresse);
            }
            final double _tmpTemperatureMin;
            _tmpTemperatureMin = _cursor.getDouble(_cursorIndexOfTemperatureMin);
            final double _tmpTemperatureMax;
            _tmpTemperatureMax = _cursor.getDouble(_cursorIndexOfTemperatureMax);
            final double _tmpHumiditeMin;
            _tmpHumiditeMin = _cursor.getDouble(_cursorIndexOfHumiditeMin);
            final double _tmpHumiditeMax;
            _tmpHumiditeMax = _cursor.getDouble(_cursorIndexOfHumiditeMax);
            final String _tmpNotes;
            if (_cursor.isNull(_cursorIndexOfNotes)) {
              _tmpNotes = null;
            } else {
              _tmpNotes = _cursor.getString(_cursorIndexOfNotes);
            }
            final long _tmpDateCreation;
            _tmpDateCreation = _cursor.getLong(_cursorIndexOfDateCreation);
            final long _tmpDateModification;
            _tmpDateModification = _cursor.getLong(_cursorIndexOfDateModification);
            final String _tmpFirebaseId;
            if (_cursor.isNull(_cursorIndexOfFirebaseId)) {
              _tmpFirebaseId = null;
            } else {
              _tmpFirebaseId = _cursor.getString(_cursorIndexOfFirebaseId);
            }
            final int _tmpSyncStatus;
            _tmpSyncStatus = _cursor.getInt(_cursorIndexOfSyncStatus);
            _result = new Espece(_tmpId,_tmpNom,_tmpNomScientifique,_tmpStatutConservation,_tmpPopulationEstimee,_tmpLatitude,_tmpLongitude,_tmpAdresse,_tmpTemperatureMin,_tmpTemperatureMax,_tmpHumiditeMin,_tmpHumiditeMax,_tmpNotes,_tmpDateCreation,_tmpDateModification,_tmpFirebaseId,_tmpSyncStatus);
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
  public Object getEspeceByIdSync(final int id, final Continuation<? super Espece> $completion) {
    final String _sql = "SELECT * FROM especes WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Espece>() {
      @Override
      @Nullable
      public Espece call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfNom = CursorUtil.getColumnIndexOrThrow(_cursor, "nom");
          final int _cursorIndexOfNomScientifique = CursorUtil.getColumnIndexOrThrow(_cursor, "nomScientifique");
          final int _cursorIndexOfStatutConservation = CursorUtil.getColumnIndexOrThrow(_cursor, "statutConservation");
          final int _cursorIndexOfPopulationEstimee = CursorUtil.getColumnIndexOrThrow(_cursor, "populationEstimee");
          final int _cursorIndexOfLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "latitude");
          final int _cursorIndexOfLongitude = CursorUtil.getColumnIndexOrThrow(_cursor, "longitude");
          final int _cursorIndexOfAdresse = CursorUtil.getColumnIndexOrThrow(_cursor, "adresse");
          final int _cursorIndexOfTemperatureMin = CursorUtil.getColumnIndexOrThrow(_cursor, "temperatureMin");
          final int _cursorIndexOfTemperatureMax = CursorUtil.getColumnIndexOrThrow(_cursor, "temperatureMax");
          final int _cursorIndexOfHumiditeMin = CursorUtil.getColumnIndexOrThrow(_cursor, "humiditeMin");
          final int _cursorIndexOfHumiditeMax = CursorUtil.getColumnIndexOrThrow(_cursor, "humiditeMax");
          final int _cursorIndexOfNotes = CursorUtil.getColumnIndexOrThrow(_cursor, "notes");
          final int _cursorIndexOfDateCreation = CursorUtil.getColumnIndexOrThrow(_cursor, "dateCreation");
          final int _cursorIndexOfDateModification = CursorUtil.getColumnIndexOrThrow(_cursor, "dateModification");
          final int _cursorIndexOfFirebaseId = CursorUtil.getColumnIndexOrThrow(_cursor, "firebaseId");
          final int _cursorIndexOfSyncStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "syncStatus");
          final Espece _result;
          if (_cursor.moveToFirst()) {
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpNom;
            if (_cursor.isNull(_cursorIndexOfNom)) {
              _tmpNom = null;
            } else {
              _tmpNom = _cursor.getString(_cursorIndexOfNom);
            }
            final String _tmpNomScientifique;
            if (_cursor.isNull(_cursorIndexOfNomScientifique)) {
              _tmpNomScientifique = null;
            } else {
              _tmpNomScientifique = _cursor.getString(_cursorIndexOfNomScientifique);
            }
            final String _tmpStatutConservation;
            if (_cursor.isNull(_cursorIndexOfStatutConservation)) {
              _tmpStatutConservation = null;
            } else {
              _tmpStatutConservation = _cursor.getString(_cursorIndexOfStatutConservation);
            }
            final int _tmpPopulationEstimee;
            _tmpPopulationEstimee = _cursor.getInt(_cursorIndexOfPopulationEstimee);
            final double _tmpLatitude;
            _tmpLatitude = _cursor.getDouble(_cursorIndexOfLatitude);
            final double _tmpLongitude;
            _tmpLongitude = _cursor.getDouble(_cursorIndexOfLongitude);
            final String _tmpAdresse;
            if (_cursor.isNull(_cursorIndexOfAdresse)) {
              _tmpAdresse = null;
            } else {
              _tmpAdresse = _cursor.getString(_cursorIndexOfAdresse);
            }
            final double _tmpTemperatureMin;
            _tmpTemperatureMin = _cursor.getDouble(_cursorIndexOfTemperatureMin);
            final double _tmpTemperatureMax;
            _tmpTemperatureMax = _cursor.getDouble(_cursorIndexOfTemperatureMax);
            final double _tmpHumiditeMin;
            _tmpHumiditeMin = _cursor.getDouble(_cursorIndexOfHumiditeMin);
            final double _tmpHumiditeMax;
            _tmpHumiditeMax = _cursor.getDouble(_cursorIndexOfHumiditeMax);
            final String _tmpNotes;
            if (_cursor.isNull(_cursorIndexOfNotes)) {
              _tmpNotes = null;
            } else {
              _tmpNotes = _cursor.getString(_cursorIndexOfNotes);
            }
            final long _tmpDateCreation;
            _tmpDateCreation = _cursor.getLong(_cursorIndexOfDateCreation);
            final long _tmpDateModification;
            _tmpDateModification = _cursor.getLong(_cursorIndexOfDateModification);
            final String _tmpFirebaseId;
            if (_cursor.isNull(_cursorIndexOfFirebaseId)) {
              _tmpFirebaseId = null;
            } else {
              _tmpFirebaseId = _cursor.getString(_cursorIndexOfFirebaseId);
            }
            final int _tmpSyncStatus;
            _tmpSyncStatus = _cursor.getInt(_cursorIndexOfSyncStatus);
            _result = new Espece(_tmpId,_tmpNom,_tmpNomScientifique,_tmpStatutConservation,_tmpPopulationEstimee,_tmpLatitude,_tmpLongitude,_tmpAdresse,_tmpTemperatureMin,_tmpTemperatureMax,_tmpHumiditeMin,_tmpHumiditeMax,_tmpNotes,_tmpDateCreation,_tmpDateModification,_tmpFirebaseId,_tmpSyncStatus);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public LiveData<List<Espece>> searchEspeces(final String q) {
    final String _sql = "SELECT * FROM especes WHERE nom LIKE '%' || ? || '%' OR nomScientifique LIKE '%' || ? || '%' OR statutConservation LIKE '%' || ? || '%'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 3);
    int _argIndex = 1;
    if (q == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, q);
    }
    _argIndex = 2;
    if (q == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, q);
    }
    _argIndex = 3;
    if (q == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, q);
    }
    return __db.getInvalidationTracker().createLiveData(new String[] {"especes"}, false, new Callable<List<Espece>>() {
      @Override
      @Nullable
      public List<Espece> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfNom = CursorUtil.getColumnIndexOrThrow(_cursor, "nom");
          final int _cursorIndexOfNomScientifique = CursorUtil.getColumnIndexOrThrow(_cursor, "nomScientifique");
          final int _cursorIndexOfStatutConservation = CursorUtil.getColumnIndexOrThrow(_cursor, "statutConservation");
          final int _cursorIndexOfPopulationEstimee = CursorUtil.getColumnIndexOrThrow(_cursor, "populationEstimee");
          final int _cursorIndexOfLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "latitude");
          final int _cursorIndexOfLongitude = CursorUtil.getColumnIndexOrThrow(_cursor, "longitude");
          final int _cursorIndexOfAdresse = CursorUtil.getColumnIndexOrThrow(_cursor, "adresse");
          final int _cursorIndexOfTemperatureMin = CursorUtil.getColumnIndexOrThrow(_cursor, "temperatureMin");
          final int _cursorIndexOfTemperatureMax = CursorUtil.getColumnIndexOrThrow(_cursor, "temperatureMax");
          final int _cursorIndexOfHumiditeMin = CursorUtil.getColumnIndexOrThrow(_cursor, "humiditeMin");
          final int _cursorIndexOfHumiditeMax = CursorUtil.getColumnIndexOrThrow(_cursor, "humiditeMax");
          final int _cursorIndexOfNotes = CursorUtil.getColumnIndexOrThrow(_cursor, "notes");
          final int _cursorIndexOfDateCreation = CursorUtil.getColumnIndexOrThrow(_cursor, "dateCreation");
          final int _cursorIndexOfDateModification = CursorUtil.getColumnIndexOrThrow(_cursor, "dateModification");
          final int _cursorIndexOfFirebaseId = CursorUtil.getColumnIndexOrThrow(_cursor, "firebaseId");
          final int _cursorIndexOfSyncStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "syncStatus");
          final List<Espece> _result = new ArrayList<Espece>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Espece _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpNom;
            if (_cursor.isNull(_cursorIndexOfNom)) {
              _tmpNom = null;
            } else {
              _tmpNom = _cursor.getString(_cursorIndexOfNom);
            }
            final String _tmpNomScientifique;
            if (_cursor.isNull(_cursorIndexOfNomScientifique)) {
              _tmpNomScientifique = null;
            } else {
              _tmpNomScientifique = _cursor.getString(_cursorIndexOfNomScientifique);
            }
            final String _tmpStatutConservation;
            if (_cursor.isNull(_cursorIndexOfStatutConservation)) {
              _tmpStatutConservation = null;
            } else {
              _tmpStatutConservation = _cursor.getString(_cursorIndexOfStatutConservation);
            }
            final int _tmpPopulationEstimee;
            _tmpPopulationEstimee = _cursor.getInt(_cursorIndexOfPopulationEstimee);
            final double _tmpLatitude;
            _tmpLatitude = _cursor.getDouble(_cursorIndexOfLatitude);
            final double _tmpLongitude;
            _tmpLongitude = _cursor.getDouble(_cursorIndexOfLongitude);
            final String _tmpAdresse;
            if (_cursor.isNull(_cursorIndexOfAdresse)) {
              _tmpAdresse = null;
            } else {
              _tmpAdresse = _cursor.getString(_cursorIndexOfAdresse);
            }
            final double _tmpTemperatureMin;
            _tmpTemperatureMin = _cursor.getDouble(_cursorIndexOfTemperatureMin);
            final double _tmpTemperatureMax;
            _tmpTemperatureMax = _cursor.getDouble(_cursorIndexOfTemperatureMax);
            final double _tmpHumiditeMin;
            _tmpHumiditeMin = _cursor.getDouble(_cursorIndexOfHumiditeMin);
            final double _tmpHumiditeMax;
            _tmpHumiditeMax = _cursor.getDouble(_cursorIndexOfHumiditeMax);
            final String _tmpNotes;
            if (_cursor.isNull(_cursorIndexOfNotes)) {
              _tmpNotes = null;
            } else {
              _tmpNotes = _cursor.getString(_cursorIndexOfNotes);
            }
            final long _tmpDateCreation;
            _tmpDateCreation = _cursor.getLong(_cursorIndexOfDateCreation);
            final long _tmpDateModification;
            _tmpDateModification = _cursor.getLong(_cursorIndexOfDateModification);
            final String _tmpFirebaseId;
            if (_cursor.isNull(_cursorIndexOfFirebaseId)) {
              _tmpFirebaseId = null;
            } else {
              _tmpFirebaseId = _cursor.getString(_cursorIndexOfFirebaseId);
            }
            final int _tmpSyncStatus;
            _tmpSyncStatus = _cursor.getInt(_cursorIndexOfSyncStatus);
            _item = new Espece(_tmpId,_tmpNom,_tmpNomScientifique,_tmpStatutConservation,_tmpPopulationEstimee,_tmpLatitude,_tmpLongitude,_tmpAdresse,_tmpTemperatureMin,_tmpTemperatureMax,_tmpHumiditeMin,_tmpHumiditeMax,_tmpNotes,_tmpDateCreation,_tmpDateModification,_tmpFirebaseId,_tmpSyncStatus);
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
  public Object getEspecesBySyncStatus(final int status,
      final Continuation<? super List<Espece>> $completion) {
    final String _sql = "SELECT * FROM especes WHERE syncStatus = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, status);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<List<Espece>>() {
      @Override
      @NonNull
      public List<Espece> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfNom = CursorUtil.getColumnIndexOrThrow(_cursor, "nom");
          final int _cursorIndexOfNomScientifique = CursorUtil.getColumnIndexOrThrow(_cursor, "nomScientifique");
          final int _cursorIndexOfStatutConservation = CursorUtil.getColumnIndexOrThrow(_cursor, "statutConservation");
          final int _cursorIndexOfPopulationEstimee = CursorUtil.getColumnIndexOrThrow(_cursor, "populationEstimee");
          final int _cursorIndexOfLatitude = CursorUtil.getColumnIndexOrThrow(_cursor, "latitude");
          final int _cursorIndexOfLongitude = CursorUtil.getColumnIndexOrThrow(_cursor, "longitude");
          final int _cursorIndexOfAdresse = CursorUtil.getColumnIndexOrThrow(_cursor, "adresse");
          final int _cursorIndexOfTemperatureMin = CursorUtil.getColumnIndexOrThrow(_cursor, "temperatureMin");
          final int _cursorIndexOfTemperatureMax = CursorUtil.getColumnIndexOrThrow(_cursor, "temperatureMax");
          final int _cursorIndexOfHumiditeMin = CursorUtil.getColumnIndexOrThrow(_cursor, "humiditeMin");
          final int _cursorIndexOfHumiditeMax = CursorUtil.getColumnIndexOrThrow(_cursor, "humiditeMax");
          final int _cursorIndexOfNotes = CursorUtil.getColumnIndexOrThrow(_cursor, "notes");
          final int _cursorIndexOfDateCreation = CursorUtil.getColumnIndexOrThrow(_cursor, "dateCreation");
          final int _cursorIndexOfDateModification = CursorUtil.getColumnIndexOrThrow(_cursor, "dateModification");
          final int _cursorIndexOfFirebaseId = CursorUtil.getColumnIndexOrThrow(_cursor, "firebaseId");
          final int _cursorIndexOfSyncStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "syncStatus");
          final List<Espece> _result = new ArrayList<Espece>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Espece _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpNom;
            if (_cursor.isNull(_cursorIndexOfNom)) {
              _tmpNom = null;
            } else {
              _tmpNom = _cursor.getString(_cursorIndexOfNom);
            }
            final String _tmpNomScientifique;
            if (_cursor.isNull(_cursorIndexOfNomScientifique)) {
              _tmpNomScientifique = null;
            } else {
              _tmpNomScientifique = _cursor.getString(_cursorIndexOfNomScientifique);
            }
            final String _tmpStatutConservation;
            if (_cursor.isNull(_cursorIndexOfStatutConservation)) {
              _tmpStatutConservation = null;
            } else {
              _tmpStatutConservation = _cursor.getString(_cursorIndexOfStatutConservation);
            }
            final int _tmpPopulationEstimee;
            _tmpPopulationEstimee = _cursor.getInt(_cursorIndexOfPopulationEstimee);
            final double _tmpLatitude;
            _tmpLatitude = _cursor.getDouble(_cursorIndexOfLatitude);
            final double _tmpLongitude;
            _tmpLongitude = _cursor.getDouble(_cursorIndexOfLongitude);
            final String _tmpAdresse;
            if (_cursor.isNull(_cursorIndexOfAdresse)) {
              _tmpAdresse = null;
            } else {
              _tmpAdresse = _cursor.getString(_cursorIndexOfAdresse);
            }
            final double _tmpTemperatureMin;
            _tmpTemperatureMin = _cursor.getDouble(_cursorIndexOfTemperatureMin);
            final double _tmpTemperatureMax;
            _tmpTemperatureMax = _cursor.getDouble(_cursorIndexOfTemperatureMax);
            final double _tmpHumiditeMin;
            _tmpHumiditeMin = _cursor.getDouble(_cursorIndexOfHumiditeMin);
            final double _tmpHumiditeMax;
            _tmpHumiditeMax = _cursor.getDouble(_cursorIndexOfHumiditeMax);
            final String _tmpNotes;
            if (_cursor.isNull(_cursorIndexOfNotes)) {
              _tmpNotes = null;
            } else {
              _tmpNotes = _cursor.getString(_cursorIndexOfNotes);
            }
            final long _tmpDateCreation;
            _tmpDateCreation = _cursor.getLong(_cursorIndexOfDateCreation);
            final long _tmpDateModification;
            _tmpDateModification = _cursor.getLong(_cursorIndexOfDateModification);
            final String _tmpFirebaseId;
            if (_cursor.isNull(_cursorIndexOfFirebaseId)) {
              _tmpFirebaseId = null;
            } else {
              _tmpFirebaseId = _cursor.getString(_cursorIndexOfFirebaseId);
            }
            final int _tmpSyncStatus;
            _tmpSyncStatus = _cursor.getInt(_cursorIndexOfSyncStatus);
            _item = new Espece(_tmpId,_tmpNom,_tmpNomScientifique,_tmpStatutConservation,_tmpPopulationEstimee,_tmpLatitude,_tmpLongitude,_tmpAdresse,_tmpTemperatureMin,_tmpTemperatureMax,_tmpHumiditeMin,_tmpHumiditeMax,_tmpNotes,_tmpDateCreation,_tmpDateModification,_tmpFirebaseId,_tmpSyncStatus);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @Override
  public Object getCount(final Continuation<? super Integer> $completion) {
    final String _sql = "SELECT COUNT(*) FROM especes";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Integer>() {
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
          _statement.release();
        }
      }
    }, $completion);
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
