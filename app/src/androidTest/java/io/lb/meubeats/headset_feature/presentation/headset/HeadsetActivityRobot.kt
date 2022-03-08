package io.lb.meubeats.headset_feature.presentation.headset

import io.lb.meubeats.*

class HeadsetActivityRobot: BaseTestRobot(HeadsetActivity::class.java) {
    fun headset(func: HeadsetActivityRobot.() -> Unit) = HeadsetActivityRobot()
        .apply {
            start()
            func()
        }

    fun selectHeadset() {
        clickListItem(R.id.rv_headsets, 0)
    }

    fun clickAddButton() {
        clickButton(R.id.bt_add_headset)
    }
}