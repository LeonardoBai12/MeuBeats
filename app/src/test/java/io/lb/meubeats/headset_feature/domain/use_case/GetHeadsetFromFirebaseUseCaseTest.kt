package io.lb.meubeats.headset_feature.domain.use_case

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import io.lb.meubeats.headset_feature.domain.model.Headset
import io.lb.meubeats.headset_feature.domain.repository.HeadsetRepository
import io.lb.meubeats.utils.ResourceCreator
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test

class GetHeadsetFromFirebaseUseCaseTest {
    private val repository = mockk<HeadsetRepository>()
    private val getHeadsets = GetHeadsetsFromFirebaseUseCase(repository)

    @Test
    fun `getHeadsetsFromFirebase returns success`() = runBlocking {
        // GIVEN
        val taskMock = mockk<(ArrayList<Headset>) -> Unit>()
        every { repository.getHeadsetsFromFirebase(taskMock) } returns Unit

        // WHEN
        val result = getHeadsets(taskMock)

        // THEN
        Assert.assertEquals(result, Unit)
    }
}