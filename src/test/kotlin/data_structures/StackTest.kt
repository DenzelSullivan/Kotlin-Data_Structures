package data_structures

import org.junit.Assert.assertFalse
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

internal class StackTest {

    lateinit var stack: Stack

    @Before
    fun setUp() {
        stack = Stack()
    }

    @Test
    fun `should add values when push is called`() {
        stack.push(0)
        stack.push(1)

        assertEquals(2, stack.length)
    }

    @Test
    fun `should remove values when pop is called`() {
        stack.push(0)
        stack.push(1)

        assertEquals(2, stack.length)

        stack.pop()

        assertEquals(1, stack.length)

        stack.pop()

        assertEquals(0, stack.length)
    }

    @Test
    fun `should show the top value when peek is called`() {
        stack.push(0)
        stack.push(1)
        stack.push(2)

        assertEquals(2, stack.peek())
    }

    @Test
    fun `isEmpty should return true when the stack is empty`() {
        stack.push(0)
        stack.pop()

        assertTrue(stack.isEmpty())
    }

    @Test
    fun `isEmpty should return false when the stack is not empty`() {
        stack.push(0)

        assertFalse(stack.isEmpty())
    }

    @Test
    fun `should show the correct length of the stack`() {
        stack.push(0)
        stack.push(1)
        stack.push(2)

        assertEquals(3, stack.length)
    }
}