package io.lb.meubeats.user_feature.domain.use_case

import com.google.firebase.auth.FirebaseUser
import io.lb.meubeats.user_feature.domain.repository.UserRepository
import io.lb.meubeats.user_feature.domain.util.InvalidUserException

class GetUserUseCase(
    private val repository: UserRepository,
) {
    @Throws(InvalidUserException::class)
    operator fun invoke(
        email: String?,
        password: String?,
        onComplete: (FirebaseUser?) -> Unit
    ) {
        if (email.isNullOrBlank()) {
            throw InvalidUserException("por favor, digite seu usuário")
        }
        if (password.isNullOrBlank()) {
            throw InvalidUserException("Por favor, digite sua senha")
        }

        repository.getUser(email, password) { user ->
            if (user == null) {
                //TODO erro nessa exception
                //throw InvalidUserException("Usuário e/ou senha incorretos!")
            } else {
                onComplete(user)
            }
        }
    }
}