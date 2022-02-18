package io.lb.meubeats.user_feature.data.data_source

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class UserDataSource(
    private val auth: FirebaseAuth,
) {
    fun createFirebaseUser(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password)
    }

    fun loginFirebaseUser(
        email: String,
        password: String,
        onComplete: (FirebaseUser?) -> Unit
    ) {
        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
            if (it.isSuccessful)
                onComplete(it.result.user)
            else
                onComplete(null)
        }
    }
}