package io.lb.meubeats.user_feature.presentation.login

import io.lb.meubeats.BaseTestRobot
import io.lb.meubeats.R

class LoginActivityRobot: BaseTestRobot(LoginActivity::class.java) {
    fun login(func: LoginActivityRobot.() -> Unit) = LoginActivityRobot()
        .apply {
            start()
            func()
        }

    fun setEmail(email: String = "") {
        fillEditText(R.id.til_login_email, email)
    }

    fun setPassword(password: String = "") {
        fillEditText(R.id.til_login_password, password)
    }

    fun clickLoginButton() {
        clickButton(R.id.bt_login)
    }
}
