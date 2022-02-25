package io.lb.meubeats.user_feature.presentation.login

import io.lb.meubeats.R
import org.junit.Test

class LoginActivityTest {
    private val robot = LoginActivityRobot()

    @Test
    fun is_activity_in_view() {
        robot.login {
            isViewDisplayed(R.id.login)
        }
    }

    @Test
    fun is_title_text_view_displayed_and_with_the_correct_text() {
        robot.login {
            isViewDisplayed(R.id.tv_title)
            isViewTextCorrect(R.id.tv_title, R.string.app_name)
        }
    }

    @Test
    fun is_speciality_text_view_displayed_and_with_the_correct_text() {
        robot.login {
            isViewDisplayed(R.id.tv_speciality)
            isViewTextCorrect(R.id.tv_speciality, R.string.app_speciality)
        }
    }

    @Test
    fun is_user_text_input_layout_displayed_and_with_the_correct_text() {
        robot.login {
            isViewDisplayed(R.id.til_login_email)
            isTextInputLayoutHintCorrect(R.id.til_login_email, R.string.user)
        }
    }


    @Test
    fun is_password_text_input_layout_displayed_and_with_the_correct_text() {
        robot.login {
            isViewDisplayed(R.id.til_login_password)
            isTextInputLayoutHintCorrect(R.id.til_login_password, R.string.password)
        }
    }


    @Test
    fun is_login_button_displayed_and_with_the_correct_text() {
        robot.login {
            isViewDisplayed(R.id.bt_login)
            isViewTextCorrect(R.id.bt_login, R.string.login)
        }
    }

}