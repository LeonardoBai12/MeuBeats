package io.lb.meubeats.user_feature.data.repository

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import io.lb.meubeats.user_feature.data.data_source.UserDataSource
import io.lb.meubeats.user_feature.domain.repository.UserRepository

class UserRepositoryImpl(
    private val userDataSource: UserDataSource
) : UserRepository {
    override fun getUser(email: String, password: String): Task<AuthResult> {
        return userDataSource.loginFirebaseUser(email, password)
    }

    override fun insertUser(email: String, password: String): Task<AuthResult> {
        return userDataSource.createFirebaseUser(email, password)
    }
}
