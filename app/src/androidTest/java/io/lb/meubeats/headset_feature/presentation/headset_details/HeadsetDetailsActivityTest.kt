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
    fun isActivityInView() {
        ActivityScenario.launch(HeadsetDetailsActivity::class.java)
        onView(withId(R.id.headset_details)).check(matches(isDisplayed()))
    }

    @Test
    fun testConnectionLabelTextView() {
        ActivityScenario.launch(HeadsetDetailsActivity::class.java)

        onView(withId(R.id.lbl_headset_connection)).check(matches(isDisplayed()))
        onView(withId(R.id.lbl_headset_connection)).check(
            matches(withEffectiveVisibility(Visibility.forViewVisibility(View.VISIBLE)))
        )
        onView(withId(R.id.lbl_headset_connection)).check(
            matches(withText(R.string.connection))
        )
    }

    @Test
    fun testConnectionDataTextView() {
        ActivityScenario.launch(HeadsetDetailsActivity::class.java)

        onView(withId(R.id.tv_headset_connection)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_headset_connection)).check(
            matches(withEffectiveVisibility(Visibility.forViewVisibility(View.VISIBLE)))
        )
    }

    @Test
    fun testCompatibilityLabelTextView() {
        ActivityScenario.launch(HeadsetDetailsActivity::class.java)

        onView(withId(R.id.lbl_headset_compatibility)).check(matches(isDisplayed()))
        onView(withId(R.id.lbl_headset_compatibility)).check(
            matches(withEffectiveVisibility(Visibility.forViewVisibility(View.VISIBLE)))
        )
        onView(withId(R.id.lbl_headset_compatibility)).check(
            matches(withText(R.string.compatibility))
        )
    }

    @Test
    fun testCompatibilityDataTextView() {
        ActivityScenario.launch(HeadsetDetailsActivity::class.java)

        onView(withId(R.id.tv_headset_compatibility)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_headset_compatibility)).check(
            matches(withEffectiveVisibility(Visibility.forViewVisibility(View.VISIBLE)))
        )
    }

    @Test
    fun testPowerSupplyLabelTextView() {
        ActivityScenario.launch(HeadsetDetailsActivity::class.java)

        onView(withId(R.id.lbl_headset_power_supply)).check(matches(isDisplayed()))
        onView(withId(R.id.lbl_headset_power_supply)).check(
            matches(withEffectiveVisibility(Visibility.forViewVisibility(View.VISIBLE)))
        )
        onView(withId(R.id.lbl_headset_power_supply)).check(
            matches(withText(R.string.power_supply))
        )
    }

    @Test
    fun testPowerSupplyDataTextView() {
        ActivityScenario.launch(HeadsetDetailsActivity::class.java)

        onView(withId(R.id.tv_headset_power_supply)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_headset_power_supply)).check(
            matches(withEffectiveVisibility(Visibility.forViewVisibility(View.VISIBLE)))
        )
    }

    @Test
    fun testAutonomyLabelTextView() {
        ActivityScenario.launch(HeadsetDetailsActivity::class.java)

        onView(withId(R.id.lbl_headset_autonomy)).check(matches(isDisplayed()))
        onView(withId(R.id.lbl_headset_autonomy)).check(
            matches(withEffectiveVisibility(Visibility.forViewVisibility(View.VISIBLE)))
        )
        onView(withId(R.id.lbl_headset_autonomy)).check(
            matches(withText(R.string.autonomy))
        )
    }

    @Test
    fun testAutonomyDataTextView() {
        ActivityScenario.launch(HeadsetDetailsActivity::class.java)

        onView(withId(R.id.tv_headset_autonomy)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_headset_autonomy)).check(
            matches(withEffectiveVisibility(Visibility.forViewVisibility(View.VISIBLE)))
        )
    }

    @Test
    fun testHeightLabelTextView() {
        ActivityScenario.launch(HeadsetDetailsActivity::class.java)

        onView(withId(R.id.lbl_headset_height)).check(matches(isDisplayed()))
        onView(withId(R.id.lbl_headset_height)).check(
            matches(withEffectiveVisibility(Visibility.forViewVisibility(View.VISIBLE)))
        )
        onView(withId(R.id.lbl_headset_height)).check(
            matches(withText(R.string.height))
        )
    }

    @Test
    fun testHeightDataTextView() {
        ActivityScenario.launch(HeadsetDetailsActivity::class.java)

        onView(withId(R.id.tv_headset_height)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_headset_height)).check(
            matches(withEffectiveVisibility(Visibility.forViewVisibility(View.VISIBLE)))
        )
    }

    @Test
    fun testCaptionLabelTextView() {
        ActivityScenario.launch(HeadsetDetailsActivity::class.java)

        onView(withId(R.id.lbl_headset_caption)).check(matches(isDisplayed()))
        onView(withId(R.id.lbl_headset_caption)).check(
            matches(withEffectiveVisibility(Visibility.forViewVisibility(View.VISIBLE)))
        )
        onView(withId(R.id.lbl_headset_caption)).check(
            matches(withText(R.string.caption))
        )
    }

    @Test
    fun testCaptionDataTextView() {
        ActivityScenario.launch(HeadsetDetailsActivity::class.java)

        onView(withId(R.id.tv_headset_sound_capture)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_headset_sound_capture)).check(
            matches(withEffectiveVisibility(Visibility.forViewVisibility(View.VISIBLE)))
        )
    }
}