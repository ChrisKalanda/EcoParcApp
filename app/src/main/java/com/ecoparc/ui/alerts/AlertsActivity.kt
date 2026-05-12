package com.ecoparc.ui.alerts

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.ecoparc.databinding.ActivityAlertsBinding
import com.google.android.material.snackbar.Snackbar

class AlertsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAlertsBinding
    private val viewModel: AlertsViewModel by viewModels()
    private lateinit var adapter: AlerteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAlertsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply { title = "Alertes écologiques"; setDisplayHomeAsUpEnabled(true) }

        adapter = AlerteAdapter { alerte -> viewModel.marquerCommeLue(alerte.id) }
        binding.recyclerViewAlertes.apply {
            layoutManager = LinearLayoutManager(this@AlertsActivity)
            adapter = this@AlertsActivity.adapter
        }

        binding.buttonMarquerToutesLues.setOnClickListener {
            viewModel.marquerToutesLues()
            Snackbar.make(binding.root, "Toutes les alertes marquées comme lues", Snackbar.LENGTH_SHORT).show()
        }

        viewModel.alertes.observe(this) { list ->
            adapter.submitList(list)
            val empty = list.isEmpty()
            binding.textEmpty.visibility          = if (empty) View.VISIBLE else View.GONE
            binding.recyclerViewAlertes.visibility = if (empty) View.GONE   else View.VISIBLE
            binding.textCountAlertes.text =
                "${list.size} alerte${if (list.size != 1) "s" else ""}"
        }
    }

    override fun onOptionsItemSelected(item: MenuItem) =
        if (item.itemId == android.R.id.home) { finish(); true }
        else super.onOptionsItemSelected(item)
}
