package io.lb.meubeats.headset_feature.domain.repository

import io.lb.meubeats.headset_feature.domain.model.Headset

interface HeadsetRepository {
    fun insertHeadseToFirebase(id: Int, headset: Headset, onCompleted: () -> Unit)
    fun getHeadsets(): ArrayList<Headset>
    fun getHeadsetsFromFirebase(onDataChanged: (ArrayList<Headset>) -> Unit)
}