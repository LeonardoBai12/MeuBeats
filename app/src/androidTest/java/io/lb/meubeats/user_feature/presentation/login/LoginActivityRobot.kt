package io.lb.meubeats.user_feature.presentation.login

import io.lb.meubeats.BaseTestRobot

class LoginActivityRobot: BaseTestRobot(LoginActivity::class.java) {
    fun login(func: LoginActivityRobot.() -> Unit) = LoginActivityRobot()
        .apply {
            start()
            func()
        }
}
