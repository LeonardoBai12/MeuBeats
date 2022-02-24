package io.lb.meubeats.headset_feature.presentation.headset

import io.lb.meubeats.headset_feature.domain.model.Headset

sealed class HeadsetEvent {
    data class OnHeadsetSelected(val id: Int, val headset: Headset): HeadsetEvent()
    data class PressedAdd(val id: Int) : HeadsetEvent()
    object PressedLogout : HeadsetEvent()
    object OnHeadsetDetailsClicked: HeadsetEvent()
}