package io.lb.meubeats.user_feature.domain.repository

import com.google.firebase.auth.FirebaseUser

interface UserRepository {
    fun insertUser(email: String, password: String)
    fun getUser(email: String, password: String, onComplete: (FirebaseUser?) -> Unit)
}