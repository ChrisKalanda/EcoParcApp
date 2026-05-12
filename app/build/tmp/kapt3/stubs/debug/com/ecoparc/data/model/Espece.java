package com.ecoparc.data.model;

/**
 * Entité Room représentant une espèce surveillée.
 * Stockée localement (SQLite via Room) et synchronisée avec Firebase Firestore.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b,\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010$\n\u0002\b\u0003\b\u0087\b\u0018\u0000 K2\u00020\u0001:\u0001KB\u009d\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u000e\u001a\u00020\n\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\u0006\u0010\u0010\u001a\u00020\n\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0017J\t\u0010-\u001a\u00020\u0003H\u00c6\u0003J\t\u0010.\u001a\u00020\nH\u00c6\u0003J\t\u0010/\u001a\u00020\nH\u00c6\u0003J\t\u00100\u001a\u00020\nH\u00c6\u0003J\t\u00101\u001a\u00020\u0005H\u00c6\u0003J\t\u00102\u001a\u00020\u0013H\u00c6\u0003J\t\u00103\u001a\u00020\u0013H\u00c6\u0003J\t\u00104\u001a\u00020\u0005H\u00c6\u0003J\t\u00105\u001a\u00020\u0003H\u00c6\u0003J\t\u00106\u001a\u00020\u0005H\u00c6\u0003J\t\u00107\u001a\u00020\u0005H\u00c6\u0003J\t\u00108\u001a\u00020\u0005H\u00c6\u0003J\t\u00109\u001a\u00020\u0003H\u00c6\u0003J\t\u0010:\u001a\u00020\nH\u00c6\u0003J\t\u0010;\u001a\u00020\nH\u00c6\u0003J\t\u0010<\u001a\u00020\u0005H\u00c6\u0003J\t\u0010=\u001a\u00020\nH\u00c6\u0003J\u00b3\u0001\u0010>\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\n2\b\b\u0002\u0010\u000e\u001a\u00020\n2\b\b\u0002\u0010\u000f\u001a\u00020\n2\b\b\u0002\u0010\u0010\u001a\u00020\n2\b\b\u0002\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010?\u001a\u00020@2\b\u0010A\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\u0016\u0010B\u001a\u00020\u00032\u0006\u0010C\u001a\u00020\n2\u0006\u0010D\u001a\u00020\nJ\t\u0010E\u001a\u00020\u0003H\u00d6\u0001J\u000e\u0010F\u001a\u00020@2\u0006\u0010D\u001a\u00020\nJ\u000e\u0010G\u001a\u00020@2\u0006\u0010C\u001a\u00020\nJ\u0012\u0010H\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010IJ\t\u0010J\u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010\f\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0012\u001a\u00020\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0014\u001a\u00020\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u0011\u0010\u0015\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0019R\u0011\u0010\u0010\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u000f\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u001fR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001fR\u0011\u0010\u000b\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001fR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0019R\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0019R\u0011\u0010\u0011\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010\u0019R\u0011\u0010\b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010\"R\u0011\u0010\u0007\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0019R\u0011\u0010\u0016\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010\"R\u0011\u0010\u000e\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001fR\u0011\u0010\r\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001f\u00a8\u0006L"}, d2 = {"Lcom/ecoparc/data/model/Espece;", "", "id", "", "nom", "", "nomScientifique", "statutConservation", "populationEstimee", "latitude", "", "longitude", "adresse", "temperatureMin", "temperatureMax", "humiditeMin", "humiditeMax", "notes", "dateCreation", "", "dateModification", "firebaseId", "syncStatus", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;IDDLjava/lang/String;DDDDLjava/lang/String;JJLjava/lang/String;I)V", "getAdresse", "()Ljava/lang/String;", "getDateCreation", "()J", "getDateModification", "getFirebaseId", "getHumiditeMax", "()D", "getHumiditeMin", "getId", "()I", "getLatitude", "getLongitude", "getNom", "getNomScientifique", "getNotes", "getPopulationEstimee", "getStatutConservation", "getSyncStatus", "getTemperatureMax", "getTemperatureMin", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "getNiveauAlerte", "temp", "hum", "hashCode", "isHumiditeAlerte", "isTemperatureAlerte", "toFirestoreMap", "", "toString", "Companion", "app_debug"})
@androidx.room.Entity(tableName = "especes")
public final class Espece {
    @androidx.room.PrimaryKey(autoGenerate = true)
    private final int id = 0;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String nom = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String nomScientifique = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String statutConservation = null;
    private final int populationEstimee = 0;
    private final double latitude = 0.0;
    private final double longitude = 0.0;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String adresse = null;
    private final double temperatureMin = 0.0;
    private final double temperatureMax = 0.0;
    private final double humiditeMin = 0.0;
    private final double humiditeMax = 0.0;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String notes = null;
    private final long dateCreation = 0L;
    private final long dateModification = 0L;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String firebaseId = null;
    private final int syncStatus = 0;
    public static final int SYNC_PENDING = 0;
    public static final int SYNC_DONE = 1;
    @org.jetbrains.annotations.NotNull()
    private static final java.util.List<java.lang.String> STATUTS = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.ecoparc.data.model.Espece.Companion Companion = null;
    
    public Espece(int id, @org.jetbrains.annotations.NotNull()
    java.lang.String nom, @org.jetbrains.annotations.NotNull()
    java.lang.String nomScientifique, @org.jetbrains.annotations.NotNull()
    java.lang.String statutConservation, int populationEstimee, double latitude, double longitude, @org.jetbrains.annotations.NotNull()
    java.lang.String adresse, double temperatureMin, double temperatureMax, double humiditeMin, double humiditeMax, @org.jetbrains.annotations.NotNull()
    java.lang.String notes, long dateCreation, long dateModification, @org.jetbrains.annotations.NotNull()
    java.lang.String firebaseId, int syncStatus) {
        super();
    }
    
    public final int getId() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getNom() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getNomScientifique() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getStatutConservation() {
        return null;
    }
    
    public final int getPopulationEstimee() {
        return 0;
    }
    
    public final double getLatitude() {
        return 0.0;
    }
    
    public final double getLongitude() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getAdresse() {
        return null;
    }
    
    public final double getTemperatureMin() {
        return 0.0;
    }
    
    public final double getTemperatureMax() {
        return 0.0;
    }
    
    public final double getHumiditeMin() {
        return 0.0;
    }
    
    public final double getHumiditeMax() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getNotes() {
        return null;
    }
    
    public final long getDateCreation() {
        return 0L;
    }
    
    public final long getDateModification() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getFirebaseId() {
        return null;
    }
    
    public final int getSyncStatus() {
        return 0;
    }
    
    public final boolean isTemperatureAlerte(double temp) {
        return false;
    }
    
    public final boolean isHumiditeAlerte(double hum) {
        return false;
    }
    
    public final int getNiveauAlerte(double temp, double hum) {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Map<java.lang.String, java.lang.Object> toFirestoreMap() {
        return null;
    }
    
    public final int component1() {
        return 0;
    }
    
    public final double component10() {
        return 0.0;
    }
    
    public final double component11() {
        return 0.0;
    }
    
    public final double component12() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component13() {
        return null;
    }
    
    public final long component14() {
        return 0L;
    }
    
    public final long component15() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component16() {
        return null;
    }
    
    public final int component17() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component4() {
        return null;
    }
    
    public final int component5() {
        return 0;
    }
    
    public final double component6() {
        return 0.0;
    }
    
    public final double component7() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component8() {
        return null;
    }
    
    public final double component9() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.ecoparc.data.model.Espece copy(int id, @org.jetbrains.annotations.NotNull()
    java.lang.String nom, @org.jetbrains.annotations.NotNull()
    java.lang.String nomScientifique, @org.jetbrains.annotations.NotNull()
    java.lang.String statutConservation, int populationEstimee, double latitude, double longitude, @org.jetbrains.annotations.NotNull()
    java.lang.String adresse, double temperatureMin, double temperatureMax, double humiditeMin, double humiditeMax, @org.jetbrains.annotations.NotNull()
    java.lang.String notes, long dateCreation, long dateModification, @org.jetbrains.annotations.NotNull()
    java.lang.String firebaseId, int syncStatus) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String toString() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0004R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/ecoparc/data/model/Espece$Companion;", "", "()V", "STATUTS", "", "", "getSTATUTS", "()Ljava/util/List;", "SYNC_DONE", "", "SYNC_PENDING", "getExemples", "Lcom/ecoparc/data/model/Espece;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<java.lang.String> getSTATUTS() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<com.ecoparc.data.model.Espece> getExemples() {
            return null;
        }
    }
}