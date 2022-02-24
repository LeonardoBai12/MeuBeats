package io.lb.meubeats

import androidx.test.espresso.Espresso.onView

import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import org.hamcrest.Matchers

fun isViewDisplayed(id: Int) {
    onView(withId(id)).check(matches(isDisplayed()))
}

fun isViewNotDisplayed(id: Int) {
    onView(withId(id)).check(matches(Matchers.not(isDisplayed())))
}

fun isTextInputLayoutHintCorrect(viewId: Int, textId: Int) {
    onView(withId(viewId)).check(
        matches(ViewMatchers.hasDescendant(ViewMatchers.withHint(textId)))
    )
}

fun isViewTextCorrect(viewId: Int, textId: Int) {
    onView(withId(viewId)).check(matches(ViewMatchers.withText(textId)))
}