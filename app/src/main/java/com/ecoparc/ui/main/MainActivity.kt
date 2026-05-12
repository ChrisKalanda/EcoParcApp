package com.ecoparc.ui.main

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ecoparc.R
import com.ecoparc.data.model.Espece
import com.ecoparc.databinding.ActivityMainBinding
import com.ecoparc.service.MonitoringService
import com.ecoparc.ui.alerts.AlertsActivity
import com.ecoparc.ui.detail.EspeceDetailActivity
import com.ecoparc.ui.form.EspeceFormActivity
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()
    private lateinit var adapter: EspeceAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        supportActionBar?.title = "EcoParc"

        setupRecyclerView()
        binding.fabAjouter.setOnClickListener { openForm(null) }
        observeViewModel()

        startService(Intent(this, MonitoringService::class.java))
    }

    private fun setupRecyclerView() {
        adapter = EspeceAdapter(
            onItemClick   = { openDetail(it) },
            onEditClick   = { openForm(it) },
            onDeleteClick = { showDeleteDialog(it) }
        )
        binding.recyclerViewEspeces.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = this@MainActivity.adapter
        }
        ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {
            override fun onMove(rv: RecyclerView, vh: RecyclerView.ViewHolder, t: RecyclerView.ViewHolder) = false
            override fun onSwiped(vh: RecyclerView.ViewHolder, dir: Int) {
                showDeleteDialog(adapter.getEspeceAt(vh.adapterPosition)) {
                    adapter.notifyItemChanged(vh.adapterPosition)
                }
            }
        }).attachToRecyclerView(binding.recyclerViewEspeces)
    }

    private fun observeViewModel() {
        viewModel.filteredEspeces.observe(this) { list ->
            adapter.submitList(list)
            val empty = list.isEmpty()
            binding.layoutEmpty.visibility          = if (empty) View.VISIBLE else View.GONE
            binding.recyclerViewEspeces.visibility  = if (empty) View.GONE    else View.VISIBLE
            binding.textViewCount.text = "${list.size} espèce${if (list.size != 1) "s" else ""} surveillée${if (list.size != 1) "s" else ""}"
        }
        viewModel.syncMessage.observe(this) { msg ->
            Snackbar.make(binding.root, msg, Snackbar.LENGTH_SHORT).show()
        }
        viewModel.isLoading.observe(this) { loading ->
            binding.progressBar.visibility = if (loading) View.VISIBLE else View.GONE
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        val sv = menu.findItem(R.id.action_search).actionView as SearchView
        sv.queryHint = "Rechercher une espèce..."
        sv.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(q: String?) = true
            override fun onQueryTextChange(q: String?): Boolean { viewModel.search(q ?: ""); return true }
        })
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.action_alerts -> { startActivity(Intent(this, AlertsActivity::class.java)); true }
        R.id.action_sync   -> { viewModel.syncData(); true }
        R.id.action_filter -> { showFilterDialog(); true }
        else -> super.onOptionsItemSelected(item)
    }

    private fun showFilterDialog() {
        val items = arrayOf("Toutes") + Espece.STATUTS.toTypedArray()
        AlertDialog.Builder(this).setTitle("Filtrer par statut")
            .setItems(items) { _, i -> viewModel.search(if (i == 0) "" else items[i]) }
            .show()
    }

    private fun showDeleteDialog(espece: Espece, onCancel: (() -> Unit)? = null) {
        AlertDialog.Builder(this)
            .setTitle("Supprimer ${espece.nom} ?")
            .setMessage("Cette action est irréversible.")
            .setPositiveButton("Supprimer") { _, _ ->
                viewModel.deleteEspece(espece)
                Snackbar.make(binding.root, "${espece.nom} supprimé", Snackbar.LENGTH_SHORT).show()
            }
            .setNegativeButton("Annuler") { _, _ -> onCancel?.invoke() }
            .setOnCancelListener { onCancel?.invoke() }
            .show()
    }

    private fun openForm(espece: Espece?) {
        startActivity(Intent(this, EspeceFormActivity::class.java).apply {
            espece?.let { putExtra("espece_id", it.id) }
        })
    }

    private fun openDetail(espece: Espece) {
        startActivity(Intent(this, EspeceDetailActivity::class.java).putExtra("espece_id", espece.id))
    }
}
