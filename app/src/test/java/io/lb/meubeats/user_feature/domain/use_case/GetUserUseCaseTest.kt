package io.lb.meubeats.user_feature.domain.use_case

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import io.lb.meubeats.user_feature.domain.repository.UserRepository
import io.lb.meubeats.user_feature.domain.util.InvalidUserException
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test

class GetUserUseCaseTest {
    private val repository = mockk<UserRepository>()
    private val getUser = GetUserUseCase(repository)

    @Test
    fun `getUser with user and password returns success`() = runBlocking {
        val user = "user@example.com"
        val password = "password!22"

        // GIVEN
        val taskMock = mockk<Task<AuthResult>>()
        every { repository.getUser(user, password) } returns taskMock

        // WHEN
        val result = getUser(user, password)

        // THEN
        Assert.assertEquals(result, taskMock)
    }

    @Test
    fun `getUser without user returns exception`() = runBlocking {
        val user = ""
        val password = "password!22"

        val throws = Assert.assertThrows(InvalidUserException::class.java) {
            getUser(user, password)
        }

        Assert.assertEquals("Por favor, digite seu usuário", throws.message)
    }

    @Test
    fun `getUser without password returns exception`() = runBlocking {
        val user = "user@example.com"
        val password = ""

        val throws = Assert.assertThrows(InvalidUserException::class.java) {
            getUser(user, password)
        }

        Assert.assertEquals("Por favor, digite sua senha", throws.message)
    }
}