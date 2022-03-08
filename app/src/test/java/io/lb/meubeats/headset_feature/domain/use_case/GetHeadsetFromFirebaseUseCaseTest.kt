package io.lb.meubeats.headset_feature.domain.use_case

import io.lb.meubeats.headset_feature.domain.model.Headset
import io.lb.meubeats.headset_feature.domain.repository.HeadsetRepository
import io.mockk.every
import io.mockk.mockk
import org.junit.Assert
import org.junit.Test

class GetHeadsetFromFirebaseUseCaseTest {
    private val repository = mockk<HeadsetRepository>()
    private val getHeadsets = GetHeadsetsFromFirebaseUseCase(repository)

    @Test
    fun `getHeadsetsFromFirebase returns success`() {
        // GIVEN
        every { repository.getHeadsetsFromFirebase(any()) } returns Unit

        // WHEN
        val taskMock = mockk<(ArrayList<Headset>) -> Unit>()
        val result = getHeadsets(taskMock)

        // THEN
        Assert.assertEquals(result, Unit)
    }
}