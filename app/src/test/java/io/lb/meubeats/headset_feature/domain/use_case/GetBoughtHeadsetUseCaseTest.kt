package io.lb.meubeats.headset_feature.domain.use_case

import io.lb.meubeats.headset_feature.domain.repository.HeadsetRepository
import io.lb.meubeats.utils.ResourceCreator
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test

class GetBoughtHeadsetUseCaseTest {
    private val repository = mockk<HeadsetRepository>()
    private val getHeadsets = GetBoughtHeadsetsUseCase(repository)

    @Test
    fun `getBoughtHeadsetsUseCase should return predefined size`() {
        // GIVEN
        coEvery { repository.getBoughtHeadsetsUseCase()} returns ResourceCreator.exampleHeadsets()

        // WHEN
        val result = runBlocking { getHeadsets() }

        // THEN
        Assert.assertEquals(result.size, 8)
    }

    @Test
    fun `getBoughtHeadsetsUseCase should return empty`() {
        // GIVEN
        coEvery { repository.getBoughtHeadsetsUseCase() } returns listOf()

        // WHEN
        val result = runBlocking { getHeadsets() }

        // THEN
        Assert.assertTrue(result.isEmpty())
    }
}