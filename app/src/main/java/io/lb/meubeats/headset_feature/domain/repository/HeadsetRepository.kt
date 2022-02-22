package io.lb.meubeats.headset_feature.domain.repository

import com.google.android.gms.tasks.Task
import io.lb.meubeats.headset_feature.domain.model.Headset

interface HeadsetRepository {
    fun insertHeadseToFirebase(id: Int, headset: Headset): Task<Void>
    fun getHeadsets(): ArrayList<Headset>
    fun getHeadsetsFromFirebase(onDataChanged: (ArrayList<Headset>) -> Unit)
}