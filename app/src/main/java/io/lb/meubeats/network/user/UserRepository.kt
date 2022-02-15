package io.lb.meubeats.network.user

import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth

class UserRepository(
    private val auth: FirebaseAuth,
) {
    fun createFirebaseUser(
        context: AppCompatActivity,
        email: String,
        password: String,
        onCompleted: (Task<AuthResult>) -> Unit
    ): Task<AuthResult> {
        return auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(context) {
                onCompleted(it)
            }
    }

    fun loginFirebaseUser(
        context: AppCompatActivity,
        email: String,
        password: String,
        onCompleted: (Task<AuthResult>) -> Unit
    ): Task<AuthResult> {
        return auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(context) {
                onCompleted(it)
            }
    }
}
