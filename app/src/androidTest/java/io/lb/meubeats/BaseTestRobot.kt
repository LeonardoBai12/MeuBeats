package io.lb.meubeats

import android.app.Activity
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions

import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import org.hamcrest.CoreMatchers.*
import org.hamcrest.Matchers

open class BaseTestRobot(private val activity: Class<out Activity>) {
    fun isViewDisplayed(resId: Int) {
        viewInteraction(resId).check(matches(isDisplayed()))
    }

    fun isViewNotDisplayed(resId: Int) {
        viewInteraction(resId).check(matches(Matchers.not(isDisplayed())))
    }

    fun isTextInputLayoutHintCorrect(resId: Int, textId: Int) {
        viewInteraction(resId).check(
            matches(hasDescendant(withHint(textId)))
        )
    }

    fun isViewTextCorrect(resId: Int, textId: Int) {
        viewInteraction(resId).check(matches(withText(textId)))
    }

    fun fillEditText(resId: Int, text: String): ViewInteraction =
        viewWithParent(resId).perform(
            ViewActions.replaceText(text),
            ViewActions.closeSoftKeyboard()
        )

    fun clickButton(resId: Int): ViewInteraction =
        viewInteraction(resId).perform(ViewActions.click())

    fun viewWithParent(resId: Int): ViewInteraction =
        onView(allOf(supportsInputMethods(), isDescendantOfA(withId(resId))))

    fun viewInteraction(resId: Int): ViewInteraction = onView(withId(resId))
    fun viewInteraction(text: String): ViewInteraction = onView(withText(text))

    fun clickListItem(listRes: Int, position: Int) {
        onData(anything())
            .inAdapterView(allOf(withId(listRes)))
            .atPosition(position).perform(ViewActions.click())
    }

    fun start() {
        ActivityScenario.launch(activity)
    }
}