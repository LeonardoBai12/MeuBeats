package io.lb.meubeats.headset_feature.presentation.headset_details

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.android.gms.tasks.Task
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.ValueEventListener
import io.lb.meubeats.headset_feature.domain.model.Headset
import io.lb.meubeats.headset_feature.domain.repository.HeadsetRepository
import io.lb.meubeats.utils.ResourceCreator
import javax.inject.Inject

class HeadsetViewModel @Inject constructor(
    private val repository: HeadsetRepository
): ViewModel() {
    var selectedHeadset = MutableLiveData<Headset?>()
    var headsets = MutableLiveData<ArrayList<Headset>>()
    var selectedPosition: Int? = null

    fun loadHeadsetsFromApi(): MutableLiveData<ArrayList<Headset>> {
        headsets.value = ResourceCreator.exampleHeadsets()
        return headsets
    }

    fun insertHeadset(
        id: Int,
        headset: Headset,
        onCompleted: (Boolean, Exception?) -> Unit
    ): Task<Void> {
        return repository.insertHeadset(id, headset, onCompleted)
    }

    fun loadHeadsetsFromFirebase(): Task<DataSnapshot> {
        return repository.loadHeadsets()
    }

    fun loadHeadsetsFromFirebaseListener(
        onDataChanged: (ArrayList<Headset>) -> Unit
    ): ValueEventListener {
        return repository.loadHeadsetsListener(onDataChanged)
    }
}