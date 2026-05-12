package com.ecoparc.data.remote

import com.ecoparc.data.model.Espece
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.tasks.await

class FirebaseDataSource {

    private val collection = Firebase.firestore.collection("especes")

    suspend fun saveEspece(espece: Espece): String? = try {
        if (espece.firebaseId.isEmpty()) {
            collection.add(espece.toFirestoreMap()).await().id
        } else {
            collection.document(espece.firebaseId).set(espece.toFirestoreMap()).await()
            espece.firebaseId
        }
    } catch (e: Exception) { null }

    suspend fun deleteEspece(firebaseId: String): Boolean = try {
        collection.document(firebaseId).delete().await()
        true
    } catch (e: Exception) { false }

    suspend fun getAllEspeces(): List<Pair<String, Map<String, Any>>> = try {
        collection.get().await().documents.mapNotNull { doc ->
            doc.data?.let { doc.id to it }
        }
    } catch (e: Exception) { emptyList() }

    fun mapToEspece(firebaseId: String, data: Map<String, Any>): Espece = Espece(
        id = (data["localId"] as? Long)?.toInt() ?: 0,
        nom = data["nom"] as? String ?: "",
        nomScientifique = data["nomScientifique"] as? String ?: "",
        statutConservation = data["statutConservation"] as? String ?: "",
        populationEstimee = (data["populationEstimee"] as? Long)?.toInt() ?: 0,
        latitude = data["latitude"] as? Double ?: 0.0,
        longitude = data["longitude"] as? Double ?: 0.0,
        adresse = data["adresse"] as? String ?: "",
        temperatureMin = data["temperatureMin"] as? Double ?: 0.0,
        temperatureMax = data["temperatureMax"] as? Double ?: 0.0,
        humiditeMin = data["humiditeMin"] as? Double ?: 0.0,
        humiditeMax = data["humiditeMax"] as? Double ?: 0.0,
        notes = data["notes"] as? String ?: "",
        dateCreation = data["dateCreation"] as? Long ?: System.currentTimeMillis(),
        dateModification = data["dateModification"] as? Long ?: System.currentTimeMillis(),
        firebaseId = firebaseId,
        syncStatus = Espece.SYNC_DONE
    )
}
