package com.ecoparc.ui.alerts

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ecoparc.R
import com.ecoparc.data.model.Alerte
import com.ecoparc.databinding.ItemAlerteBinding
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class AlerteAdapter(
    private val onMarquerLue: (Alerte) -> Unit
) : ListAdapter<Alerte, AlerteAdapter.VH>(Diff()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        VH(ItemAlerteBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: VH, position: Int) = holder.bind(getItem(position))

    inner class VH(private val b: ItemAlerteBinding) : RecyclerView.ViewHolder(b.root) {

        fun bind(a: Alerte) {
            b.textEspeceNom.text  = a.especeNom
            b.textMessage.text    = a.message
            b.textConseil.text    = a.conseil
            b.textTimestamp.text  = SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.FRANCE).format(Date(a.timestamp))

            val unite = if (a.type == "TEMPERATURE") "°C" else "%"
            b.textTypeAlerte.text = "${if (a.type == "TEMPERATURE") "Température" else "Humidité"} : " +
                    "${String.format("%.1f", a.valeurMesuree)}$unite"
            b.textSeuil.text = "Seuil ${if (a.seuilDepasse == "MAX") "max" else "min"} : ${a.valeurSeuil}$unite"

            if (a.niveauAlerte == 2) {
                b.cardAlerte.setCardBackgroundColor(ContextCompat.getColor(b.root.context, R.color.alerte_critique_bg))
                b.textNiveauAlerte.text = "⚠ CRITIQUE"
                b.textNiveauAlerte.setTextColor(ContextCompat.getColor(b.root.context, R.color.alerte_critique_text))
            } else {
                b.cardAlerte.setCardBackgroundColor(ContextCompat.getColor(b.root.context, R.color.alerte_warning_bg))
                b.textNiveauAlerte.text = "△ AVERTISSEMENT"
                b.textNiveauAlerte.setTextColor(ContextCompat.getColor(b.root.context, R.color.alerte_warning_text))
            }

            b.viewUnread.visibility      = if (!a.estLue) View.VISIBLE else View.GONE
            b.buttonMarquerLue.visibility = if (!a.estLue) View.VISIBLE else View.GONE
            b.buttonMarquerLue.setOnClickListener { onMarquerLue(a) }
        }
    }

    class Diff : DiffUtil.ItemCallback<Alerte>() {
        override fun areItemsTheSame(o: Alerte, n: Alerte) = o.id == n.id
        override fun areContentsTheSame(o: Alerte, n: Alerte) = o == n
    }
}
