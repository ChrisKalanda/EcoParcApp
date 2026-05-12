package com.ecoparc.data.local;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\u00020\u0003H\u00a7@\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u00a7@\u00a2\u0006\u0002\u0010\bJ\u0014\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u000b0\nH\'J\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u000bH\u00a7@\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\r\u001a\u00020\u000eH\u00a7@\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\n2\u0006\u0010\u0010\u001a\u00020\u000eH\'J\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0010\u001a\u00020\u000eH\u00a7@\u00a2\u0006\u0002\u0010\u0012J\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b2\u0006\u0010\u0014\u001a\u00020\u000eH\u00a7@\u00a2\u0006\u0002\u0010\u0012J\u0016\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0006\u001a\u00020\u0007H\u00a7@\u00a2\u0006\u0002\u0010\bJ\u001c\u0010\u0017\u001a\u00020\u00032\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00070\u000bH\u00a7@\u00a2\u0006\u0002\u0010\u0019J\u001c\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u000b0\n2\u0006\u0010\u001b\u001a\u00020\u001cH\'J\u0016\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u00a7@\u00a2\u0006\u0002\u0010\bJ&\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u001c2\u0006\u0010\u0014\u001a\u00020\u000eH\u00a7@\u00a2\u0006\u0002\u0010!\u00a8\u0006\""}, d2 = {"Lcom/ecoparc/data/local/EspeceDao;", "", "deleteAll", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteEspece", "espece", "Lcom/ecoparc/data/model/Espece;", "(Lcom/ecoparc/data/model/Espece;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllEspeces", "Landroidx/lifecycle/LiveData;", "", "getAllEspecesList", "getCount", "", "getEspeceById", "id", "getEspeceByIdSync", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getEspecesBySyncStatus", "status", "insertEspece", "", "insertEspeces", "especes", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "searchEspeces", "q", "", "updateEspece", "updateSyncStatus", "localId", "firebaseId", "(ILjava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"})
@androidx.room.Dao()
public abstract interface EspeceDao {
    
    @androidx.room.Query(value = "SELECT * FROM especes ORDER BY dateModification DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract androidx.lifecycle.LiveData<java.util.List<com.ecoparc.data.model.Espece>> getAllEspeces();
    
    @androidx.room.Query(value = "SELECT * FROM especes ORDER BY dateModification DESC")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getAllEspecesList(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.ecoparc.data.model.Espece>> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM especes WHERE id = :id")
    @org.jetbrains.annotations.NotNull()
    public abstract androidx.lifecycle.LiveData<com.ecoparc.data.model.Espece> getEspeceById(int id);
    
    @androidx.room.Query(value = "SELECT * FROM especes WHERE id = :id")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getEspeceByIdSync(int id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.ecoparc.data.model.Espece> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM especes WHERE nom LIKE \'%\' || :q || \'%\' OR nomScientifique LIKE \'%\' || :q || \'%\' OR statutConservation LIKE \'%\' || :q || \'%\'")
    @org.jetbrains.annotations.NotNull()
    public abstract androidx.lifecycle.LiveData<java.util.List<com.ecoparc.data.model.Espece>> searchEspeces(@org.jetbrains.annotations.NotNull()
    java.lang.String q);
    
    @androidx.room.Query(value = "SELECT * FROM especes WHERE syncStatus = :status")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getEspecesBySyncStatus(int status, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.ecoparc.data.model.Espece>> $completion);
    
    @androidx.room.Query(value = "SELECT COUNT(*) FROM especes")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getCount(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertEspece(@org.jetbrains.annotations.NotNull()
    com.ecoparc.data.model.Espece espece, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertEspeces(@org.jetbrains.annotations.NotNull()
    java.util.List<com.ecoparc.data.model.Espece> especes, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Update()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateEspece(@org.jetbrains.annotations.NotNull()
    com.ecoparc.data.model.Espece espece, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "UPDATE especes SET firebaseId = :firebaseId, syncStatus = :status WHERE id = :localId")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateSyncStatus(int localId, @org.jetbrains.annotations.NotNull()
    java.lang.String firebaseId, int status, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Delete()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteEspece(@org.jetbrains.annotations.NotNull()
    com.ecoparc.data.model.Espece espece, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM especes")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteAll(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}