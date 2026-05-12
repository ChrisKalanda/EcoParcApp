package com.ecoparc.service;

/**
 * Service de surveillance en arrière-plan.
 * - Lit les capteurs physiques (température ambiante, humidité relative).
 * - Simule des valeurs si les capteurs sont absents (très courant sur émulateur).
 * - Vérifie les seuils toutes les 30 secondes et émet des notifications.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 62\u00020\u00012\u00020\u0002:\u00016B\u0005\u00a2\u0006\u0002\u0010\u0003J\u001a\u0010\u0012\u001a\n \u0014*\u0004\u0018\u00010\u00130\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0002J\u0010\u0010\u001b\u001a\n \u0014*\u0004\u0018\u00010\u00130\u0013H\u0002J\u001a\u0010\u001c\u001a\u00020\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020\u0016H\u0016J\u0014\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u0010$\u001a\u00020\u001aH\u0016J\b\u0010%\u001a\u00020\u001aH\u0016J\u0010\u0010&\u001a\u00020\u001a2\u0006\u0010\'\u001a\u00020(H\u0016J\"\u0010)\u001a\u00020\u00162\b\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010*\u001a\u00020\u00162\u0006\u0010+\u001a\u00020\u0016H\u0016J\u0010\u0010,\u001a\u00020\u001a2\u0006\u0010-\u001a\u00020.H\u0002J\u0016\u0010/\u001a\u00020\u001a2\f\u00100\u001a\b\u0012\u0004\u0012\u00020.01H\u0002J\b\u00102\u001a\u00020\u001aH\u0002J\b\u00103\u001a\u000204H\u0002J\b\u00105\u001a\u00020\u001aH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00067"}, d2 = {"Lcom/ecoparc/service/MonitoringService;", "Landroid/app/Service;", "Landroid/hardware/SensorEventListener;", "()V", "hasHumSensor", "", "hasTempSensor", "humidite", "", "repository", "Lcom/ecoparc/data/repository/EspeceRepository;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "sensorManager", "Landroid/hardware/SensorManager;", "serviceJob", "Lkotlinx/coroutines/CompletableJob;", "temperature", "alertsPendingIntent", "Landroid/app/PendingIntent;", "kotlin.jvm.PlatformType", "requestCode", "", "buildServiceNotif", "Landroid/app/Notification;", "createChannels", "", "mainPendingIntent", "onAccuracyChanged", "sensor", "Landroid/hardware/Sensor;", "accuracy", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "onCreate", "onDestroy", "onSensorChanged", "event", "Landroid/hardware/SensorEvent;", "onStartCommand", "flags", "startId", "sendCritiqueNotif", "a", "Lcom/ecoparc/data/model/Alerte;", "sendWarningGroupNotif", "warnings", "", "simulate", "startLoop", "Lkotlinx/coroutines/Job;", "updateServiceNotif", "Companion", "app_release"})
public final class MonitoringService extends android.app.Service implements android.hardware.SensorEventListener {
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String CH_SERVICE = "ecoparc_service";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String CH_ALERTES = "ecoparc_alertes";
    public static final int NOTIF_SERVICE = 1001;
    private static final long INTERVAL_MS = 30000L;
    private com.ecoparc.data.repository.EspeceRepository repository;
    private android.hardware.SensorManager sensorManager;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.CompletableJob serviceJob = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.CoroutineScope scope = null;
    private double temperature = 20.0;
    private double humidite = 60.0;
    private boolean hasTempSensor = false;
    private boolean hasHumSensor = false;
    @org.jetbrains.annotations.NotNull()
    public static final com.ecoparc.service.MonitoringService.Companion Companion = null;
    
    public MonitoringService() {
        super();
    }
    
    @java.lang.Override()
    public void onCreate() {
    }
    
    @java.lang.Override()
    public int onStartCommand(@org.jetbrains.annotations.Nullable()
    android.content.Intent intent, int flags, int startId) {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public android.os.IBinder onBind(@org.jetbrains.annotations.Nullable()
    android.content.Intent intent) {
        return null;
    }
    
    @java.lang.Override()
    public void onDestroy() {
    }
    
    @java.lang.Override()
    public void onSensorChanged(@org.jetbrains.annotations.NotNull()
    android.hardware.SensorEvent event) {
    }
    
    @java.lang.Override()
    public void onAccuracyChanged(@org.jetbrains.annotations.Nullable()
    android.hardware.Sensor sensor, int accuracy) {
    }
    
    /**
     * Simulation réaliste si capteurs absents (émulateur ou appareil sans capteur).
     */
    private final void simulate() {
    }
    
    private final kotlinx.coroutines.Job startLoop() {
        return null;
    }
    
    private final void createChannels() {
    }
    
    private final android.app.PendingIntent mainPendingIntent() {
        return null;
    }
    
    private final android.app.PendingIntent alertsPendingIntent(int requestCode) {
        return null;
    }
    
    private final android.app.Notification buildServiceNotif() {
        return null;
    }
    
    private final void updateServiceNotif() {
    }
    
    private final void sendCritiqueNotif(com.ecoparc.data.model.Alerte a) {
    }
    
    private final void sendWarningGroupNotif(java.util.List<com.ecoparc.data.model.Alerte> warnings) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/ecoparc/service/MonitoringService$Companion;", "", "()V", "CH_ALERTES", "", "CH_SERVICE", "INTERVAL_MS", "", "NOTIF_SERVICE", "", "app_release"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}