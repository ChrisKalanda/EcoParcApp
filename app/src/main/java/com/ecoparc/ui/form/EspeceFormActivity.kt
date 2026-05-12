package com.ecoparc.ui.form

import android.Manifest
import android.content.pm.PackageManager
import android.location.Geocoder
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.MenuItem
import android.view.View
import android.widget.ArrayAdapter
import android.widget.EditText
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.ecoparc.data.model.Espece
import com.ecoparc.databinding.ActivityEspeceFormBinding
import com.google.android.gms.location.LocationServices
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputLayout
import java.util.Locale

class EspeceFormActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEspeceFormBinding
    private val viewModel: EspeceFormViewModel by viewModels()
    private val fusedLocation by lazy { LocationServices.getFusedLocationProviderClient(this) }
    private var especeId = 0

    private val locationPermission = registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ) { perms ->
        if (perms[Manifest.permission.ACCESS_FINE_LOCATION] == true ||
            perms[Manifest.permission.ACCESS_COARSE_LOCATION] == true
        ) fetchLocation()
        else snack("Permission GPS refusée")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEspeceFormBinding.inflate(layoutInflater)
        setContentView(binding.root)

        especeId = intent.getIntExtra("espece_id", 0)
        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            title = if (especeId == 0) "Nouvelle espèce" else "Modifier l'espèce"
            setDisplayHomeAsUpEnabled(true)
        }

        setupSpinner()
        setupValidation()
        setupButtons()
        observeViewModel()
        if (especeId != 0) viewModel.loadEspece(especeId)
    }

    // ── Spinner statut ────────────────────────────────────────────

    private fun setupSpinner() {
        val items = listOf("— Sélectionner un statut —") + Espece.STATUTS
        binding.spinnerStatut.adapter =
            ArrayAdapter(this, android.R.layout.simple_spinner_item, items).also {
                it.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            }
    }

    // ── Validation temps réel ─────────────────────────────────────

    private fun setupValidation() {
        watch(binding.editNom, binding.layoutNom) { t ->
            when { t.isEmpty() -> "Nom obligatoire"; t.length < 2 -> "Minimum 2 caractères"; else -> null }
        }
        watch(binding.editNomScientifique, binding.layoutNomScientifique) { t ->
            if (t.isNotEmpty() && t.trim().split(" ").size < 2)
                "Indiquez genre et espèce (ex : Ursus maritimus)" else null
        }
        watch(binding.editPopulation, binding.layoutPopulation) { t ->
            when { t.isEmpty() -> "Population obligatoire"; t.toIntOrNull() == null -> "Entier requis"
                t.toInt() <= 0 -> "Valeur > 0 requise"; else -> null }
        }
        watch(binding.editLatitude, binding.layoutLatitude) { t ->
            when { t.isEmpty() -> "Latitude obligatoire"; t.toDoubleOrNull() == null -> "Nombre requis"
                t.toDouble() !in -90.0..90.0 -> "Entre -90 et 90"; else -> null }
        }
        watch(binding.editLongitude, binding.layoutLongitude) { t ->
            when { t.isEmpty() -> "Longitude obligatoire"; t.toDoubleOrNull() == null -> "Nombre requis"
                t.toDouble() !in -180.0..180.0 -> "Entre -180 et 180"; else -> null }
        }
        watch(binding.editTempMin, binding.layoutTempMin) { t ->
            when { t.isEmpty() -> "Température min obligatoire"; t.toDoubleOrNull() == null -> "Nombre requis"
                t.toDouble() < -60 || t.toDouble() > 60 -> "Entre -60 et 60 °C"; else -> null }
        }
        watch(binding.editTempMax, binding.layoutTempMax) { t ->
            val min = binding.editTempMin.text.toString().toDoubleOrNull()
            when { t.isEmpty() -> "Température max obligatoire"; t.toDoubleOrNull() == null -> "Nombre requis"
                min != null && t.toDouble() <= min -> "Max doit être > min (${min}°C)"; else -> null }
        }
        watch(binding.editHumMin, binding.layoutHumMin) { t ->
            when { t.isEmpty() -> "Humidité min obligatoire"; t.toDoubleOrNull() == null -> "Nombre requis"
                t.toDouble() !in 0.0..100.0 -> "Entre 0 et 100 %"; else -> null }
        }
        watch(binding.editHumMax, binding.layoutHumMax) { t ->
            val min = binding.editHumMin.text.toString().toDoubleOrNull()
            when { t.isEmpty() -> "Humidité max obligatoire"; t.toDoubleOrNull() == null -> "Nombre requis"
                t.toDouble() !in 0.0..100.0 -> "Entre 0 et 100 %"
                min != null && t.toDouble() <= min -> "Max doit être > min (${min}%)"; else -> null }
        }
    }

    private fun watch(edit: EditText, layout: TextInputLayout, validate: (String) -> String?) {
        edit.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, st: Int, c: Int, a: Int) {}
            override fun onTextChanged(s: CharSequence?, st: Int, b: Int, c: Int) {}
            override fun afterTextChanged(s: Editable?) {
                val err = validate(s?.toString()?.trim() ?: "")
                layout.error = err
                layout.isErrorEnabled = err != null
            }
        })
    }

    // ── Boutons GPS / Enregistrer / Annuler ───────────────────────

    private fun setupButtons() {
        binding.buttonGps.setOnClickListener {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) fetchLocation()
            else locationPermission.launch(arrayOf(
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION))
        }
        binding.buttonGeocoder.setOnClickListener { reverseGeocode() }
        binding.buttonEnregistrer.setOnClickListener { if (validateAll()) submitForm() }
        binding.buttonAnnuler.setOnClickListener { finish() }
    }

    @Suppress("MissingPermission")
    private fun fetchLocation() {
        binding.progressGps.visibility = View.VISIBLE
        binding.buttonGps.isEnabled = false
        fusedLocation.lastLocation
            .addOnSuccessListener { loc ->
                binding.progressGps.visibility = View.GONE
                binding.buttonGps.isEnabled = true
                if (loc != null) {
                    binding.editLatitude.setText(String.format(Locale.US, "%.6f", loc.latitude))
                    binding.editLongitude.setText(String.format(Locale.US, "%.6f", loc.longitude))
                    reverseGeocode()
                } else snack("GPS indisponible — activez la localisation")
            }
            .addOnFailureListener {
                binding.progressGps.visibility = View.GONE
                binding.buttonGps.isEnabled = true
                snack("Erreur GPS : ${it.message}")
            }
    }

    private fun reverseGeocode() {
        val lat = binding.editLatitude.text.toString().toDoubleOrNull() ?: return snack("Coordonnées invalides")
        val lon = binding.editLongitude.text.toString().toDoubleOrNull() ?: return snack("Coordonnées invalides")
        binding.progressGps.visibility = View.VISIBLE
        Thread {
            val adresse = try {
                @Suppress("DEPRECATION")
                Geocoder(this, Locale.getDefault()).getFromLocation(lat, lon, 1)
                    ?.firstOrNull()?.let { a ->
                        buildString {
                            a.thoroughfare?.let  { append("$it, ") }
                            (a.locality ?: a.subLocality)?.let { append("$it, ") }
                            a.adminArea?.let     { append("$it, ") }
                            a.countryName?.let   { append(it) }
                        }.trimEnd(',', ' ')
                    } ?: "GPS: %.4f, %.4f".format(lat, lon)
            } catch (_: Exception) { "GPS: %.4f, %.4f".format(lat, lon) }

            runOnUiThread {
                binding.progressGps.visibility = View.GONE
                binding.editAdresse.setText(adresse)
            }
        }.start()
    }

    // ── Validation complète avant soumission ──────────────────────

    private fun validateAll(): Boolean {
        var ok = true

        if (binding.spinnerStatut.selectedItemPosition == 0) {
            snack("Veuillez sélectionner un statut de conservation"); ok = false
        }

        // Déclencher la validation sur chaque champ obligatoire vide
        listOf(
            binding.editNom        to binding.layoutNom,
            binding.editPopulation to binding.layoutPopulation,
            binding.editLatitude   to binding.layoutLatitude,
            binding.editLongitude  to binding.layoutLongitude,
            binding.editTempMin    to binding.layoutTempMin,
            binding.editTempMax    to binding.layoutTempMax,
            binding.editHumMin     to binding.layoutHumMin,
            binding.editHumMax     to binding.layoutHumMax
        ).forEach { (edit, layout) ->
            if (edit.text.toString().trim().isEmpty()) {
                layout.error = "Champ obligatoire"
                layout.isErrorEnabled = true
                ok = false
            } else if (!layout.error.isNullOrEmpty()) ok = false
        }

        // Validation croisée temp
        val tMin = binding.editTempMin.text.toString().toDoubleOrNull()
        val tMax = binding.editTempMax.text.toString().toDoubleOrNull()
        if (tMin != null && tMax != null && tMax <= tMin) {
            binding.layoutTempMax.error = "Max doit être supérieur au min"; ok = false
        }
        // Validation croisée humidité
        val hMin = binding.editHumMin.text.toString().toDoubleOrNull()
        val hMax = binding.editHumMax.text.toString().toDoubleOrNull()
        if (hMin != null && hMax != null && hMax <= hMin) {
            binding.layoutHumMax.error = "Max doit être supérieur au min"; ok = false
        }

        if (!ok) snack("Veuillez corriger les erreurs indiquées")
        return ok
    }

    private fun submitForm() {
        val statuts = Espece.STATUTS
        viewModel.saveEspece(
            nom    = binding.editNom.text.toString().trim(),
            nomSci = binding.editNomScientifique.text.toString().trim(),
            statut = statuts[binding.spinnerStatut.selectedItemPosition - 1],
            pop    = binding.editPopulation.text.toString().toInt(),
            lat    = binding.editLatitude.text.toString().toDouble(),
            lon    = binding.editLongitude.text.toString().toDouble(),
            adresse= binding.editAdresse.text.toString().trim(),
            tMin   = binding.editTempMin.text.toString().toDouble(),
            tMax   = binding.editTempMax.text.toString().toDouble(),
            hMin   = binding.editHumMin.text.toString().toDouble(),
            hMax   = binding.editHumMax.text.toString().toDouble(),
            notes  = binding.editNotes.text.toString().trim()
        )
    }

    // ── Observer ViewModel ────────────────────────────────────────

    private fun observeViewModel() {
        viewModel.espece.observe(this) { it?.let { e -> populateForm(e) } }
        viewModel.saveResult.observe(this) { result ->
            result.onSuccess { finish() }
            result.onFailure { snack("Erreur : ${it.message}") }
        }
        viewModel.isLoading.observe(this) { loading ->
            binding.buttonEnregistrer.isEnabled = !loading
            binding.progressBar.visibility = if (loading) View.VISIBLE else View.GONE
        }
    }

    private fun populateForm(e: Espece) {
        binding.editNom.setText(e.nom)
        binding.editNomScientifique.setText(e.nomScientifique)
        binding.editPopulation.setText(e.populationEstimee.toString())
        binding.editLatitude.setText(e.latitude.toString())
        binding.editLongitude.setText(e.longitude.toString())
        binding.editAdresse.setText(e.adresse)
        binding.editTempMin.setText(e.temperatureMin.toString())
        binding.editTempMax.setText(e.temperatureMax.toString())
        binding.editHumMin.setText(e.humiditeMin.toString())
        binding.editHumMax.setText(e.humiditeMax.toString())
        binding.editNotes.setText(e.notes)
        val idx = Espece.STATUTS.indexOf(e.statutConservation)
        if (idx >= 0) binding.spinnerStatut.setSelection(idx + 1)
    }

    override fun onOptionsItemSelected(item: MenuItem) =
        if (item.itemId == android.R.id.home) { finish(); true } else super.onOptionsItemSelected(item)

    private fun snack(msg: String) = Snackbar.make(binding.root, msg, Snackbar.LENGTH_SHORT).show()
}
