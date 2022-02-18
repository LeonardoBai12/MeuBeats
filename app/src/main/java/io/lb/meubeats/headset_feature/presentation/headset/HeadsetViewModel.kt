package io.lb.meubeats.headset_feature.presentation.headset

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.lb.meubeats.headset_feature.domain.model.Headset
import io.lb.meubeats.headset_feature.domain.use_case.HeadsetUseCases
import io.lb.meubeats.user_feature.presentation.login.LoginViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import javax.inject.Inject

class HeadsetViewModel @Inject constructor(
    private val useCases: HeadsetUseCases
): ViewModel() {
    private var headsets = MutableLiveData<ArrayList<Headset>>()
    var selectedHeadset = MutableLiveData<Headset?>()
    var selectedPosition: Int? = null

    private val _eventFlow = MutableSharedFlow<LoginViewModel.UiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    sealed class UiEvent {
        data class ShowToast(val message: String): UiEvent()
        object InsertHeadset: UiEvent()
    }

    fun getHeadsets(): MutableLiveData<ArrayList<Headset>> {
        headsets.value = useCases.getHeadsetsUseCase()
        return headsets
    }

    fun insertHeadset(id: Int, headset: Headset, onCompleted: () -> Unit) {

    }

    fun getHeadsetsFromFirebase(onDataChanged: (ArrayList<Headset>) -> Unit) {

    }
}