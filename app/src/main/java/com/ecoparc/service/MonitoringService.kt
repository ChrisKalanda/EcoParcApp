package com.ecoparc.service

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Context
import android.content.Intent
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Build
import android.os.IBinder
import androidx.core.app.NotificationCompat
import com.ecoparc.R
import com.ecoparc.data.model.Alerte
import com.ecoparc.data.repository.EspeceRepository
import com.ecoparc.ui.alerts.AlertsActivity
import com.ecoparc.ui.main.MainActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * Service de surveillance en arrière-plan.
 * - Lit les capteurs physiques (température ambiante, humidité relative).
 * - Simule des valeurs si les capteurs sont absents (très courant sur émulateur).
 * - Vérifie les seuils toutes les 30 secondes et émet des notifications.
 */
class MonitoringService : Service(), SensorEventListener {

    companion object {
        const val CH_SERVICE = "ecoparc_service"
        const val CH_ALERTES = "ecoparc_alertes"
        const val NOTIF_SERVICE = 1001
        private const val INTERVAL_MS = 30_000L
    }

    private lateinit var repository: EspeceRepository
    private lateinit var sensorManager: SensorManager
    private val serviceJob = Job()
    private val scope = CoroutineScope(Dispatchers.IO + serviceJob)

    private var temperature = 20.0
    private var humidite    = 60.0
    private var hasTempSensor = false
    private var hasHumSensor  = false

    override fun onCreate() {
        super.onCreate()
        repository    = EspeceRepository(applicationContext)
        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager

        sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE)?.let {
            hasTempSensor = true
            sensorManager.registerListener(this, it, SensorManager.SENSOR_DELAY_NORMAL)
        }
        sensorManager.getDefaultSensor(Sensor.TYPE_RELATIVE_HUMIDITY)?.let {
            hasHumSensor = true
            sensorManager.registerListener(this, it, SensorManager.SENSOR_DELAY_NORMAL)
        }

        createChannels()
        startForeground(NOTIF_SERVICE, buildServiceNotif())
        startLoop()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int) = START_STICKY
    override fun onBind(intent: Intent?): IBinder? = null

    override fun onDestroy() {
        super.onDestroy()
        sensorManager.unregisterListener(this)
        serviceJob.cancel()
    }

    // ── Capteurs ─────────────────────────────────────────────────

    override fun onSensorChanged(event: SensorEvent) {
        when (event.sensor.type) {
            Sensor.TYPE_AMBIENT_TEMPERATURE -> temperature = event.values[0].toDouble()
            Sensor.TYPE_RELATIVE_HUMIDITY   -> humidite    = event.values[0].toDouble()
        }
    }
    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {}

    /** Simulation réaliste si capteurs absents (émulateur ou appareil sans capteur). */
    private fun simulate() {
        if (!hasTempSensor) temperature = (temperature + Math.random() * 4 - 2).coerceIn(-30.0, 50.0)
        if (!hasHumSensor)  humidite    = (humidite    + Math.random() * 10 - 5).coerceIn(0.0, 100.0)
    }

    // ── Boucle principale ─────────────────────────────────────────

    private fun startLoop() = scope.launch {
        while (true) {
            simulate()
            val alertes = repository.checkConditionsAndAlert(temperature, humidite)
            alertes.filter { it.niveauAlerte == 2 }.forEach { sendCritiqueNotif(it) }
            val warnings = alertes.filter { it.niveauAlerte == 1 }
            if (warnings.isNotEmpty()) sendWarningGroupNotif(warnings)
            updateServiceNotif()
            delay(INTERVAL_MS)
        }
    }

    // ── Notifications ─────────────────────────────────────────────

    private fun createChannels() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val nm = getSystemService(NotificationManager::class.java)
            nm.createNotificationChannel(NotificationChannel(
                CH_SERVICE, "Surveillance EcoParc", NotificationManager.IMPORTANCE_LOW
            ).apply { description = "Service de surveillance en arrière-plan" })
            nm.createNotificationChannel(NotificationChannel(
                CH_ALERTES, "Alertes écologiques", NotificationManager.IMPORTANCE_HIGH
            ).apply { description = "Alertes de dépassement de seuils"; enableVibration(true) })
        }
    }

    private fun mainPendingIntent() = PendingIntent.getActivity(
        this, 0, Intent(this, MainActivity::class.java),
        PendingIntent.FLAG_IMMUTABLE
    )

    private fun alertsPendingIntent(requestCode: Int = 9000) = PendingIntent.getActivity(
        this, requestCode, Intent(this, AlertsActivity::class.java),
        PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT
    )

    private fun buildServiceNotif() = NotificationCompat.Builder(this, CH_SERVICE)
        .setContentTitle("EcoParc — Surveillance active")
        .setContentText("T° : ${String.format("%.1f", temperature)}°C  |  Hum. : ${String.format("%.1f", humidite)}%")
        .setSmallIcon(R.drawable.ic_nature)
        .setOngoing(true)
        .setContentIntent(mainPendingIntent())
        .build()

    private fun updateServiceNotif() {
        val nm = getSystemService(NotificationManager::class.java)
        nm.notify(NOTIF_SERVICE, buildServiceNotif())
    }

    private fun sendCritiqueNotif(a: Alerte) {
        val notif = NotificationCompat.Builder(this, CH_ALERTES)
            .setContentTitle("⚠ Alerte critique — ${a.especeNom}")
            .setContentText(a.message)
            .setStyle(NotificationCompat.BigTextStyle()
                .bigText("${a.message}\n\n📋 ${a.conseil}"))
            .setSmallIcon(R.drawable.ic_alert)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setAutoCancel(true)
            .setContentIntent(alertsPendingIntent(2000 + a.id))
            .build()
        getSystemService(NotificationManager::class.java).notify(2000 + a.id, notif)
    }

    private fun sendWarningGroupNotif(warnings: List<Alerte>) {
        val notif = NotificationCompat.Builder(this, CH_ALERTES)
            .setContentTitle("△ ${warnings.size} avertissement${if (warnings.size > 1) "s" else ""}")
            .setContentText(warnings.joinToString(", ") { it.especeNom })
            .setSmallIcon(R.drawable.ic_alert)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setAutoCancel(true)
            .setContentIntent(alertsPendingIntent())
            .build()
        getSystemService(NotificationManager::class.java).notify(3000, notif)
    }
}
