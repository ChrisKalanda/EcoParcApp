package com.ecoparc.data.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.ecoparc.data.local.EcoParcDatabase
import com.ecoparc.data.model.Alerte
import com.ecoparc.data.model.Espece
import com.ecoparc.data.remote.FirebaseDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Source de vérité unique — orchestre Room (SQLite local) et Firebase Firestore.
 * Stratégie offline-first : sauvegarde locale immédiate, sync Firebase en arrière-plan.
 */
class EspeceRepository(context: Context) {

    private val db         = EcoParcDatabase.getInstance(context)
    private val especeDao  = db.especeDao()
    private val alerteDao  = db.alerteDao()
    private val firebase   = FirebaseDataSource()

    // ── Espèces ──────────────────────────────────────────────────

    val allEspeces: LiveData<List<Espece>> = especeDao.getAllEspeces()
    val countAlertesNonLues: LiveData<Int> = alerteDao.countAlertesNonLues()

    fun searchEspeces(query: String): LiveData<List<Espece>> = especeDao.searchEspeces(query)
    fun getEspeceById(id: Int): LiveData<Espece?> = especeDao.getEspeceById(id)
    fun getAlertesForEspece(id: Int): LiveData<List<Alerte>> = alerteDao.getAlertesForEspece(id)

    suspend fun insertEspece(espece: Espece): Long = withContext(Dispatchers.IO) {
        val localId = especeDao.insertEspece(espece.copy(syncStatus = Espece.SYNC_PENDING))
        try {
            firebase.saveEspece(espece.copy(id = localId.toInt()))?.let { fbId ->
                especeDao.updateSyncStatus(localId.toInt(), fbId, Espece.SYNC_DONE)
            }
        } catch (_: Exception) {}
        localId
    }

    suspend fun updateEspece(espece: Espece) = withContext(Dispatchers.IO) {
        val updated = espece.copy(dateModification = System.currentTimeMillis(), syncStatus = Espece.SYNC_PENDING)
        especeDao.updateEspece(updated)
        try {
            firebase.saveEspece(updated)?.let { fbId ->
                especeDao.updateSyncStatus(updated.id, fbId, Espece.SYNC_DONE)
            }
        } catch (_: Exception) {}
    }

    suspend fun deleteEspece(espece: Espece) = withContext(Dispatchers.IO) {
        especeDao.deleteEspece(espece)
        if (espece.firebaseId.isNotEmpty()) try { firebase.deleteEspece(espece.firebaseId) } catch (_: Exception) {}
    }

    suspend fun syncPendingEspeces() = withContext(Dispatchers.IO) {
        especeDao.getEspecesBySyncStatus(Espece.SYNC_PENDING).forEach { espece ->
            try {
                firebase.saveEspece(espece)?.let { fbId ->
                    especeDao.updateSyncStatus(espece.id, fbId, Espece.SYNC_DONE)
                }
            } catch (_: Exception) {}
        }
    }

    // ── Alertes ──────────────────────────────────────────────────

    val allAlertes: LiveData<List<Alerte>>    = alerteDao.getAllAlertes()
    val alertesNonLues: LiveData<List<Alerte>> = alerteDao.getAlertesNonLues()

    suspend fun insertAlerte(alerte: Alerte) = withContext(Dispatchers.IO) { alerteDao.insertAlerte(alerte) }
    suspend fun marquerAlerteCommeLue(id: Int) = withContext(Dispatchers.IO) { alerteDao.marquerCommeLue(id) }
    suspend fun marquerToutesAlertesLues() = withContext(Dispatchers.IO) { alerteDao.marquerToutesLues() }

    suspend fun checkConditionsAndAlert(temperature: Double, humidite: Double): List<Alerte> =
        withContext(Dispatchers.IO) {
            buildList {
                especeDao.getAllEspecesList().forEach { espece ->
                    Alerte.creerAlerteTemperature(espece, temperature)?.also {
                        alerteDao.insertAlerte(it); add(it)
                    }
                    Alerte.creerAlerteHumidite(espece, humidite)?.also {
                        alerteDao.insertAlerte(it); add(it)
                    }
                }
            }
        }
}
