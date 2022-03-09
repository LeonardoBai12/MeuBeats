package io.lb.meubeats.headset_feature.presentation.headset

import io.lb.meubeats.R
import org.junit.Test

class HeadsetActivityTest {
    private val robot = HeadsetActivityRobot()

    @Test
    fun is_activity_in_view() {
        robot.headset {
            isViewDisplayed(R.id.main)
        }
    }


    @Test
    fun is_headsets_recycler_view_not_displayed() {
        robot.headset {
            isViewNotDisplayed(R.id.rv_headsets)
        }
    }

    @Test
    fun is_button_add_displayed_and_with_the_correct_text() {
        robot.headset {
            isViewDisplayed(R.id.bt_add_headset)
            isViewTextCorrect(R.id.bt_add_headset, R.string.select_a_product)
        }
    }
}