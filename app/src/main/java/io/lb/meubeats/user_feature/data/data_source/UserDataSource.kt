package io.lb.meubeats.user_feature.data.data_source

import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.callbackFlow

class UserDataSource(
    private val auth: FirebaseAuth,
) {
    fun createFirebaseUser(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password)
    }

    fun loginFirebaseUser(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
    }

    fun getFirebaseAuthState() = callbackFlow  {
        val authStateListener = FirebaseAuth.AuthStateListener { auth ->
            trySend(auth.currentUser == null)
        }
        auth.addAuthStateListener(authStateListener)
        awaitClose {
            auth.removeAuthStateListener(authStateListener)
        }
    }
}