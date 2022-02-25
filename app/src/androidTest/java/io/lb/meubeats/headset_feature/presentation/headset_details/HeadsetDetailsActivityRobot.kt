package io.lb.meubeats.headset_feature.presentation.headset_details

import io.lb.meubeats.BaseTestRobot

class HeadsetDetailsActivityRobot: BaseTestRobot(HeadsetDetailsActivity::class.java) {
    fun headsetDetails(func: HeadsetDetailsActivityRobot.() -> Unit) = HeadsetDetailsActivityRobot()
        .apply {
            start()
            func()
        }
}