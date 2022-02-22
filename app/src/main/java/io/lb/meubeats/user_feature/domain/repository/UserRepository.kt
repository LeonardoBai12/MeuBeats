package io.lb.meubeats.user_feature.domain.repository

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult

interface UserRepository {
    fun insertUser(email: String, password: String): Task<AuthResult>
    fun getUser(email: String, password: String): Task<AuthResult>
}