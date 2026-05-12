package com.ecoparc.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.ecoparc.data.model.Alerte
import com.ecoparc.data.model.Espece
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(
    entities = [Espece::class, Alerte::class],
    version = 1,
    exportSchema = false
)
abstract class EcoParcDatabase : RoomDatabase() {

    abstract fun especeDao(): EspeceDao
    abstract fun alerteDao(): AlerteDao

    companion object {
        @Volatile private var INSTANCE: EcoParcDatabase? = null

        fun getInstance(context: Context): EcoParcDatabase =
            INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    EcoParcDatabase::class.java,
                    "ecoparc.db"
                )
                    .addCallback(object : Callback() {
                        override fun onCreate(db: SupportSQLiteDatabase) {
                            super.onCreate(db)
                            INSTANCE?.let { database ->
                                CoroutineScope(Dispatchers.IO).launch {
                                    if (database.especeDao().getCount() == 0) {
                                        database.especeDao().insertEspeces(Espece.getExemples())
                                    }
                                }
                            }
                        }
                    })
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { INSTANCE = it }
            }
    }
}
