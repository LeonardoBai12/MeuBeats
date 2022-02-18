package io.lb.meubeats.headset_feature.presentation.headset

sealed class HeadsetEvent {
    data class SelectedHeadset(val value: String): HeadsetEvent()
    object PressedAdd : HeadsetEvent()
}