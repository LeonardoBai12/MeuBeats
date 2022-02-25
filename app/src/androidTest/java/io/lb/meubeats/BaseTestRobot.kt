package io.lb.meubeats

import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions

import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import org.hamcrest.CoreMatchers.allOf
import org.hamcrest.CoreMatchers.anything
import org.hamcrest.Matchers

open class BaseTestRobot {
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
}