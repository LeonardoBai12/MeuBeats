package io.lb.meubeats.di.headset

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import dagger.Module
import dagger.Provides
import io.lb.meubeats.headset_feature.data.repository.HeadsetRepositoryImpl

@Module
class HeadsetModule {
    @Provides
    fun providesHeadsetsRepository(
        database: FirebaseDatabase,
        auth: FirebaseAuth
    ): HeadsetRepositoryImpl {
        return HeadsetRepositoryImpl(database, auth)
    }

}