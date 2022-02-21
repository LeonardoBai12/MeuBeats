package io.lb.meubeats.headset_feature.domain.use_case

import io.lb.meubeats.headset_feature.domain.model.Headset
import io.lb.meubeats.headset_feature.domain.model.InvalidHeadsetException
import io.lb.meubeats.headset_feature.domain.repository.HeadsetRepository

class GetHeadsetsFromFirebaseUseCase(
    private val repository: HeadsetRepository
) {
    @Throws(InvalidHeadsetException::class)
    operator fun invoke(onDataChanged: (ArrayList<Headset>) -> Unit) {
        repository.getHeadsetsFromFirebase(onDataChanged)
    }
}