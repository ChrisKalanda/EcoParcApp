package com.ecoparc.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Entité Room représentant une espèce surveillée.
 * Stockée localement (SQLite via Room) et synchronisée avec Firebase Firestore.
 */
@Entity(tableName = "especes")
data class Espece(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    // Informations générales
    val nom: String,
    val nomScientifique: String = "",
    val statutConservation: String,
    val populationEstimee: Int,

    // Localisation GPS
    val latitude: Double,
    val longitude: Double,
    val adresse: String = "",

    // Seuils écologiques
    val temperatureMin: Double,
    val temperatureMax: Double,
    val humiditeMin: Double,
    val humiditeMax: Double,

    // Notes
    val notes: String = "",

    // Métadonnées
    val dateCreation: Long = System.currentTimeMillis(),
    val dateModification: Long = System.currentTimeMillis(),
    val firebaseId: String = "",
    val syncStatus: Int = SYNC_PENDING
) {
    companion object {
        const val SYNC_PENDING = 0
        const val SYNC_DONE = 1

        val STATUTS = listOf(
            "En danger critique",
            "En danger",
            "Vulnérable",
            "Quasi menacé",
            "Préoccupation mineure",
            "Données insuffisantes",
            "Non évalué"
        )

        fun getExemples(): List<Espece> = listOf(
            Espece(
                nom = "Ours polaire",
                nomScientifique = "Ursus maritimus",
                statutConservation = "Vulnérable",
                populationEstimee = 26000,
                latitude = 78.2232,
                longitude = 15.6267,
                adresse = "Svalbard, Norvège",
                temperatureMin = -20.0,
                temperatureMax = 10.0,
                humiditeMin = 20.0,
                humiditeMax = 60.0,
                notes = "Espèce arctique très sensible au réchauffement climatique."
            ),
            Espece(
                nom = "Flamant rose",
                nomScientifique = "Phoenicopterus roseus",
                statutConservation = "Préoccupation mineure",
                populationEstimee = 500000,
                latitude = 43.4667,
                longitude = 4.4333,
                adresse = "Camargue, France",
                temperatureMin = 15.0,
                temperatureMax = 35.0,
                humiditeMin = 40.0,
                humiditeMax = 90.0,
                notes = "Espèce grégaire vivant dans les zones humides chaudes."
            ),
            Espece(
                nom = "Lynx ibérique",
                nomScientifique = "Lynx pardinus",
                statutConservation = "En danger",
                populationEstimee = 1100,
                latitude = 37.8945,
                longitude = -6.9876,
                adresse = "Andalousie, Espagne",
                temperatureMin = 5.0,
                temperatureMax = 25.0,
                humiditeMin = 30.0,
                humiditeMax = 50.0,
                notes = "Félide le plus menacé d'Europe."
            )
        )
    }

    fun isTemperatureAlerte(temp: Double) = temp < temperatureMin || temp > temperatureMax
    fun isHumiditeAlerte(hum: Double) = hum < humiditeMin || hum > humiditeMax

    fun getNiveauAlerte(temp: Double, hum: Double): Int {
        val dTemp = maxOf(temperatureMin - temp, temp - temperatureMax, 0.0)
        val dHum  = maxOf(humiditeMin - hum,  hum  - humiditeMax,  0.0)
        return when {
            dTemp > 5 || dHum > 15 -> 2
            dTemp > 0 || dHum > 0  -> 1
            else -> 0
        }
    }

    fun toFirestoreMap(): Map<String, Any> = mapOf(
        "nom" to nom,
        "nomScientifique" to nomScientifique,
        "statutConservation" to statutConservation,
        "populationEstimee" to populationEstimee,
        "latitude" to latitude,
        "longitude" to longitude,
        "adresse" to adresse,
        "temperatureMin" to temperatureMin,
        "temperatureMax" to temperatureMax,
        "humiditeMin" to humiditeMin,
        "humiditeMax" to humiditeMax,
        "notes" to notes,
        "dateCreation" to dateCreation,
        "dateModification" to dateModification,
        "localId" to id
    )
}
