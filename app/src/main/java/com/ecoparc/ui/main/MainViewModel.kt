package com.ecoparc.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.ecoparc.data.model.Espece
import com.ecoparc.data.repository.EspeceRepository
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = EspeceRepository(application)

    val allEspeces: LiveData<List<Espece>> = repository.allEspeces
    val countAlertesNonLues: LiveData<Int> = repository.countAlertesNonLues

    private val _filteredEspeces = MutableLiveData<List<Espece>>(emptyList())
    val filteredEspeces: LiveData<List<Espece>> = _filteredEspeces

    private val _syncMessage = MutableLiveData<String>()
    val syncMessage: LiveData<String> = _syncMessage

    private val _isLoading = MutableLiveData(false)
    val isLoading: LiveData<Boolean> = _isLoading

    private var currentQuery = ""

    init {
        allEspeces.observeForever { applyFilter(it) }
    }

    fun search(query: String) {
        currentQuery = query
        applyFilter(allEspeces.value ?: emptyList())
    }

    private fun applyFilter(list: List<Espece>) {
        _filteredEspeces.value = if (currentQuery.isBlank()) list
        else list.filter {
            it.nom.contains(currentQuery, true) ||
            it.nomScientifique.contains(currentQuery, true) ||
            it.statutConservation.contains(currentQuery, true) ||
            it.adresse.contains(currentQuery, true)
        }
    }

    fun deleteEspece(espece: Espece) = viewModelScope.launch { repository.deleteEspece(espece) }

    fun syncData() = viewModelScope.launch {
        _isLoading.value = true
        try {
            repository.syncPendingEspeces()
            _syncMessage.value = "Synchronisation réussie ✓"
        } catch (e: Exception) {
            _syncMessage.value = "Mode hors ligne — sync en attente"
        } finally {
            _isLoading.value = false
        }
    }
}
