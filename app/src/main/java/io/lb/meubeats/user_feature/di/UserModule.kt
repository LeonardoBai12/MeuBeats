package io.lb.meubeats.user_feature.di

import com.google.firebase.auth.FirebaseAuth
import dagger.Module
import dagger.Provides
import io.lb.meubeats.user_feature.data.data_source.UserDataSource
import io.lb.meubeats.user_feature.data.repository.UserRepositoryImpl
import io.lb.meubeats.user_feature.domain.repository.UserRepository
import io.lb.meubeats.user_feature.domain.use_case.CreateUserUseCase
import io.lb.meubeats.user_feature.domain.use_case.GetUserUseCase
import io.lb.meubeats.user_feature.domain.use_case.UserUseCases

@Module
class UserModule {
    @Provides
    fun providesUserDataSource(auth: FirebaseAuth): UserDataSource {
        return UserDataSource(auth)
    }

    @Provides
    fun providesUserRepository(userDataSource: UserDataSource): UserRepository {
        return UserRepositoryImpl(userDataSource)
    }

    @Provides
    fun providesUserUseCases(repository: UserRepository): UserUseCases {
        return UserUseCases(
            getUserUseCase = GetUserUseCase(repository),
            createUserUseCase = CreateUserUseCase(repository),
        )
    }
}
