package io.lb.meubeats.headset_feature.domain.repository

import androidx.lifecycle.LiveData
import com.google.android.gms.tasks.Task
import io.lb.meubeats.headset_feature.domain.model.Headset

interface HeadsetRepository {
    fun insertHeadset(id: Int, headset: Headset): Task<Void>
    suspend fun getHeadsets(): LiveData<List<Headset>>
    fun logout()
    suspend fun getBoughtHeadsetsUseCase(): List<Headset>
}