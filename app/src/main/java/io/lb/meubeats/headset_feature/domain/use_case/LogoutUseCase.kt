package io.lb.meubeats.headset_feature.domain.use_case

import io.lb.meubeats.headset_feature.domain.repository.HeadsetRepository

class LogoutUseCase(
    private val repository: HeadsetRepository
) {
    operator fun invoke() {
        repository.logout()
    }
}