package com.ecoparc.data.remote;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0086@\u00a2\u0006\u0002\u0010\tJ,\u0010\n\u001a \u0012\u001c\u0012\u001a\u0012\u0004\u0012\u00020\b\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\r0\f0\u000bH\u0086@\u00a2\u0006\u0002\u0010\u000eJ\"\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\b2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\rJ\u0018\u0010\u0012\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0013\u001a\u00020\u0010H\u0086@\u00a2\u0006\u0002\u0010\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/ecoparc/data/remote/FirebaseDataSource;", "", "()V", "collection", "Lcom/google/firebase/firestore/CollectionReference;", "deleteEspece", "", "firebaseId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllEspeces", "", "Lkotlin/Pair;", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mapToEspece", "Lcom/ecoparc/data/model/Espece;", "data", "saveEspece", "espece", "(Lcom/ecoparc/data/model/Espece;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"})
public final class FirebaseDataSource {
    @org.jetbrains.annotations.NotNull()
    private final com.google.firebase.firestore.CollectionReference collection = null;
    
    public FirebaseDataSource() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object saveEspece(@org.jetbrains.annotations.NotNull()
    com.ecoparc.data.model.Espece espece, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.String> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object deleteEspece(@org.jetbrains.annotations.NotNull()
    java.lang.String firebaseId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getAllEspeces(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<? extends kotlin.Pair<java.lang.String, ? extends java.util.Map<java.lang.String, ? extends java.lang.Object>>>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.ecoparc.data.model.Espece mapToEspece(@org.jetbrains.annotations.NotNull()
    java.lang.String firebaseId, @org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, ? extends java.lang.Object> data) {
        return null;
    }
}