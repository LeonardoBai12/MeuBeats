package io.lb.meubeats.headset_feature.data.repository

import com.google.android.gms.tasks.Task
import io.lb.meubeats.headset_feature.data.data_source.HeadsetDao
import io.lb.meubeats.headset_feature.data.data_source.HeadsetFirebaseDataSource
import io.lb.meubeats.headset_feature.domain.model.Headset
import io.lb.meubeats.headset_feature.domain.repository.HeadsetRepository

class HeadsetRepositoryImpl(
    private val dataSource: HeadsetFirebaseDataSource,
    private val dao: HeadsetDao
) : HeadsetRepository {
    override fun insertHeadseToFirebase(id: Int, headset: Headset): Task<Void> {
        return dataSource.insertHeadseToFirebase(id, headset)
    }

    override fun getHeadsets(): ArrayList<Headset> {
        return dataSource.getHeadsets()
    }

    override fun logout() {
        dataSource.logout()
    }

    override fun getHeadsetsFromFirebase(onDataChanged: (ArrayList<Headset>) -> Unit) {
        dataSource.getHeadsetsFromFirebase(onDataChanged)
    }
}