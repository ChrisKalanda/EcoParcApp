package com.ecoparc.data.local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.ecoparc.data.model.Espece

@Dao
interface EspeceDao {

    @Query("SELECT * FROM especes ORDER BY dateModification DESC")
    fun getAllEspeces(): LiveData<List<Espece>>

    @Query("SELECT * FROM especes ORDER BY dateModification DESC")
    suspend fun getAllEspecesList(): List<Espece>

    @Query("SELECT * FROM especes WHERE id = :id")
    fun getEspeceById(id: Int): LiveData<Espece?>

    @Query("SELECT * FROM especes WHERE id = :id")
    suspend fun getEspeceByIdSync(id: Int): Espece?

    @Query("SELECT * FROM especes WHERE nom LIKE '%' || :q || '%' OR nomScientifique LIKE '%' || :q || '%' OR statutConservation LIKE '%' || :q || '%'")
    fun searchEspeces(q: String): LiveData<List<Espece>>

    @Query("SELECT * FROM especes WHERE syncStatus = :status")
    suspend fun getEspecesBySyncStatus(status: Int): List<Espece>

    @Query("SELECT COUNT(*) FROM especes")
    suspend fun getCount(): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertEspece(espece: Espece): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertEspeces(especes: List<Espece>)

    @Update
    suspend fun updateEspece(espece: Espece)

    @Query("UPDATE especes SET firebaseId = :firebaseId, syncStatus = :status WHERE id = :localId")
    suspend fun updateSyncStatus(localId: Int, firebaseId: String, status: Int)

    @Delete
    suspend fun deleteEspece(espece: Espece)

    @Query("DELETE FROM especes")
    suspend fun deleteAll()
}
