package com.ecoparc.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ecoparc.R
import com.ecoparc.data.model.Espece
import com.ecoparc.databinding.ItemEspeceBinding

class EspeceAdapter(
    private val onItemClick:   (Espece) -> Unit,
    private val onEditClick:   (Espece) -> Unit,
    private val onDeleteClick: (Espece) -> Unit
) : ListAdapter<Espece, EspeceAdapter.VH>(Diff()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        VH(ItemEspeceBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: VH, position: Int) = holder.bind(getItem(position))

    fun getEspeceAt(position: Int): Espece = getItem(position)

    inner class VH(private val b: ItemEspeceBinding) : RecyclerView.ViewHolder(b.root) {

        fun bind(e: Espece) {
            b.textNom.text = e.nom
            b.textNomScientifique.text = e.nomScientifique
            b.textNomScientifique.visibility = if (e.nomScientifique.isEmpty()) View.GONE else View.VISIBLE
            b.textAdresse.text = e.adresse.ifEmpty {
                "GPS: ${String.format("%.4f", e.latitude)}, ${String.format("%.4f", e.longitude)}"
            }
            b.textPopulation.text = "Population estimée : ${formatPop(e.populationEstimee)}"
            b.textTemperature.text = "🌡 ${e.temperatureMin}°C → ${e.temperatureMax}°C"
            b.textHumidite.text    = "💧 ${e.humiditeMin}% → ${e.humiditeMax}%"
            b.textStatut.text      = e.statutConservation

            val (bgRes, colorRes) = statutColors(e.statutConservation)
            b.textStatut.setBackgroundResource(bgRes)
            b.textStatut.setTextColor(ContextCompat.getColor(b.root.context, colorRes))

            b.iconSync.visibility = if (e.syncStatus == Espece.SYNC_PENDING) View.VISIBLE else View.GONE

            b.root.setOnClickListener          { onItemClick(e) }
            b.buttonEdit.setOnClickListener    { onEditClick(e) }
            b.buttonDelete.setOnClickListener  { onDeleteClick(e) }
        }

        private fun statutColors(s: String) = when (s) {
            "En danger critique" -> R.drawable.bg_statut_cr to R.color.statut_cr_text
            "En danger"          -> R.drawable.bg_statut_en to R.color.statut_en_text
            "Vulnérable"         -> R.drawable.bg_statut_vu to R.color.statut_vu_text
            "Quasi menacé"       -> R.drawable.bg_statut_nt to R.color.statut_nt_text
            else                 -> R.drawable.bg_statut_lc to R.color.statut_lc_text
        }

        private fun formatPop(p: Int) = when {
            p >= 1_000_000 -> "${"%.1f".format(p / 1_000_000.0)} M"
            p >= 1_000     -> "${"%.1f".format(p / 1_000.0)} K"
            else           -> p.toString()
        }
    }

    class Diff : DiffUtil.ItemCallback<Espece>() {
        override fun areItemsTheSame(o: Espece, n: Espece) = o.id == n.id
        override fun areContentsTheSame(o: Espece, n: Espece) = o == n
    }
}
