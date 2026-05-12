package com.ecoparc.ui.form

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.ecoparc.data.model.Espece
import com.ecoparc.data.repository.EspeceRepository
import kotlinx.coroutines.launch

class EspeceFormViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = EspeceRepository(application)

    private val _espece = MutableLiveData<Espece?>()
    val espece: LiveData<Espece?> = _espece

    private val _saveResult = MutableLiveData<Result<Unit>>()
    val saveResult: LiveData<Result<Unit>> = _saveResult

    private val _isLoading = MutableLiveData(false)
    val isLoading: LiveData<Boolean> = _isLoading

    fun loadEspece(id: Int) {
        repository.getEspeceById(id).observeForever { _espece.value = it }
    }

    fun saveEspece(
        nom: String, nomSci: String, statut: String, pop: Int,
        lat: Double, lon: Double, adresse: String,
        tMin: Double, tMax: Double, hMin: Double, hMax: Double, notes: String
    ) = viewModelScope.launch {
        _isLoading.value = true
        try {
            val existing = _espece.value
            val espece = Espece(
                id = existing?.id ?: 0,
                nom = nom, nomScientifique = nomSci, statutConservation = statut,
                populationEstimee = pop, latitude = lat, longitude = lon, adresse = adresse,
                temperatureMin = tMin, temperatureMax = tMax,
                humiditeMin = hMin, humiditeMax = hMax, notes = notes,
                firebaseId = existing?.firebaseId ?: ""
            )
            if (existing == null || existing.id == 0) repository.insertEspece(espece)
            else repository.updateEspece(espece)
            _saveResult.value = Result.success(Unit)
        } catch (e: Exception) {
            _saveResult.value = Result.failure(e)
        } finally {
            _isLoading.value = false
        }
    }
}
