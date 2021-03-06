package io.lb.meubeats.headset_feature.domain.use_case

import io.lb.meubeats.headset_feature.domain.model.Headset
import io.lb.meubeats.headset_feature.domain.model.InvalidHeadsetException
import io.lb.meubeats.headset_feature.domain.repository.HeadsetRepository

class GetHeadsetsUseCase(
    private val repository: HeadsetRepository
) {
    @Throws(InvalidHeadsetException::class)
    suspend operator fun invoke(): List<Headset> {
        return repository.getHeadsets()
    }
}