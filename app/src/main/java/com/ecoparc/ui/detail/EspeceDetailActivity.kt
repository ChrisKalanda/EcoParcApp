package com.ecoparc.ui.detail

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.ecoparc.R
import com.ecoparc.data.model.Espece
import com.ecoparc.databinding.ActivityEspeceDetailBinding
import com.ecoparc.ui.form.EspeceFormActivity
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class EspeceDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEspeceDetailBinding
    private val viewModel: EspeceDetailViewModel by viewModels()
    private var especeId = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEspeceDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        especeId = intent.getIntExtra("espece_id", 0)
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        viewModel.load(especeId)

        viewModel.espece.observe(this) { e -> e?.let { display(it) } }
        viewModel.alertes.observe(this) { list ->
            binding.textAlertesCount.text =
                "${list.size} alerte${if (list.size != 1) "s" else ""} générée${if (list.size != 1) "s" else ""}"
        }

        binding.fabEdit.setOnClickListener {
            startActivity(Intent(this, EspeceFormActivity::class.java)
                .putExtra("espece_id", especeId))
        }
    }

    private fun display(e: Espece) {
        supportActionBar?.title = e.nom

        binding.textNomDetail.text            = e.nom
        binding.textNomScientifiqueDetail.text = e.nomScientifique.ifEmpty { "—" }
        binding.textStatutDetail.text         = e.statutConservation
        binding.textPopulationDetail.text     = "${formatPop(e.populationEstimee)} individus estimés"
        binding.textAdresseDetail.text        = e.adresse.ifEmpty {
            "GPS : ${String.format("%.4f", e.latitude)}, ${String.format("%.4f", e.longitude)}"
        }
        binding.textCoordsDetail.text =
            "Lat : ${String.format("%.6f", e.latitude)}  |  Lon : ${String.format("%.6f", e.longitude)}"
        binding.textTempDetail.text = "${e.temperatureMin}°C — ${e.temperatureMax}°C"
        binding.textHumDetail.text  = "${e.humiditeMin}% — ${e.humiditeMax}%"

        if (e.notes.isNotEmpty()) {
            binding.textNotesDetail.text = e.notes
            binding.cardNotes.visibility = View.VISIBLE
        } else {
            binding.cardNotes.visibility = View.GONE
        }

        val sdf = SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.FRANCE)
        binding.textDateCreation.text     = "Créé le : ${sdf.format(Date(e.dateCreation))}"
        binding.textDateModification.text = "Modifié le : ${sdf.format(Date(e.dateModification))}"
        binding.iconSyncDetail.visibility =
            if (e.syncStatus == Espece.SYNC_PENDING) View.VISIBLE else View.GONE

        // Badge statut couleur
        val (bg, _) = when (e.statutConservation) {
            "En danger critique" -> R.drawable.bg_statut_cr to R.color.statut_cr_text
            "En danger"          -> R.drawable.bg_statut_en to R.color.statut_en_text
            "Vulnérable"         -> R.drawable.bg_statut_vu to R.color.statut_vu_text
            "Quasi menacé"       -> R.drawable.bg_statut_nt to R.color.statut_nt_text
            else                 -> R.drawable.bg_statut_lc to R.color.statut_lc_text
        }
        binding.textStatutDetail.setBackgroundResource(bg)
    }

    private fun formatPop(p: Int) = when {
        p >= 1_000_000 -> "${"%.1f".format(p / 1_000_000.0)} M"
        p >= 1_000     -> "${"%.1f".format(p / 1_000.0)} K"
        else           -> p.toString()
    }

    override fun onOptionsItemSelected(item: MenuItem) =
        if (item.itemId == android.R.id.home) { finish(); true }
        else super.onOptionsItemSelected(item)
}
