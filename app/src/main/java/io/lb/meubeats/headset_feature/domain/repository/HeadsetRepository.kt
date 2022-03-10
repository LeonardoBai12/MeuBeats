package io.lb.meubeats.headset_feature.domain.repository

import androidx.lifecycle.LiveData
import com.google.android.gms.tasks.Task
import io.lb.meubeats.headset_feature.domain.model.Headset

interface HeadsetRepository {
    fun insertHeadseToFirebase(id: Int, headset: Headset): Task<Void>
    suspend fun getHeadsetsFromDatabase(): LiveData<List<Headset>>
    fun logout()
    fun getHeadsetsFromFirebase(onDataChanged: (ArrayList<Headset>) -> Unit)
}