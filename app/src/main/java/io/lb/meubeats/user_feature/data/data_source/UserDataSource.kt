package io.lb.meubeats.user_feature.data.data_source

import com.google.firebase.auth.FirebaseAuth

class UserDataSource(
    private val auth: FirebaseAuth,
) {
    fun createFirebaseUser(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password)
    }

    fun loginFirebaseUser(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener {

        }
    }
}