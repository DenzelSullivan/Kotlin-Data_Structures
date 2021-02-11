package data_structures

import org.junit.Assert
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

internal class QueueTest {

    lateinit var queue: Queue

    @Before
    fun setUp() {
        queue = Queue()
    }

    @Test
    fun `should add values when enqueue is called`() {
        queue.enqueue(0)
        queue.enqueue(1)

        assertEquals(2, queue.length)
    }

    @Test
    fun `should remove values when dequeue is called`() {
        queue.enqueue(0)
        queue.enqueue(1)

        assertEquals(2, queue.length)

        queue.dequeue()

        assertEquals(1, queue.length)

        queue.dequeue()

        assertEquals(0, queue.length)
    }

    @Test
    fun `should show the first value when peek is called`() {
        queue.enqueue(0)
        queue.enqueue(1)
        queue.enqueue(2)

        assertEquals(0, queue.peek())
    }

    @Test
    fun `isEmpty should return true when the stack is empty`() {
        queue.enqueue(0)
        queue.dequeue()

        assertTrue(queue.isEmpty())
    }

    @Test
    fun `isEmpty should return false when the stack is not empty`() {
        queue.enqueue(0)

        Assert.assertFalse(queue.isEmpty())
    }

    @Test
    fun `should show the correct length of the queue`() {
        queue.enqueue(0)
        queue.enqueue(1)
        queue.enqueue(2)

        assertEquals(3, queue.length)
    }
}