package com.ecoparc.data.repository;

/**
 * Source de vérité unique — orchestre Room (SQLite local) et Firebase Firestore.
 * Stratégie offline-first : sauvegarde locale immédiate, sync Firebase en arrière-plan.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J$\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001dH\u0086@\u00a2\u0006\u0002\u0010\u001fJ\u0016\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0010H\u0086@\u00a2\u0006\u0002\u0010#J\u001a\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\u0006\u0010%\u001a\u00020\u0013J\u0016\u0010&\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\b2\u0006\u0010%\u001a\u00020\u0013J\u0016\u0010\'\u001a\u00020(2\u0006\u0010)\u001a\u00020\nH\u0086@\u00a2\u0006\u0002\u0010*J\u0016\u0010+\u001a\u00020(2\u0006\u0010\"\u001a\u00020\u0010H\u0086@\u00a2\u0006\u0002\u0010#J\u0016\u0010,\u001a\u00020!2\u0006\u0010%\u001a\u00020\u0013H\u0086@\u00a2\u0006\u0002\u0010-J\u000e\u0010.\u001a\u00020!H\u0086@\u00a2\u0006\u0002\u0010/J\u001a\u00100\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\t0\b2\u0006\u00101\u001a\u000202J\u000e\u00103\u001a\u00020!H\u0086@\u00a2\u0006\u0002\u0010/J\u0018\u00104\u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020\u0010H\u0086@\u00a2\u0006\u0002\u0010#R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001d\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u001d\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\fR\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00065"}, d2 = {"Lcom/ecoparc/data/repository/EspeceRepository;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "alerteDao", "Lcom/ecoparc/data/local/AlerteDao;", "alertesNonLues", "Landroidx/lifecycle/LiveData;", "", "Lcom/ecoparc/data/model/Alerte;", "getAlertesNonLues", "()Landroidx/lifecycle/LiveData;", "allAlertes", "getAllAlertes", "allEspeces", "Lcom/ecoparc/data/model/Espece;", "getAllEspeces", "countAlertesNonLues", "", "getCountAlertesNonLues", "db", "Lcom/ecoparc/data/local/EcoParcDatabase;", "especeDao", "Lcom/ecoparc/data/local/EspeceDao;", "firebase", "Lcom/ecoparc/data/remote/FirebaseDataSource;", "checkConditionsAndAlert", "temperature", "", "humidite", "(DDLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteEspece", "", "espece", "(Lcom/ecoparc/data/model/Espece;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAlertesForEspece", "id", "getEspeceById", "insertAlerte", "", "alerte", "(Lcom/ecoparc/data/model/Alerte;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertEspece", "marquerAlerteCommeLue", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "marquerToutesAlertesLues", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "searchEspeces", "query", "", "syncPendingEspeces", "updateEspece", "app_release"})
public final class EspeceRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.ecoparc.data.local.EcoParcDatabase db = null;
    @org.jetbrains.annotations.NotNull()
    private final com.ecoparc.data.local.EspeceDao especeDao = null;
    @org.jetbrains.annotations.NotNull()
    private final com.ecoparc.data.local.AlerteDao alerteDao = null;
    @org.jetbrains.annotations.NotNull()
    private final com.ecoparc.data.remote.FirebaseDataSource firebase = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.ecoparc.data.model.Espece>> allEspeces = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.Integer> countAlertesNonLues = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.ecoparc.data.model.Alerte>> allAlertes = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.ecoparc.data.model.Alerte>> alertesNonLues = null;
    
    public EspeceRepository(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.ecoparc.data.model.Espece>> getAllEspeces() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Integer> getCountAlertesNonLues() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.ecoparc.data.model.Espece>> searchEspeces(@org.jetbrains.annotations.NotNull()
    java.lang.String query) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.ecoparc.data.model.Espece> getEspeceById(int id) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.ecoparc.data.model.Alerte>> getAlertesForEspece(int id) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object insertEspece(@org.jetbrains.annotations.NotNull()
    com.ecoparc.data.model.Espece espece, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object updateEspece(@org.jetbrains.annotations.NotNull()
    com.ecoparc.data.model.Espece espece, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object deleteEspece(@org.jetbrains.annotations.NotNull()
    com.ecoparc.data.model.Espece espece, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object syncPendingEspeces(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.ecoparc.data.model.Alerte>> getAllAlertes() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.ecoparc.data.model.Alerte>> getAlertesNonLues() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object insertAlerte(@org.jetbrains.annotations.NotNull()
    com.ecoparc.data.model.Alerte alerte, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object marquerAlerteCommeLue(int id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object marquerToutesAlertesLues(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object checkConditionsAndAlert(double temperature, double humidite, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.ecoparc.data.model.Alerte>> $completion) {
        return null;
    }
}