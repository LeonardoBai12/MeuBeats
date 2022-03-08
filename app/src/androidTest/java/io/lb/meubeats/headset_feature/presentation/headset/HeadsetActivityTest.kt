package io.lb.meubeats.headset_feature.presentation.headset

import android.os.SystemClock
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.ext.junit.rules.ActivityScenarioRule
import io.lb.meubeats.R
import io.lb.meubeats.ToastMatcher
import org.junit.Rule
import org.junit.Test

class HeadsetActivityTest {
    private val robot = HeadsetActivityRobot()

    @get:Rule
    var activityRule = ActivityScenarioRule(HeadsetActivity::class.java)

    @Test
    fun is_activity_in_view() {
        robot.headset {
            isViewDisplayed(R.id.main)
        }
    }

    @Test
    fun is_login_without_email_toast_with_correct_text() {
        robot.headset {
            selectHeadset()
            clickAddButton()
            isToastTextCorrect("Produto adicionado com sucesso")
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

    private fun isToastTextCorrect(text: String) {
        robot.headset {
            activityRule.scenario.onActivity {
                viewInteraction(text)
                    .inRoot(ToastMatcher()).check(
                        matches(isDisplayed())
                    )
            }
        }
    }
}