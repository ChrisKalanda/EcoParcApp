package com.ecoparc.data.local;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class EcoParcDatabase_Impl extends EcoParcDatabase {
  private volatile EspeceDao _especeDao;

  private volatile AlerteDao _alerteDao;

  @Override
  @NonNull
  protected SupportSQLiteOpenHelper createOpenHelper(@NonNull final DatabaseConfiguration config) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(config, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `especes` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `nom` TEXT NOT NULL, `nomScientifique` TEXT NOT NULL, `statutConservation` TEXT NOT NULL, `populationEstimee` INTEGER NOT NULL, `latitude` REAL NOT NULL, `longitude` REAL NOT NULL, `adresse` TEXT NOT NULL, `temperatureMin` REAL NOT NULL, `temperatureMax` REAL NOT NULL, `humiditeMin` REAL NOT NULL, `humiditeMax` REAL NOT NULL, `notes` TEXT NOT NULL, `dateCreation` INTEGER NOT NULL, `dateModification` INTEGER NOT NULL, `firebaseId` TEXT NOT NULL, `syncStatus` INTEGER NOT NULL)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `alertes` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `especeId` INTEGER NOT NULL, `especeNom` TEXT NOT NULL, `type` TEXT NOT NULL, `valeurMesuree` REAL NOT NULL, `seuilDepasse` TEXT NOT NULL, `valeurSeuil` REAL NOT NULL, `niveauAlerte` INTEGER NOT NULL, `message` TEXT NOT NULL, `conseil` TEXT NOT NULL, `timestamp` INTEGER NOT NULL, `estLue` INTEGER NOT NULL, FOREIGN KEY(`especeId`) REFERENCES `especes`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
        db.execSQL("CREATE INDEX IF NOT EXISTS `index_alertes_especeId` ON `alertes` (`especeId`)");
        db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '75e6abfd74fa43d450911d48a83a29ad')");
      }

      @Override
      public void dropAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS `especes`");
        db.execSQL("DROP TABLE IF EXISTS `alertes`");
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onDestructiveMigration(db);
          }
        }
      }

      @Override
      public void onCreate(@NonNull final SupportSQLiteDatabase db) {
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onCreate(db);
          }
        }
      }

      @Override
      public void onOpen(@NonNull final SupportSQLiteDatabase db) {
        mDatabase = db;
        db.execSQL("PRAGMA foreign_keys = ON");
        internalInitInvalidationTracker(db);
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onOpen(db);
          }
        }
      }

      @Override
      public void onPreMigrate(@NonNull final SupportSQLiteDatabase db) {
        DBUtil.dropFtsSyncTriggers(db);
      }

      @Override
      public void onPostMigrate(@NonNull final SupportSQLiteDatabase db) {
      }

      @Override
      @NonNull
      public RoomOpenHelper.ValidationResult onValidateSchema(
          @NonNull final SupportSQLiteDatabase db) {
        final HashMap<String, TableInfo.Column> _columnsEspeces = new HashMap<String, TableInfo.Column>(17);
        _columnsEspeces.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEspeces.put("nom", new TableInfo.Column("nom", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEspeces.put("nomScientifique", new TableInfo.Column("nomScientifique", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEspeces.put("statutConservation", new TableInfo.Column("statutConservation", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEspeces.put("populationEstimee", new TableInfo.Column("populationEstimee", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEspeces.put("latitude", new TableInfo.Column("latitude", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEspeces.put("longitude", new TableInfo.Column("longitude", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEspeces.put("adresse", new TableInfo.Column("adresse", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEspeces.put("temperatureMin", new TableInfo.Column("temperatureMin", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEspeces.put("temperatureMax", new TableInfo.Column("temperatureMax", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEspeces.put("humiditeMin", new TableInfo.Column("humiditeMin", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEspeces.put("humiditeMax", new TableInfo.Column("humiditeMax", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEspeces.put("notes", new TableInfo.Column("notes", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEspeces.put("dateCreation", new TableInfo.Column("dateCreation", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEspeces.put("dateModification", new TableInfo.Column("dateModification", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEspeces.put("firebaseId", new TableInfo.Column("firebaseId", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEspeces.put("syncStatus", new TableInfo.Column("syncStatus", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysEspeces = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesEspeces = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoEspeces = new TableInfo("especes", _columnsEspeces, _foreignKeysEspeces, _indicesEspeces);
        final TableInfo _existingEspeces = TableInfo.read(db, "especes");
        if (!_infoEspeces.equals(_existingEspeces)) {
          return new RoomOpenHelper.ValidationResult(false, "especes(com.ecoparc.data.model.Espece).\n"
                  + " Expected:\n" + _infoEspeces + "\n"
                  + " Found:\n" + _existingEspeces);
        }
        final HashMap<String, TableInfo.Column> _columnsAlertes = new HashMap<String, TableInfo.Column>(12);
        _columnsAlertes.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAlertes.put("especeId", new TableInfo.Column("especeId", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAlertes.put("especeNom", new TableInfo.Column("especeNom", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAlertes.put("type", new TableInfo.Column("type", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAlertes.put("valeurMesuree", new TableInfo.Column("valeurMesuree", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAlertes.put("seuilDepasse", new TableInfo.Column("seuilDepasse", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAlertes.put("valeurSeuil", new TableInfo.Column("valeurSeuil", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAlertes.put("niveauAlerte", new TableInfo.Column("niveauAlerte", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAlertes.put("message", new TableInfo.Column("message", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAlertes.put("conseil", new TableInfo.Column("conseil", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAlertes.put("timestamp", new TableInfo.Column("timestamp", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsAlertes.put("estLue", new TableInfo.Column("estLue", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysAlertes = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysAlertes.add(new TableInfo.ForeignKey("especes", "CASCADE", "NO ACTION", Arrays.asList("especeId"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesAlertes = new HashSet<TableInfo.Index>(1);
        _indicesAlertes.add(new TableInfo.Index("index_alertes_especeId", false, Arrays.asList("especeId"), Arrays.asList("ASC")));
        final TableInfo _infoAlertes = new TableInfo("alertes", _columnsAlertes, _foreignKeysAlertes, _indicesAlertes);
        final TableInfo _existingAlertes = TableInfo.read(db, "alertes");
        if (!_infoAlertes.equals(_existingAlertes)) {
          return new RoomOpenHelper.ValidationResult(false, "alertes(com.ecoparc.data.model.Alerte).\n"
                  + " Expected:\n" + _infoAlertes + "\n"
                  + " Found:\n" + _existingAlertes);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "75e6abfd74fa43d450911d48a83a29ad", "d96bc969e963b314de070f335eeeda00");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(_openCallback).build();
    final SupportSQLiteOpenHelper _helper = config.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  @NonNull
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    final HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "especes","alertes");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    final boolean _supportsDeferForeignKeys = android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP;
    try {
      if (!_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA foreign_keys = FALSE");
      }
      super.beginTransaction();
      if (_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA defer_foreign_keys = TRUE");
      }
      _db.execSQL("DELETE FROM `especes`");
      _db.execSQL("DELETE FROM `alertes`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      if (!_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA foreign_keys = TRUE");
      }
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  @NonNull
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(EspeceDao.class, EspeceDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(AlerteDao.class, AlerteDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  @NonNull
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  @NonNull
  public List<Migration> getAutoMigrations(
      @NonNull final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
    final List<Migration> _autoMigrations = new ArrayList<Migration>();
    return _autoMigrations;
  }

  @Override
  public EspeceDao especeDao() {
    if (_especeDao != null) {
      return _especeDao;
    } else {
      synchronized(this) {
        if(_especeDao == null) {
          _especeDao = new EspeceDao_Impl(this);
        }
        return _especeDao;
      }
    }
  }

  @Override
  public AlerteDao alerteDao() {
    if (_alerteDao != null) {
      return _alerteDao;
    } else {
      synchronized(this) {
        if(_alerteDao == null) {
          _alerteDao = new AlerteDao_Impl(this);
        }
        return _alerteDao;
      }
    }
  }
}
