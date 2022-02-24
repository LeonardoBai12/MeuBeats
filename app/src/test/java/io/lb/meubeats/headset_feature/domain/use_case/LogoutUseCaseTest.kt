package io.lb.meubeats.headset_feature.domain.use_case

import io.lb.meubeats.headset_feature.domain.repository.HeadsetRepository
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test

class LogoutUseCaseTest {

    private val repository = mockk<HeadsetRepository>()
    private val logout = LogoutUseCase(repository)

    @Test
    fun `logout returns success`() = runBlocking {
        // GIVEN
        every { repository.logout() } returns Unit

        // WHEN
        val result = logout()

        // THEN
        Assert.assertEquals(result, Unit)
    }
}