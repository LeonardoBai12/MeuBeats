package io.lb.meubeats.headset_feature.presentation.headset_details

import androidx.lifecycle.viewModelScope
import io.lb.meubeats.headset_feature.domain.use_case.HeadsetUseCases
import io.lb.meubeats.headset_feature.presentation.HeadsetViewModel
import io.lb.meubeats.user_feature.domain.util.InvalidUserException
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class HeadsetDetailsViewModel @Inject constructor(
    private val useCases: HeadsetUseCases
): HeadsetViewModel(useCases) {
    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    sealed class UiEvent {
        data class ShowToast(val message: String): UiEvent()
    }

    fun onEvent(event: HeadsetDetailsEvent) {
        viewModelScope.launch {
            when (event) {
                is HeadsetDetailsEvent.PressedAdd -> {
                    val headset = event.headset ?: return@launch
                    try {
                        useCases.insertHeadsetUseCase(event.id, headset)
                            .addOnSuccessListener{
                                getBoughtHeadsets()
                                emitToast("Produto adicionado com sucesso")
                            }
                    } catch (e: InvalidUserException) {
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