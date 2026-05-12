package com.ecoparc.data.local;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\n\bg\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\'J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u00a7@\u00a2\u0006\u0002\u0010\tJ\u0016\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u00a7@\u00a2\u0006\u0002\u0010\rJ\u001c\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u000f0\u00032\u0006\u0010\u0010\u001a\u00020\u0004H\'J\u0014\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u000f0\u0003H\'J\u0014\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u000f0\u0003H\'J\u0016\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\bH\u00a7@\u00a2\u0006\u0002\u0010\tJ\u0016\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0004H\u00a7@\u00a2\u0006\u0002\u0010\u0016J\u000e\u0010\u0017\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u0018\u00a8\u0006\u0019"}, d2 = {"Lcom/ecoparc/data/local/AlerteDao;", "", "countAlertesNonLues", "Landroidx/lifecycle/LiveData;", "", "deleteAlerte", "", "alerte", "Lcom/ecoparc/data/model/Alerte;", "(Lcom/ecoparc/data/model/Alerte;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteOldAlertes", "timestamp", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAlertesForEspece", "", "especeId", "getAlertesNonLues", "getAllAlertes", "insertAlerte", "marquerCommeLue", "id", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "marquerToutesLues", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
@androidx.room.Dao()
public abstract interface AlerteDao {
    
    @androidx.room.Query(value = "SELECT * FROM alertes ORDER BY timestamp DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract androidx.lifecycle.LiveData<java.util.List<com.ecoparc.data.model.Alerte>> getAllAlertes();
    
    @androidx.room.Query(value = "SELECT * FROM alertes WHERE estLue = 0 ORDER BY niveauAlerte DESC, timestamp DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract androidx.lifecycle.LiveData<java.util.List<com.ecoparc.data.model.Alerte>> getAlertesNonLues();
    
    @androidx.room.Query(value = "SELECT COUNT(*) FROM alertes WHERE estLue = 0")
    @org.jetbrains.annotations.NotNull()
    public abstract androidx.lifecycle.LiveData<java.lang.Integer> countAlertesNonLues();
    
    @androidx.room.Query(value = "SELECT * FROM alertes WHERE especeId = :especeId ORDER BY timestamp DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract androidx.lifecycle.LiveData<java.util.List<com.ecoparc.data.model.Alerte>> getAlertesForEspece(int especeId);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertAlerte(@org.jetbrains.annotations.NotNull()
    com.ecoparc.data.model.Alerte alerte, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
    
    @androidx.room.Query(value = "UPDATE alertes SET estLue = 1 WHERE id = :id")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object marquerCommeLue(int id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "UPDATE alertes SET estLue = 1")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object marquerToutesLues(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM alertes WHERE timestamp < :timestamp")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteOldAlertes(long timestamp, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Delete()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteAlerte(@org.jetbrains.annotations.NotNull()
    com.ecoparc.data.model.Alerte alerte, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}