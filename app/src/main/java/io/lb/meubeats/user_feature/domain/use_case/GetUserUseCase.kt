package io.lb.meubeats.user_feature.domain.use_case

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import io.lb.meubeats.user_feature.domain.repository.UserRepository
import io.lb.meubeats.user_feature.domain.util.InvalidUserException

class GetUserUseCase(
    private val repository: UserRepository,
) {
    @Throws(InvalidUserException::class)
    operator fun invoke(email: String?, password: String?): Task<AuthResult> {
        if (email.isNullOrBlank()) {
            throw InvalidUserException("Por favor, digite seu usuário")
        }
        if (password.isNullOrBlank()) {
            throw InvalidUserException("Por favor, digite sua senha")
        }

        return repository.getUser(email, password)
    }
}