package io.lb.meubeats.user_feature.domain.use_case

import io.lb.meubeats.user_feature.domain.repository.UserRepository
import io.lb.meubeats.user_feature.domain.util.InvalidUserException

class CreateUserUseCase(
    private val repository: UserRepository,
) {
    @Throws(InvalidUserException::class)
    operator fun invoke(email: String?, password: String?) {
        if (email.isNullOrBlank()) {
            throw InvalidUserException("Please, type an email")
        }
        if (password.isNullOrBlank()) {
            throw InvalidUserException("Please, type a password")
        }
        repository.insertUser(email, password)
    }
}