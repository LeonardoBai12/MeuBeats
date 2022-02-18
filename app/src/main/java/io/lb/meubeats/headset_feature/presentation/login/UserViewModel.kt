package io.lb.meubeats.headset_feature.presentation.login

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import io.lb.meubeats.user_feature.domain.repository.UserRepository
import javax.inject.Inject

class UserViewModel @Inject constructor(
    private val repository: UserRepository
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