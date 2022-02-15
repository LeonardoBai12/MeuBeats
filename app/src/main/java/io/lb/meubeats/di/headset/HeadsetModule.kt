package io.lb.meubeats.di.headset

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import dagger.Module
import dagger.Provides
import io.lb.meubeats.network.headset.HeadsetRepository

@Module
class HeadsetModule {
    @Provides
    fun providesHeadsetsRepository(
        database: FirebaseDatabase,
        auth: FirebaseAuth
    ): HeadsetRepository {
        return HeadsetRepository(database, auth)
    }

}