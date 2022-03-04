package io.lb.meubeats.headset_feature.domain.use_case

import androidx.lifecycle.LiveData
import io.lb.meubeats.headset_feature.domain.model.Headset
import io.lb.meubeats.headset_feature.domain.model.InvalidHeadsetException
import io.lb.meubeats.headset_feature.domain.repository.HeadsetRepository

class GetHeadsetsFromDatabaseUseCase(
    private val repository: HeadsetRepository
) {
    @Throws(InvalidHeadsetException::class)
    operator fun invoke(): LiveData<List<Headset>> {
        return repository.getHeadsetsFromDatabase()
    }
}