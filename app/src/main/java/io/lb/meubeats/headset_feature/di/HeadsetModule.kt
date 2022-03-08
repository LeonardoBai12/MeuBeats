package io.lb.meubeats.headset_feature.di

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import dagger.Module
import dagger.Provides
import io.lb.meubeats.headset_feature.data.data_source.HeadsetDao
import io.lb.meubeats.db.AppDatabase
import io.lb.meubeats.headset_feature.data.repository.HeadsetRepositoryImpl
import io.lb.meubeats.headset_feature.data.data_source.HeadsetFirebaseDataSource
import io.lb.meubeats.headset_feature.data.data_source.HeadsetServiceInterface
import io.lb.meubeats.headset_feature.domain.repository.HeadsetRepository
import io.lb.meubeats.headset_feature.domain.use_case.GetHeadsetsFromFirebaseUseCase
import io.lb.meubeats.headset_feature.domain.use_case.GetHeadsetsFromDatabaseUseCase
import io.lb.meubeats.headset_feature.domain.use_case.HeadsetUseCases
import io.lb.meubeats.headset_feature.domain.use_case.InsertHeadsetToFirebaseUseCase
import io.lb.meubeats.headset_feature.domain.use_case.LogoutUseCase
import retrofit2.Retrofit

@Module
class HeadsetModule {
    @Provides
    fun getHeadsetServiceInterface(retrofit: Retrofit): HeadsetServiceInterface {
        return retrofit.create(HeadsetServiceInterface::class.java)
    }

    @Provides
    fun getHeadsetDao(appDataBase: AppDatabase): HeadsetDao {
        return appDataBase.headsetDao
    }

    @Provides
    fun providesHeadsetDataSource(
        database: FirebaseDatabase,
        auth: FirebaseAuth,
    ): HeadsetFirebaseDataSource {
        return HeadsetFirebaseDataSource(database, auth)
    }

    @Provides
    fun providesHeadsetRepository(
        dataSource: HeadsetFirebaseDataSource,
        dao: HeadsetDao,
        serviceInterface: HeadsetServiceInterface
    ): HeadsetRepository {
        return HeadsetRepositoryImpl(dataSource, dao, serviceInterface)
    }

    @Provides
    fun providesHeadsetUseCases(repository: HeadsetRepository): HeadsetUseCases {
        return HeadsetUseCases(
            getHeadsetsUseCase = GetHeadsetsFromDatabaseUseCase(repository),
            insertHeadsetToFirebaseUseCase = InsertHeadsetToFirebaseUseCase(repository),
            getHeadsetsFromFirebaseUseCase = GetHeadsetsFromFirebaseUseCase(repository),
            logoutUseCase = LogoutUseCase(repository),
        )
    }
}