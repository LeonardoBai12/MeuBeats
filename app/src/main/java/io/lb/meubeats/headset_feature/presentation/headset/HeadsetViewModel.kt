package io.lb.meubeats.headset_feature.presentation.headset

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.lb.meubeats.headset_feature.domain.model.Headset
import io.lb.meubeats.headset_feature.domain.model.InvalidHeadsetException
import io.lb.meubeats.headset_feature.domain.use_case.HeadsetUseCases
import io.lb.meubeats.user_feature.domain.util.InvalidUserException
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class HeadsetViewModel @Inject constructor(
    private val useCases: HeadsetUseCases
): ViewModel() {
    private var headsets = MutableLiveData<ArrayList<Headset>>()
    var selectedHeadset = MutableLiveData<Headset?>()
    var selectedPosition: Int? = null

    private val _eventFlow = MutableSharedFlow<HeadsetViewModel.UiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    sealed class UiEvent {
        data class ShowToast(val message: String): UiEvent()
        object OnHeadsetSelected: UiEvent()
        data class OnHeadsetDetailsClicked(val headset: Headset): UiEvent()
    }

    fun onEvent(event: HeadsetEvent) {
        viewModelScope.launch {
            when (event) {
                is HeadsetEvent.OnHeadsetSelected -> {
                    selectedPosition = event.id
                    selectedHeadset.value = event.headset

                    _eventFlow.emit(UiEvent.OnHeadsetSelected)
                }
                is HeadsetEvent.OnHeadsetDetailsClicked -> {
                    val headset = selectedHeadset.value ?: return@launch
                    _eventFlow.emit(UiEvent.OnHeadsetDetailsClicked(headset))
                }
                is HeadsetEvent.PressedAdd -> {
                    val headset = selectedHeadset.value ?: return@launch
                    try {
                        useCases.insertHeadsetToFirebaseUseCase(event.id, headset) {
                            emitToast("Produto adicionado com sucesso")
                        }
                    } catch (e: InvalidHeadsetException) {
                        emitToast(e.message ?: "Erro ao adicionar produto")
                    }
                }
            }
        }
    }

    private fun emitToast(message: String) {
        viewModelScope.launch {
            _eventFlow.emit(UiEvent.ShowToast(message))
        }
    }

    fun getHeadsets(): MutableLiveData<ArrayList<Headset>> {
        headsets.value = useCases.getHeadsetsUseCase()
        return headsets
    }

    fun getHeadsetsFromFirebase(onDataChanged: (ArrayList<Headset>) -> Unit) {
        useCases.getHeadsetsFromFirebaseUseCase(onDataChanged)
    }
}