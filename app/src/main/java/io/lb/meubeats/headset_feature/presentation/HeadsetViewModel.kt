package io.lb.meubeats.headset_feature.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import io.lb.meubeats.headset_feature.domain.model.Headset
import io.lb.meubeats.headset_feature.domain.use_case.HeadsetUseCases
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

abstract class HeadsetViewModel(
    app: Application,
    private val useCases: HeadsetUseCases
): AndroidViewModel(app) {
    val headsets = MutableLiveData<List<Headset>>()
    val boughtHeadsets = MutableLiveData<List<Headset>>()

    fun getHeadsets() {
        CoroutineScope(Dispatchers.IO).launch {
            headsets.postValue(useCases.getHeadsetsUseCase())
        }
    }

    fun getBoughtHeadsets() {
        viewModelScope.launch {
            boughtHeadsets.postValue(useCases.getBoughtHeadsetsUseCase())
        }
    }
}