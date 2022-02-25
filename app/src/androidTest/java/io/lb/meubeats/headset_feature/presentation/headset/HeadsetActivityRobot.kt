package io.lb.meubeats.headset_feature.presentation.headset

import io.lb.meubeats.*

class HeadsetActivityRobot: BaseTestRobot(HeadsetActivity::class.java) {
    fun headset(func: HeadsetActivityRobot.() -> Unit) = HeadsetActivityRobot()
        .apply {
            start()
            func()
        }
}