package com.ecoparc.data.local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.ecoparc.data.model.Alerte

@Dao
interface AlerteDao {

    @Query("SELECT * FROM alertes ORDER BY timestamp DESC")
    fun getAllAlertes(): LiveData<List<Alerte>>

    @Query("SELECT * FROM alertes WHERE estLue = 0 ORDER BY niveauAlerte DESC, timestamp DESC")
    fun getAlertesNonLues(): LiveData<List<Alerte>>

    @Query("SELECT COUNT(*) FROM alertes WHERE estLue = 0")
    fun countAlertesNonLues(): LiveData<Int>

    @Query("SELECT * FROM alertes WHERE especeId = :especeId ORDER BY timestamp DESC")
    fun getAlertesForEspece(especeId: Int): LiveData<List<Alerte>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAlerte(alerte: Alerte): Long

    @Query("UPDATE alertes SET estLue = 1 WHERE id = :id")
    suspend fun marquerCommeLue(id: Int)

    @Query("UPDATE alertes SET estLue = 1")
    suspend fun marquerToutesLues()

    @Query("DELETE FROM alertes WHERE timestamp < :timestamp")
    suspend fun deleteOldAlertes(timestamp: Long)

    @Delete
    suspend fun deleteAlerte(alerte: Alerte)
}
