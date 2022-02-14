package io.lb.meubeats.ui.headset

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.lb.meubeats.model.headset.Headset
import io.lb.meubeats.utils.ResourceCreator
import javax.inject.Inject

class HeadsetViewModel @Inject constructor(): ViewModel() {
    var selectedHeadset = MutableLiveData<Headset?>()
    var headsets = MutableLiveData<ArrayList<Headset>>()
    var selectedPosition: Int? = null

    fun loadHeadsets(): MutableLiveData<ArrayList<Headset>> {
        headsets.value = ResourceCreator.exampleHeadsets()
        return headsets
    }
}