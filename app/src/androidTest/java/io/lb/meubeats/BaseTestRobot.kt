package io.lb.meubeats

import android.app.Activity
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions

import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.RootMatchers.withDecorView
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.hamcrest.CoreMatchers.*
import org.hamcrest.Matchers
import org.junit.Rule

open class BaseTestRobot(private val activity: Class<out Activity>) {

    @Rule
    var activityRule = ActivityScenarioRule(activity)

    fun isViewDisplayed(resId: Int) {
        viewInteraction(resId).check(matches(isDisplayed()))
    }

    fun isViewNotDisplayed(resId: Int) {
        viewInteraction(resId).check(matches(Matchers.not(isDisplayed())))
    }

    fun isTextInputLayoutHintCorrect(resId: Int, textId: Int) {
        viewInteraction(resId).check(
            matches(ViewMatchers.hasDescendant(ViewMatchers.withHint(textId)))
        )
    }

    fun isViewTextCorrect(resId: Int, textId: Int) {
        viewInteraction(resId).check(matches(ViewMatchers.withText(textId)))
    }

    fun fillEditText(resId: Int, text: String): ViewInteraction =
        viewInteraction(resId).perform(
            ViewActions.replaceText(text),
            ViewActions.closeSoftKeyboard()
        )

    fun clickButton(resId: Int): ViewInteraction =
        viewInteraction(resId).perform(ViewActions.click())

    fun viewInteraction(resId: Int): ViewInteraction = onView(withId(resId))

    fun clickListItem(listRes: Int, position: Int) {
        onData(anything())
            .inAdapterView(allOf(withId(listRes)))
            .atPosition(position).perform(ViewActions.click())
    }

    fun isToastTextCorrect(textId: Int) {
        activityRule.scenario.onActivity {
            viewInteraction(textId)
                .inRoot(withDecorView(not(it.window.decorView)))
                .check(matches(isDisplayed()))
        }
    }

    fun start() {
        ActivityScenario.launch(activity)
    }
}