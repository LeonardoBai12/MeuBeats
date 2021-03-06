package io.lb.meubeats.headset_feature.domain.repository

import com.google.android.gms.tasks.Task
import io.lb.meubeats.headset_feature.domain.model.Headset

interface HeadsetRepository {
    fun insertHeadset(id: Int, headset: Headset): Task<Void>
    suspend fun getHeadsets(): List<Headset>
    fun logout()
    suspend fun getBoughtHeadsetsUseCase(): List<Headset>
}