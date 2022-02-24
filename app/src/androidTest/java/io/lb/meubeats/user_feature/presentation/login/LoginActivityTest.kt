package io.lb.meubeats.user_feature.presentation.login

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import io.lb.meubeats.R
import org.junit.Test

class LoginActivityTest {
    @Test
    fun is_activity_in_view() {
        start()
        onView(withId(R.id.login)).check(matches(isDisplayed()))
    }

    @Test
    fun is_title_text_view_displayed_and_with_the_correct_text() {
        start()

        onView(withId(R.id.tv_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_title)).check(
            matches(withText(R.string.app_name))
        )
    }

    @Test
    fun is_speciality_text_view_displayed_and_with_the_correct_text() {
        start()

        onView(withId(R.id.tv_speciality)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_speciality)).check(
            matches(withText(R.string.app_speciality))
        )
    }

    @Test
    fun is_user_text_input_layout_displayed_and_with_the_correct_text() {
        start()

        onView(withId(R.id.til_login_email)).check(matches(isDisplayed()))
        onView(withId(R.id.til_login_email)).check(
            matches(hasDescendant(withHint(R.string.user)))
        )
    }

    @Test
    fun is_password_text_input_layout_displayed_and_with_the_correct_text() {
        start()

        onView(withId(R.id.til_login_password)).check(matches(isDisplayed()))
        onView(withId(R.id.til_login_password)).check(
            matches(hasDescendant(withHint(R.string.password)))
        )
    }

    @Test
    fun is_login_button_displayed_and_with_the_correct_text() {
        start()

        onView(withId(R.id.bt_login)).check(matches(isDisplayed()))
        onView(withId(R.id.bt_login)).check(
            matches(withText(R.string.login))
        )
    }

    private fun start() {
        ActivityScenario.launch(LoginActivity::class.java)
    }
}
