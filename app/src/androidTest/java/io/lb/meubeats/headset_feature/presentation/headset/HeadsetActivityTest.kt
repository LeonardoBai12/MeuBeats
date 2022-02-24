package io.lb.meubeats.headset_feature.presentation.headset

import androidx.test.core.app.ActivityScenario
import io.lb.meubeats.*
import org.junit.Test

class HeadsetActivityTest {
    @Test
    fun is_activity_in_view() {
        start()
        isViewDisplayed(R.id.main)
    }

    @Test
    fun is_headsets_recycler_view_not_displayed() {
        start()
        isViewNotDisplayed(R.id.rv_headsets)
    }

    @Test
    fun is_button_add_displayed_and_with_the_correct_text() {
        start()

        isViewDisplayed(R.id.bt_add_headset)
        isViewTextCorrect(R.id.bt_add_headset, R.string.select_a_product)
    }

    private fun start() {
        ActivityScenario.launch(HeadsetActivity::class.java)
    }
}