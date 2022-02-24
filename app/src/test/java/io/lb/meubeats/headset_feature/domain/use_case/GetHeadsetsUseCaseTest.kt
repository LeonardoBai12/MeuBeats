package io.lb.meubeats.headset_feature.domain.use_case

import io.lb.meubeats.headset_feature.domain.repository.HeadsetRepository
import io.lb.meubeats.utils.ResourceCreator
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test

class GetHeadsetsUseCaseTest {
    private val repository = mockk<HeadsetRepository>()
    private val getHeadsets = GetHeadsetsUseCase(repository)

    @Test
    fun `getHeadsets should return predefined size`() {
        // GIVEN
        every { repository.getHeadsets()} returns ResourceCreator.exampleHeadsets()

        // WHEN
        val result = getHeadsets()

        // THEN
        Assert.assertEquals(result.size, 8)
    }

    @Test
    fun `getHeadsets should return empty`() {
        // GIVEN
        every { repository.getHeadsets() } returns arrayListOf()

        // WHEN
        val result = getHeadsets()

        // THEN
        Assert.assertEquals(result.size, 0)
    }
}