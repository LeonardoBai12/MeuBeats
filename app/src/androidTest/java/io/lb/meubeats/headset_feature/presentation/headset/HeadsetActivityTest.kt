package io.lb.meubeats.headset_feature.presentation.headset

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import io.lb.meubeats.R
import org.hamcrest.Matchers.not
import org.junit.Test

class HeadsetActivityTest {
    @Test
    fun is_activity_in_view() {
        start()
        onView(withId(R.id.main)).check(matches(isDisplayed()))
    }

    @Test
    fun testHeadsetsRecyclerView() {
        start()
        onView(withId(R.id.rv_headsets)).check(matches(not(isDisplayed())))
    }

    @Test
    fun testButtonAdd() {
        start()

        onView(withId(R.id.bt_add_headset)).check(matches(isDisplayed()))
        onView(withId(R.id.bt_add_headset)).check(matches(withText(R.string.select_a_product)))
    }

    private fun start() {
        ActivityScenario.launch(HeadsetActivity::class.java)
    }

}