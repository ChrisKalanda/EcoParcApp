package com.ecoparc.data.model;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b%\b\u0087\b\u0018\u0000 62\u00020\u0001:\u00016Bk\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0006\u0012\u0006\u0010\u000e\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u00a2\u0006\u0002\u0010\u0013J\t\u0010%\u001a\u00020\u0003H\u00c6\u0003J\t\u0010&\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\'\u001a\u00020\u0010H\u00c6\u0003J\t\u0010(\u001a\u00020\u0012H\u00c6\u0003J\t\u0010)\u001a\u00020\u0003H\u00c6\u0003J\t\u0010*\u001a\u00020\u0006H\u00c6\u0003J\t\u0010+\u001a\u00020\u0006H\u00c6\u0003J\t\u0010,\u001a\u00020\tH\u00c6\u0003J\t\u0010-\u001a\u00020\u0006H\u00c6\u0003J\t\u0010.\u001a\u00020\tH\u00c6\u0003J\t\u0010/\u001a\u00020\u0003H\u00c6\u0003J\t\u00100\u001a\u00020\u0006H\u00c6\u0003J\u0081\u0001\u00101\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0012H\u00c6\u0001J\u0013\u00102\u001a\u00020\u00122\b\u00103\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u00104\u001a\u00020\u0003H\u00d6\u0001J\t\u00105\u001a\u00020\u0006H\u00d6\u0001R\u0011\u0010\u000e\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0011\u0010\u0011\u001a\u00020\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u0011\u0010\r\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0015R\u0011\u0010\f\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0017R\u0011\u0010\n\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0015R\u0011\u0010\u000f\u001a\u00020\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0015R\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u000b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010#\u00a8\u00067"}, d2 = {"Lcom/ecoparc/data/model/Alerte;", "", "id", "", "especeId", "especeNom", "", "type", "valeurMesuree", "", "seuilDepasse", "valeurSeuil", "niveauAlerte", "message", "conseil", "timestamp", "", "estLue", "", "(IILjava/lang/String;Ljava/lang/String;DLjava/lang/String;DILjava/lang/String;Ljava/lang/String;JZ)V", "getConseil", "()Ljava/lang/String;", "getEspeceId", "()I", "getEspeceNom", "getEstLue", "()Z", "getId", "getMessage", "getNiveauAlerte", "getSeuilDepasse", "getTimestamp", "()J", "getType", "getValeurMesuree", "()D", "getValeurSeuil", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "Companion", "app_debug"})
@androidx.room.Entity(tableName = "alertes", foreignKeys = {@androidx.room.ForeignKey(entity = com.ecoparc.data.model.Espece.class, parentColumns = {"id"}, childColumns = {"especeId"}, onDelete = 5)}, indices = {@androidx.room.Index(value = {"especeId"})})
public final class Alerte {
    @androidx.room.PrimaryKey(autoGenerate = true)
    private final int id = 0;
    private final int especeId = 0;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String especeNom = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String type = null;
    private final double valeurMesuree = 0.0;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String seuilDepasse = null;
    private final double valeurSeuil = 0.0;
    private final int niveauAlerte = 0;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String message = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String conseil = null;
    private final long timestamp = 0L;
    private final boolean estLue = false;
    @org.jetbrains.annotations.NotNull()
    public static final com.ecoparc.data.model.Alerte.Companion Companion = null;
    
    public Alerte(int id, int especeId, @org.jetbrains.annotations.NotNull()
    java.lang.String especeNom, @org.jetbrains.annotations.NotNull()
    java.lang.String type, double valeurMesuree, @org.jetbrains.annotations.NotNull()
    java.lang.String seuilDepasse, double valeurSeuil, int niveauAlerte, @org.jetbrains.annotations.NotNull()
    java.lang.String message, @org.jetbrains.annotations.NotNull()
    java.lang.String conseil, long timestamp, boolean estLue) {
        super();
    }
    
    public final int getId() {
        return 0;
    }
    
    public final int getEspeceId() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getEspeceNom() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getType() {
        return null;
    }
    
    public final double getValeurMesuree() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSeuilDepasse() {
        return null;
    }
    
    public final double getValeurSeuil() {
        return 0.0;
    }
    
    public final int getNiveauAlerte() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getMessage() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getConseil() {
        return null;
    }
    
    public final long getTimestamp() {
        return 0L;
    }
    
    public final boolean getEstLue() {
        return false;
    }
    
    public final int component1() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component10() {
        return null;
    }
    
    public final long component11() {
        return 0L;
    }
    
    public final boolean component12() {
        return false;
    }
    
    public final int component2() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component4() {
        return null;
    }
    
    public final double component5() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component6() {
        return null;
    }
    
    public final double component7() {
        return 0.0;
    }
    
    public final int component8() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.ecoparc.data.model.Alerte copy(int id, int especeId, @org.jetbrains.annotations.NotNull()
    java.lang.String especeNom, @org.jetbrains.annotations.NotNull()
    java.lang.String type, double valeurMesuree, @org.jetbrains.annotations.NotNull()
    java.lang.String seuilDepasse, double valeurSeuil, int niveauAlerte, @org.jetbrains.annotations.NotNull()
    java.lang.String message, @org.jetbrains.annotations.NotNull()
    java.lang.String conseil, long timestamp, boolean estLue) {
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
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0018\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\b\u00a8\u0006\u000b"}, d2 = {"Lcom/ecoparc/data/model/Alerte$Companion;", "", "()V", "creerAlerteHumidite", "Lcom/ecoparc/data/model/Alerte;", "espece", "Lcom/ecoparc/data/model/Espece;", "hum", "", "creerAlerteTemperature", "temp", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.Nullable()
        public final com.ecoparc.data.model.Alerte creerAlerteTemperature(@org.jetbrains.annotations.NotNull()
        com.ecoparc.data.model.Espece espece, double temp) {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final com.ecoparc.data.model.Alerte creerAlerteHumidite(@org.jetbrains.annotations.NotNull()
        com.ecoparc.data.model.Espece espece, double hum) {
            return null;
        }
    }
}