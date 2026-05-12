package com.ecoparc.data.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "alertes",
    foreignKeys = [ForeignKey(
        entity = Espece::class,
        parentColumns = ["id"],
        childColumns = ["especeId"],
        onDelete = ForeignKey.CASCADE
    )],
    indices = [Index("especeId")]
)
data class Alerte(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val especeId: Int,
    val especeNom: String,
    val type: String,           // "TEMPERATURE" ou "HUMIDITE"
    val valeurMesuree: Double,
    val seuilDepasse: String,   // "MIN" ou "MAX"
    val valeurSeuil: Double,
    val niveauAlerte: Int,      // 1=Avertissement 2=Critique
    val message: String,
    val conseil: String,
    val timestamp: Long = System.currentTimeMillis(),
    val estLue: Boolean = false
) {
    companion object {

        fun creerAlerteTemperature(espece: Espece, temp: Double): Alerte? = when {
            temp > espece.temperatureMax -> Alerte(
                especeId = espece.id,
                especeNom = espece.nom,
                type = "TEMPERATURE",
                valeurMesuree = temp,
                seuilDepasse = "MAX",
                valeurSeuil = espece.temperatureMax,
                niveauAlerte = if (temp - espece.temperatureMax > 5) 2 else 1,
                message = "Température trop élevée pour ${espece.nom} : ${String.format("%.1f", temp)}°C (max : ${espece.temperatureMax}°C)",
                conseil = "Augmentez la ventilation et réduisez les sources de chaleur. Vérifiez les systèmes de refroidissement."
            )
            temp < espece.temperatureMin -> Alerte(
                especeId = espece.id,
                especeNom = espece.nom,
                type = "TEMPERATURE",
                valeurMesuree = temp,
                seuilDepasse = "MIN",
                valeurSeuil = espece.temperatureMin,
                niveauAlerte = if (espece.temperatureMin - temp > 5) 2 else 1,
                message = "Température trop basse pour ${espece.nom} : ${String.format("%.1f", temp)}°C (min : ${espece.temperatureMin}°C)",
                conseil = "Activez le chauffage de la zone. Vérifiez l'isolation de l'habitat et protégez les animaux du froid."
            )
            else -> null
        }

        fun creerAlerteHumidite(espece: Espece, hum: Double): Alerte? = when {
            hum > espece.humiditeMax -> Alerte(
                especeId = espece.id,
                especeNom = espece.nom,
                type = "HUMIDITE",
                valeurMesuree = hum,
                seuilDepasse = "MAX",
                valeurSeuil = espece.humiditeMax,
                niveauAlerte = if (hum - espece.humiditeMax > 15) 2 else 1,
                message = "Humidité trop élevée pour ${espece.nom} : ${String.format("%.1f", hum)}% (max : ${espece.humiditeMax}%)",
                conseil = "Améliorez la ventilation et activez les déshumidificateurs. Vérifiez les drains."
            )
            hum < espece.humiditeMin -> Alerte(
                especeId = espece.id,
                especeNom = espece.nom,
                type = "HUMIDITE",
                valeurMesuree = hum,
                seuilDepasse = "MIN",
                valeurSeuil = espece.humiditeMin,
                niveauAlerte = if (espece.humiditeMin - hum > 15) 2 else 1,
                message = "Humidité trop basse pour ${espece.nom} : ${String.format("%.1f", hum)}% (min : ${espece.humiditeMin}%)",
                conseil = "Activez les humidificateurs et vaporisez de l'eau dans les zones sèches. Vérifiez les points d'eau."
            )
            else -> null
        }
    }
}
