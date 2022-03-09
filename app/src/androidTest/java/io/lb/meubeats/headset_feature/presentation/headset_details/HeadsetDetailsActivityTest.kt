package io.lb.meubeats.headset_feature.presentation.headset_details

import io.lb.meubeats.R
import org.junit.Test

class HeadsetDetailsActivityTest {
    private val robot = HeadsetDetailsActivityRobot()

    @Test
    fun is_activity_in_view() {
        robot.headsetDetails {
            isViewDisplayed(R.id.headset_details)
        }
    }

    @Test
    fun is_button_buy_displayed_and_with_the_correct_text() {
        robot.headsetDetails {
            isViewDisplayed(R.id.bt_buy)
            isViewTextCorrect(R.id.bt_buy, R.string.buy)
        }
    }

    @Test
    fun is_connection_label_text_view_displayed_and_with_the_correct_text() {
        robot.headsetDetails {
            isViewDisplayed(R.id.lbl_headset_connection)
            isViewTextCorrect(R.id.lbl_headset_connection, R.string.connection)
        }
    }

    @Test
    fun is_connection_text_view_displayed() {
        robot.headsetDetails {
            isViewDisplayed(R.id.tv_headset_connection)
        }
    }

    @Test
    fun is_compatibility_label_text_view_displayed_and_with_the_correct_text() {
        robot.headsetDetails {
            isViewDisplayed(R.id.lbl_headset_compatibility)
            isViewTextCorrect(R.id.lbl_headset_compatibility, R.string.compatibility)
        }
    }

    @Test
    fun is_compatibility_text_view_displayed() {
        robot.headsetDetails {
            isViewDisplayed(R.id.tv_headset_compatibility)
        }
    }

    @Test
    fun is_power_supply_label_text_view_displayed_and_with_the_correct_text() {
        robot.headsetDetails {
            isViewDisplayed(R.id.lbl_headset_power_supply)
            isViewTextCorrect(R.id.lbl_headset_power_supply, R.string.power_supply)
        }
    }

    @Test
    fun is_power_supply_text_view_displayed() {
        robot.headsetDetails {
            isViewDisplayed(R.id.tv_headset_power_supply)
        }
    }

    @Test
    fun is_autonomy_label_text_view_displayed_and_with_the_correct_text() {
        robot.headsetDetails {
            isViewDisplayed(R.id.lbl_headset_autonomy)
            isViewTextCorrect(R.id.lbl_headset_autonomy, R.string.autonomy)
        }
    }

    @Test
    fun is_autonomy_text_view_displayed() {
        robot.headsetDetails {
            isViewDisplayed(R.id.tv_headset_autonomy)
        }
    }

    @Test
    fun is_height_label_text_view_displayed_and_with_the_correct_text() {
        robot.headsetDetails {
            isViewDisplayed(R.id.lbl_headset_height)
            isViewTextCorrect(R.id.lbl_headset_height, R.string.height)
        }
    }

    @Test
    fun is_height_text_view_displayed() {
        robot.headsetDetails {
            isViewDisplayed(R.id.tv_headset_height)
        }
    }

    @Test
    fun is_caption_label_text_view_displayed_and_with_the_correct_text() {
        robot.headsetDetails {
            isViewDisplayed(R.id.lbl_headset_caption)
            isViewTextCorrect(R.id.lbl_headset_caption, R.string.caption)
        }
    }

    @Test
    fun is_caption_text_view() {
        robot.headsetDetails {
            isViewDisplayed(R.id.tv_headset_sound_capture)
        }
    }
}