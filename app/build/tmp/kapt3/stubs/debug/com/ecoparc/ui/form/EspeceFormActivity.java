package com.ecoparc.ui.form;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u0018\u001a\u00020\u0017H\u0002J\u0012\u0010\u0019\u001a\u00020\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0014J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u0010 \u001a\u00020\u00172\u0006\u0010!\u001a\u00020\"H\u0002J\b\u0010#\u001a\u00020\u0017H\u0002J\b\u0010$\u001a\u00020\u0017H\u0002J\b\u0010%\u001a\u00020\u0017H\u0002J\b\u0010&\u001a\u00020\u0017H\u0002J\u0010\u0010\'\u001a\u00020\u00172\u0006\u0010(\u001a\u00020\u0010H\u0002J\b\u0010)\u001a\u00020\u0017H\u0002J\b\u0010*\u001a\u00020\u001dH\u0002J.\u0010+\u001a\u00020\u00172\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\u0014\u00100\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u001001H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001a\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0015\u0010\f\u001a\u0004\b\u0013\u0010\u0014\u00a8\u00062"}, d2 = {"Lcom/ecoparc/ui/form/EspeceFormActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "Lcom/ecoparc/databinding/ActivityEspeceFormBinding;", "especeId", "", "fusedLocation", "Lcom/google/android/gms/location/FusedLocationProviderClient;", "getFusedLocation", "()Lcom/google/android/gms/location/FusedLocationProviderClient;", "fusedLocation$delegate", "Lkotlin/Lazy;", "locationPermission", "Landroidx/activity/result/ActivityResultLauncher;", "", "", "viewModel", "Lcom/ecoparc/ui/form/EspeceFormViewModel;", "getViewModel", "()Lcom/ecoparc/ui/form/EspeceFormViewModel;", "viewModel$delegate", "fetchLocation", "", "observeViewModel", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onOptionsItemSelected", "", "item", "Landroid/view/MenuItem;", "populateForm", "e", "Lcom/ecoparc/data/model/Espece;", "reverseGeocode", "setupButtons", "setupSpinner", "setupValidation", "snack", "msg", "submitForm", "validateAll", "watch", "edit", "Landroid/widget/EditText;", "layout", "Lcom/google/android/material/textfield/TextInputLayout;", "validate", "Lkotlin/Function1;", "app_debug"})
public final class EspeceFormActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.ecoparc.databinding.ActivityEspeceFormBinding binding;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy fusedLocation$delegate = null;
    private int especeId = 0;
    @org.jetbrains.annotations.NotNull()
    private final androidx.activity.result.ActivityResultLauncher<java.lang.String[]> locationPermission = null;
    
    public EspeceFormActivity() {
        super();
    }
    
    private final com.ecoparc.ui.form.EspeceFormViewModel getViewModel() {
        return null;
    }
    
    private final com.google.android.gms.location.FusedLocationProviderClient getFusedLocation() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setupSpinner() {
    }
    
    private final void setupValidation() {
    }
    
    private final void watch(android.widget.EditText edit, com.google.android.material.textfield.TextInputLayout layout, kotlin.jvm.functions.Function1<? super java.lang.String, java.lang.String> validate) {
    }
    
    private final void setupButtons() {
    }
    
    @kotlin.Suppress(names = {"MissingPermission"})
    private final void fetchLocation() {
    }
    
    private final void reverseGeocode() {
    }
    
    private final boolean validateAll() {
        return false;
    }
    
    private final void submitForm() {
    }
    
    private final void observeViewModel() {
    }
    
    private final void populateForm(com.ecoparc.data.model.Espece e) {
    }
    
    @java.lang.Override()
    public boolean onOptionsItemSelected(@org.jetbrains.annotations.NotNull()
    android.view.MenuItem item) {
        return false;
    }
    
    private final void snack(java.lang.String msg) {
    }
}