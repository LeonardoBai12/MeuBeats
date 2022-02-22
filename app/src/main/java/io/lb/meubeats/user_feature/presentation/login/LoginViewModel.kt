package io.lb.meubeats.user_feature.presentation.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.lb.meubeats.user_feature.domain.use_case.UserUseCases
import io.lb.meubeats.user_feature.domain.util.InvalidUserException
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class LoginViewModel @Inject constructor(
    private val useCases: UserUseCases
) : ViewModel() {
    private var typedEmail: String? = null
    private var typedPassword: String? = null

    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    sealed class UiEvent {
        data class ShowToast(val message: String): UiEvent()
        object Login: UiEvent()
    }

    fun onEvent(event: LoginEvent) {
        viewModelScope.launch {
            when (event) {
                is LoginEvent.EnteredEmail -> {
                    typedEmail = event.value
                }
                is LoginEvent.EnteredPassword -> {
                    typedPassword = event.value
                }
                is LoginEvent.PressedLogin -> {
                    try {
                        useCases.getUserUseCase(typedEmail, typedPassword).addOnSuccessListener {
                            emit(UiEvent.Login)
                        }.addOnFailureListener {
                            emit(exceptionToast(it))
                        }
                    } catch (e: Exception) {
                        _eventFlow.emit(exceptionToast(e))
                    }
                }
            }
        }
    }

    private fun exceptionToast(e: Exception) =
        UiEvent.ShowToast(
            message = e.message ?: "Something went wrong!"
        )

    private fun emit(event: UiEvent) {
        viewModelScope.launch {
            _eventFlow.emit(event)
        }
    }
}