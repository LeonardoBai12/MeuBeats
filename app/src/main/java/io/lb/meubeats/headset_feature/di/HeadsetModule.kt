package io.lb.meubeats.headset_feature.di

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import dagger.Module
import dagger.Provides
import io.lb.meubeats.headset_feature.data.repository.HeadsetRepositoryImpl
import io.lb.meubeats.headset_feature.data.data_source.HeadsetDataSource
import io.lb.meubeats.headset_feature.domain.repository.HeadsetRepository
import io.lb.meubeats.headset_feature.domain.use_case.GetHeadsetsFromFirebaseUseCase
import io.lb.meubeats.headset_feature.domain.use_case.GetHeadsetsUseCase
import io.lb.meubeats.headset_feature.domain.use_case.HeadsetUseCases
import io.lb.meubeats.headset_feature.domain.use_case.InsertHeadsetToFirebaseUseCase
import io.lb.meubeats.headset_feature.domain.use_case.LogoutUseCase

@Module
class HeadsetModule {
    @Provides
    fun providesHeadsetDataSource(
        database: FirebaseDatabase,
        auth: FirebaseAuth,
    ): HeadsetDataSource {
        return HeadsetDataSource(database, auth)
    }

    @Provides
    fun providesHeadsetRepository(
        headsetDataSource: HeadsetDataSource
    ): HeadsetRepository {
        return HeadsetRepositoryImpl(headsetDataSource)
    }

    @Provides
    fun providesHeadsetUseCases(repository: HeadsetRepository): HeadsetUseCases {
        return HeadsetUseCases(
            getHeadsetsUseCase = GetHeadsetsUseCase(repository),
            insertHeadsetToFirebaseUseCase = InsertHeadsetToFirebaseUseCase(repository),
            getHeadsetsFromFirebaseUseCase = GetHeadsetsFromFirebaseUseCase(repository),
            logoutUseCase = LogoutUseCase(repository),
        )
    }
}