package io.lb.meubeats.headset_feature.data.repository

import androidx.lifecycle.LiveData
import com.google.android.gms.tasks.Task
import io.lb.meubeats.headset_feature.data.data_source.HeadsetDao
import io.lb.meubeats.headset_feature.data.data_source.HeadsetFirebaseDataSource
import io.lb.meubeats.headset_feature.data.data_source.HeadsetService
import io.lb.meubeats.headset_feature.domain.model.Headset
import io.lb.meubeats.headset_feature.domain.repository.HeadsetRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class HeadsetRepositoryImpl(
    private val dataSource: HeadsetFirebaseDataSource,
    private val service: HeadsetService,
    private val dao: HeadsetDao,
) : HeadsetRepository {
    override fun insertHeadset(id: Int, headset: Headset): Task<Void> {
        return dataSource.insertHeadset(id, headset)
    }

    override suspend fun getHeadsets(): LiveData<List<Headset>> {
        makeApiCall()
        return dao.getAllRecords()
    }

    private suspend fun makeApiCall() = withContext(Dispatchers.IO) {
        val call = runCatching {
            service.getHeadsets()
        }.getOrNull() ?: return@withContext

        updateDatabase(call)
    }

    private fun updateDatabase(response: List<Headset>) {
        dao.deleteAllRecords()
        response.forEach {
            dao.insertRecord(it)
        }
    }

    override fun logout() {
        dataSource.logout()
    }

    override suspend fun getBoughtHeadsetsUseCase(): List<Headset> {
        return dataSource.getBoughtHeadsetsUseCase()
    }
}