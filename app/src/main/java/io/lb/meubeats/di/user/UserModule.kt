package io.lb.meubeats.di.user

import com.google.firebase.auth.FirebaseAuth
import dagger.Module
import dagger.Provides
import io.lb.meubeats.network.user.UserRepository

@Module
class UserModule {
    @Provides
    fun providesUserRepository(auth: FirebaseAuth): UserRepository {
        return UserRepository(auth)
    }
}
