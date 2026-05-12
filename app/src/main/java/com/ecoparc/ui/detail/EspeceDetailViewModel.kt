package com.ecoparc.ui.detail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.ecoparc.data.model.Alerte
import com.ecoparc.data.model.Espece
import com.ecoparc.data.repository.EspeceRepository

class EspeceDetailViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = EspeceRepository(application)

    private var _espece: LiveData<Espece?>? = null
    val espece: LiveData<Espece?> get() = _espece!!

    private var _alertes: LiveData<List<Alerte>>? = null
    val alertes: LiveData<List<Alerte>> get() = _alertes!!

    fun load(id: Int) {
        _espece  = repository.getEspeceById(id)
        _alertes = repository.getAlertesForEspece(id)
    }
}
