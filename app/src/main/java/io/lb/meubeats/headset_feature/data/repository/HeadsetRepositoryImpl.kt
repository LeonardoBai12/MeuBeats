package io.lb.meubeats.headset_feature.data.repository

import io.lb.meubeats.headset_feature.data.data_source.HeadsetDataSource
import io.lb.meubeats.headset_feature.domain.model.Headset
import io.lb.meubeats.headset_feature.domain.repository.HeadsetRepository

class HeadsetRepositoryImpl(
    private val dataSource: HeadsetDataSource
) : HeadsetRepository {
    override fun insertHeadseToFirebase(
        id: Int,
        headset: Headset,
        onCompleted: () -> Unit
    ) {
        dataSource.insertHeadseToFirebase(id, headset, onCompleted)
    }

    override fun getHeadsets(): ArrayList<Headset> {
        return dataSource.getHeadsets()
    }

    override fun getHeadsetsFromFirebase(onDataChanged: (ArrayList<Headset>) -> Unit) {
        dataSource.getHeadsetsFromFirebase(onDataChanged)
    }

}