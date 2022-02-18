package io.lb.meubeats.user_feature.presentation.login

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import io.lb.meubeats.user_feature.domain.repository.UserRepositoryImpl
import javax.inject.Inject

class LoginViewModel @Inject constructor(
    private val repository: UserRepositoryImpl
) : ViewModel() {
    fun createFirebaseUser(
        context: AppCompatActivity,
        email: String,
        password: String,
        onCompleted: (Task<AuthResult>) -> Unit
    ): Task<AuthResult> {
        return repository.createFirebaseUser(context, email, password, onCompleted)
    }

    fun loginFirebaseUser(
        context: AppCompatActivity,
        email: String,
        password: String,
        onCompleted: (Task<AuthResult>) -> Unit
    ): Task<AuthResult> {
        return repository.loginFirebaseUser(context, email, password, onCompleted)
    }
}