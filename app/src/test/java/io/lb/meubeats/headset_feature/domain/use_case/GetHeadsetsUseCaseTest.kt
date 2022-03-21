package io.lb.meubeats.headset_feature.domain.use_case

import io.lb.meubeats.headset_feature.domain.repository.HeadsetRepository
import io.lb.meubeats.utils.ResourceCreator
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import org.junit.Assert
import org.junit.Test

class GetHeadsetsUseCaseTest {
    private val repository = mockk<HeadsetRepository>()
    private val getHeadsets = GetHeadsetsUseCase(repository)

    @Test
    suspend fun `getHeadsets should return predefined size`() {
        // GIVEN
        coEvery { repository.getHeadsetsFromDatabase().value} returns ResourceCreator.exampleHeadsets()

        // WHEN
        val result = getHeadsets().value

        // THEN
        Assert.assertEquals(result?.size, 8)
    }

    @Test
    suspend fun `getHeadsets should return empty`() {
        // GIVEN
        coEvery { repository.getHeadsetsFromDatabase().value } returns arrayListOf()

        // WHEN
        val result = getHeadsets().value

        // THEN
        Assert.assertEquals(result?.size, 0)
    }
}