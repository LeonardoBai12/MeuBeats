package io.lb.meubeats.user_feature.data.repository

import com.google.firebase.auth.FirebaseUser
import io.lb.meubeats.user_feature.data.data_source.UserDataSource
import io.lb.meubeats.user_feature.domain.repository.UserRepository

class UserRepositoryImpl(
    private val userDataSource: UserDataSource
) : UserRepository {
    override fun getUser(
        email: String,
        password: String,
        onComplete: (FirebaseUser?) -> Unit
    ) {
        userDataSource.loginFirebaseUser(email, password, onComplete)
    }

    override fun insertUser(email: String, password: String) {
        userDataSource.createFirebaseUser(email, password)
    }
}
