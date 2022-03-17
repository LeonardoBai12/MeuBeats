package io.lb.meubeats.headset_feature.presentation.headset

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import io.lb.meubeats.headset_feature.domain.model.Headset
import io.lb.meubeats.headset_feature.domain.model.InvalidHeadsetException
import io.lb.meubeats.headset_feature.domain.use_case.HeadsetUseCases
import io.lb.meubeats.headset_feature.presentation.HeadsetViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class HeadsetListViewModel @Inject constructor(
    private val useCases: HeadsetUseCases
): HeadsetViewModel(useCases) {
    var selectedHeadset = MutableLiveData<Headset?>()
    var selectedPosition: Int? = null

    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    sealed class UiEvent {
        data class ShowToast(val message: String): UiEvent()
        object OnHeadsetSelected: UiEvent()
        data class OnHeadsetDetailsClicked(val headset: Headset): UiEvent()
        object OnLogoutSuccess: UiEvent()
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
                is HeadsetEvent.PressedLogout -> {
                    useCases.logoutUseCase()
                    _eventFlow.emit(UiEvent.OnLogoutSuccess)
                }
                is HeadsetEvent.PressedAdd -> {
                    val headset = selectedHeadset.value ?: return@launch
                    try {
                        useCases.insertHeadsetUseCase(event.id, headset)
                            .addOnSuccessListener {
                                getBoughtHeadsets()
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
}