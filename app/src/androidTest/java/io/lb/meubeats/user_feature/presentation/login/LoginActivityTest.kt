package io.lb.meubeats.user_feature.presentation.login

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import io.lb.meubeats.R
import org.junit.Test

class LoginActivityTest {
    @Test
    fun isActivityInView() {
        ActivityScenario.launch(LoginActivity::class.java)
        onView(withId(R.id.login)).check(matches(isDisplayed()))
    }

    @Test
    fun testTitleTextView() {
        ActivityScenario.launch(LoginActivity::class.java)

        onView(withId(R.id.tv_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_title)).check(
            matches(withText(R.string.app_name))
        )
    }

    @Test
    fun testSpecialityTextView() {
        ActivityScenario.launch(LoginActivity::class.java)

        onView(withId(R.id.tv_speciality)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_speciality)).check(
            matches(withText(R.string.app_speciality))
        )
    }

    @Test
    fun testEmailTextInputLayout() {
        ActivityScenario.launch(LoginActivity::class.java)

        onView(withId(R.id.til_login_email)).check(matches(isDisplayed()))
        onView(withId(R.id.til_login_email)).check(
            matches(hasDescendant(withHint(R.string.user)))
        )
    }

    @Test
    fun testPasswordTextInputLayout() {
        ActivityScenario.launch(LoginActivity::class.java)

        onView(withId(R.id.til_login_password)).check(matches(isDisplayed()))
        onView(withId(R.id.til_login_password)).check(
            matches(hasDescendant(withHint(R.string.password)))
        )
    }

    @Test
    fun testLoginButton() {
        ActivityScenario.launch(LoginActivity::class.java)

        onView(withId(R.id.bt_login)).check(matches(isDisplayed()))
        onView(withId(R.id.bt_login)).check(
            matches(withText(R.string.login))
        )
    }
}
