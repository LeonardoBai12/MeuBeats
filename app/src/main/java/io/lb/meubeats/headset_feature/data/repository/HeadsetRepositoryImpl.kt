package io.lb.meubeats.headset_feature.data.repository

import androidx.lifecycle.LiveData
import com.google.android.gms.tasks.Task
import io.lb.meubeats.headset_feature.data.data_source.HeadsetDao
import io.lb.meubeats.headset_feature.data.data_source.HeadsetFirebaseDataSource
import io.lb.meubeats.headset_feature.data.data_source.HeadsetServiceInterface
import io.lb.meubeats.headset_feature.domain.model.Headset
import io.lb.meubeats.headset_feature.domain.repository.HeadsetRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber

class HeadsetRepositoryImpl(
    private val dataSource: HeadsetFirebaseDataSource,
    private val dao: HeadsetDao,
    private val serviceInterface: HeadsetServiceInterface
) : HeadsetRepository {
    override fun insertHeadseToFirebase(id: Int, headset: Headset): Task<Void> {
        return dataSource.insertHeadseToFirebase(id, headset)
    }

    override fun getHeadsetsFromDatabase(): LiveData<List<Headset>> {
        makeApiCall()
        return dao.getAllRecords()
    }

    private fun makeApiCall() {
        val call = serviceInterface.getHeadsets()
        call.enqueue(object : Callback<ArrayList<Headset>> {
            override fun onResponse(
                call: Call<ArrayList<Headset>>,
                response: Response<ArrayList<Headset>>
            ) {
                if (response.isSuccessful && response.body() != null) {
                    CoroutineScope(Dispatchers.IO).launch {
                        updateDatabase(response.body()!!)
                    }
                }
            }

            override fun onFailure(call: Call<ArrayList<Headset>>, t: Throwable) {
                Timber.e(call.toString())
            }
        })
    }

    private fun updateDatabase(response: ArrayList<Headset>) {
        dao.deleteAllRecords()
        response.forEach {
            dao.insertRecord(it)
        }
    }

    override fun logout() {
        dataSource.logout()
    }

    override fun getHeadsetsFromFirebase(onDataChanged: (ArrayList<Headset>) -> Unit) {
        dataSource.getHeadsetsFromFirebase(onDataChanged)
    }
}