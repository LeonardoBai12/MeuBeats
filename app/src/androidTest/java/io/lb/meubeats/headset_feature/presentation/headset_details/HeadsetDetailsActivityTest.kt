package io.lb.meubeats.headset_feature.presentation.headset_details

import android.view.View
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import io.lb.meubeats.R
import org.junit.Test

class HeadsetDetailsActivityTest {
    @Test
    fun is_activity_in_view() {
        start()
        onView(withId(R.id.headset_details)).check(matches(isDisplayed()))
    }

    @Test
    fun is_button_buy_displayed_and_with_the_correct_text() {
        start()

        onView(withId(R.id.bt_buy)).check(matches(isDisplayed()))
        onView(withId(R.id.bt_buy)).check(matches(withText(R.string.buy)))
    }

    @Test
    fun is_connection_label_text_view_displayed_and_with_the_correct_text() {
        start()

        onView(withId(R.id.lbl_headset_connection)).check(matches(isDisplayed()))
        onView(withId(R.id.lbl_headset_connection)).check(
            matches(withText(R.string.connection))
        )
    }

    @Test
    fun is_connection_text_view_displayed() {
        start()
        onView(withId(R.id.tv_headset_connection)).check(matches(isDisplayed()))
    }

    @Test
    fun is_compatibility_label_text_view_displayed_and_with_the_correct_text() {
        start()

        onView(withId(R.id.lbl_headset_compatibility)).check(matches(isDisplayed()))
        onView(withId(R.id.lbl_headset_compatibility)).check(
            matches(withText(R.string.compatibility))
        )
    }

    @Test
    fun is_compatibility_text_view_displayed() {
        start()
        onView(withId(R.id.tv_headset_compatibility)).check(matches(isDisplayed()))
    }

    @Test
    fun is_power_supply_label_text_view_displayed_and_with_the_correct_text() {
        start()

        onView(withId(R.id.lbl_headset_power_supply)).check(matches(isDisplayed()))
        onView(withId(R.id.lbl_headset_power_supply)).check(
            matches(withText(R.string.power_supply))
        )
    }

    @Test
    fun is_power_supply_text_view_displayed() {
        start()
        onView(withId(R.id.tv_headset_power_supply)).check(matches(isDisplayed()))
    }

    @Test
    fun is_autonomy_label_text_view_displayed_and_with_the_correct_text() {
        start()

        onView(withId(R.id.lbl_headset_autonomy)).check(matches(isDisplayed()))
        onView(withId(R.id.lbl_headset_autonomy)).check(
            matches(withText(R.string.autonomy))
        )
    }

    @Test
    fun is_autonomy_text_view_displayed() {
        start()
        onView(withId(R.id.tv_headset_autonomy)).check(matches(isDisplayed()))
    }

    @Test
    fun is_height_label_text_view_displayed_and_with_the_correct_text() {
        start()

        onView(withId(R.id.lbl_headset_height)).check(matches(isDisplayed()))
        onView(withId(R.id.lbl_headset_height)).check(
            matches(withText(R.string.height))
        )
    }

    @Test
    fun is_height_text_view_displayed() {
        start()
        onView(withId(R.id.tv_headset_height)).check(matches(isDisplayed()))
    }

    @Test
    fun is_caption_label_text_view_displayed_and_with_the_correct_text() {
        start()

        onView(withId(R.id.lbl_headset_caption)).check(matches(isDisplayed()))
        onView(withId(R.id.lbl_headset_caption)).check(
            matches(withText(R.string.caption))
        )
    }

    @Test
    fun is_caption_text_view() {
        start()
        onView(withId(R.id.tv_headset_sound_capture)).check(matches(isDisplayed()))
    }

    private fun start() {
        ActivityScenario.launch(HeadsetDetailsActivity::class.java)
    }
}