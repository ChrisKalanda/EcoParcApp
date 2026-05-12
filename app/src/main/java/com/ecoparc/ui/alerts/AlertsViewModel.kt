package com.ecoparc.ui.alerts

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.ecoparc.data.model.Alerte
import com.ecoparc.data.repository.EspeceRepository
import kotlinx.coroutines.launch

class AlertsViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = EspeceRepository(application)

    val alertes: LiveData<List<Alerte>> = repository.allAlertes

    fun marquerCommeLue(id: Int)   = viewModelScope.launch { repository.marquerAlerteCommeLue(id) }
    fun marquerToutesLues()        = viewModelScope.launch { repository.marquerToutesAlertesLues() }
}
