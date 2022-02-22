package io.lb.meubeats.user_feature.domain.use_case

import io.lb.meubeats.user_feature.domain.repository.UserRepository
import io.lb.meubeats.user_feature.domain.util.InvalidUserException
import io.mockk.every
import io.mockk.impl.annotations.SpyK
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test

class CreateUserUseCaseTest {

    private val repository = mockk<UserRepository>()
    private val createUser = CreateUserUseCase(repository)

    @Test
    fun `createUser with user and password returns success`() = runBlocking {
        val user = "user@example.com"
        val password = "password!22"

        // GIVEN
        every { repository.insertUser(user, password)} returns Unit

        // WHEN
        val result = createUser(user, password)

        // THEN
        Assert.assertEquals(result, Unit)
    }

    @Test
    fun `createUser without user returns failure`() = runBlocking {
        val user = ""
        val password = "password!22"

        val throws = Assert.assertThrows(InvalidUserException::class.java) {
            createUser(user, password)
        }

        Assert.assertEquals("Por favor, digite seu usuário", throws.message)
    }

    @Test
    fun `createUser without password returns failure`() = runBlocking {
        val user = "user@example.com"
        val password = ""

        val throws = Assert.assertThrows(InvalidUserException::class.java) {
            createUser(user, password)
        }

        Assert.assertEquals("Por favor, digite sua senha", throws.message)
    }
}