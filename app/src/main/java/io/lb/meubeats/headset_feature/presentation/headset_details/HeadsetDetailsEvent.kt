package io.lb.meubeats.headset_feature.presentation.headset_details

import io.lb.meubeats.headset_feature.domain.model.Headset

sealed class HeadsetDetailsEvent {
    data class PressedAdd(val id: Int, val headset: Headset?) : HeadsetDetailsEvent()
}