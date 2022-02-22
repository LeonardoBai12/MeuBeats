package io.lb.meubeats.headset_feature.domain.use_case

import com.google.android.gms.tasks.Task
import io.lb.meubeats.headset_feature.domain.model.InvalidHeadsetException
import io.lb.meubeats.headset_feature.domain.repository.HeadsetRepository
import io.lb.meubeats.utils.ResourceCreator
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test

class InsertHeadsetToFirebaseUseCaseTest {
    private val repository = mockk<HeadsetRepository>()
    private val insertHeadset = InsertHeadsetToFirebaseUseCase(repository)

    @Test
    fun `insertHeadset with id and headset returns success`() = runBlocking {
        val headset = ResourceCreator.simpleHeadset(0)

        // GIVEN
        val taskMock = mockk<Task<Void>>()
        every { repository.insertHeadseToFirebase(0, headset) } returns taskMock

        // WHEN
        val result = insertHeadset(0, headset)

        // THEN
        Assert.assertEquals(result, taskMock)
    }

    @Test
    fun `insertHeadset without id returns exception`() = runBlocking {
        val headset = ResourceCreator.simpleHeadset(0)

        val throws = Assert.assertThrows(InvalidHeadsetException::class.java) {
            insertHeadset(null, headset)
        }

        Assert.assertEquals("Não foi possível adicionar o produto", throws.message)
    }

    @Test
    fun `insertHeadset without headset returns exception`() = runBlocking {
        val throws = Assert.assertThrows(InvalidHeadsetException::class.java) {
            insertHeadset(0, null)
        }

        Assert.assertEquals("Não foi possível adicionar o produto", throws.message)
    }
}