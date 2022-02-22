package io.lb.meubeats.headset_feature.domain.use_case

import io.lb.meubeats.headset_feature.domain.model.Headset
import io.lb.meubeats.headset_feature.domain.model.InvalidHeadsetException
import io.lb.meubeats.headset_feature.domain.repository.HeadsetRepository
import io.lb.meubeats.user_feature.domain.util.InvalidUserException

class InsertHeadsetToFirebaseUseCase(
    private val repository: HeadsetRepository
) {
    @Throws(InvalidHeadsetException::class)
    operator fun invoke(id: Int?, headset: Headset?, onCompleted: () -> Unit) {
        if (id == null || headset == null) {
            throw InvalidHeadsetException("Não foi possível adicionar o produto")
        }
        repository.insertHeadseToFirebase(id, headset, onCompleted)
    }
}