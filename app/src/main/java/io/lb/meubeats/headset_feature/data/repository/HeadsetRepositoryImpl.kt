package io.lb.meubeats.headset_feature.data.repository

import androidx.lifecycle.LiveData
import com.google.android.gms.tasks.Task
import io.lb.meubeats.headset_feature.data.data_source.HeadsetDao
import io.lb.meubeats.headset_feature.data.data_source.HeadsetFirebaseDataSource
import io.lb.meubeats.headset_feature.domain.model.Headset
import io.lb.meubeats.headset_feature.domain.repository.HeadsetRepository
import io.lb.meubeats.utils.ResourceCreator
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HeadsetRepositoryImpl(
    private val dataSource: HeadsetFirebaseDataSource,
    private val dao: HeadsetDao
) : HeadsetRepository {
    override fun insertHeadseToFirebase(id: Int, headset: Headset): Task<Void> {
        return dataSource.insertHeadseToFirebase(id, headset)
    }

    override fun getHeadsetsFromDatabase(): LiveData<List<Headset>> {
        makeApiCall()
        return dao.getAllRecords()
    }

    private fun getHeadsetsFromApi(): ArrayList<Headset> {
        return ResourceCreator.exampleHeadsets()
    }

    private fun makeApiCall() {
        val apiHeadsets = getHeadsetsFromApi()

        CoroutineScope(Dispatchers.IO).launch {
            dao.deleteAllRecords()

            apiHeadsets.forEach {
                dao.insertRecord(it)
            }
        }
    }

    override fun logout() {
        dataSource.logout()
    }

    override fun getHeadsetsFromFirebase(onDataChanged: (ArrayList<Headset>) -> Unit) {
        dataSource.getHeadsetsFromFirebase(onDataChanged)
    }
}