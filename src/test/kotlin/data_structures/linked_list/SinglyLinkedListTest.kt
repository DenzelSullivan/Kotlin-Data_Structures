package data_structures.linked_list

import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertNull

internal class SinglyLinkedListTest {

    lateinit var linkedList: SinglyLinkedList

    @Before
    fun setUp() {
        linkedList = SinglyLinkedList()
    }

    @Test
    fun `should correctly push items on to the list`() {
        linkedList.push(0)
        linkedList.push(1)
        linkedList.push(2)

        val node1 = linkedList.get(0)
        val node2 = linkedList.get(1)
        val node3 = linkedList.get(2)

        // checking values
        assertEquals(0, node1.value)
        assertEquals(1, node2.value)
        assertEquals(2, node3.value)

        // checking next
        assertEquals(node2, node1.next)
        assertEquals(node3, node2.next)
        assertEquals(null, node3.next)

        //checking length
        assertEquals(3, linkedList.length)
    }

    @Test
    fun `should correctly pop items off the list`() {
        linkedList.push(0)
        linkedList.push(1)
        linkedList.push(2)

        val node3 = linkedList.pop()
        assertEquals(2, node3?.value)
        assertEquals(2, linkedList.length)

        val node2 = linkedList.pop()
        assertEquals(1, node2?.value)
        assertEquals(1, linkedList.length)

        val node1 = linkedList.pop()
        assertEquals(0, node1?.value)
        assertEquals(0, linkedList.length)
    }

    @Test
    fun `should correctly set head and tail on push`() {
        assertNull(linkedList.head)
        assertNull(linkedList.tail)

        linkedList.push(0)

        val node1 = linkedList.get(0)
        assertEquals(node1, linkedList.head)
        assertEquals(node1, linkedList.tail)

        linkedList.push(1)

        val node2 = linkedList.get(1)
        assertEquals(node1, linkedList.head)
        assertEquals(node2, linkedList.tail)

        linkedList.push(3)

        val node3 = linkedList.get(2)
        assertEquals(node1, linkedList.head)
        assertEquals(node3, linkedList.tail)
    }

    @Test
    fun `should correctly set head and tail on pop`() {
        assertNull(linkedList.head)
        assertNull(linkedList.tail)

        linkedList.push(0)
        linkedList.push(1)
        linkedList.push(3)

        val node1 = linkedList.get(0)
        val node2 = linkedList.get(1)
        val node3 = linkedList.get(2)

        assertEquals(node1, linkedList.head)
        assertEquals(node3, linkedList.tail)

        linkedList.pop()
        assertEquals(node1, linkedList.head)
        assertEquals(node2, linkedList.tail)

        linkedList.pop()
        assertEquals(node1, linkedList.head)
        assertEquals(node1, linkedList.tail)

        linkedList.pop()
        assertNull(linkedList.head)
        assertNull(linkedList.tail)
    }

    @Test
    fun `should throw IndexOutOfBoundsException when get is called on an empty list`() {
        assertFailsWith<IndexOutOfBoundsException> { linkedList.get(0) }
    }

    @Test
    fun `should throw IndexOutOfBoundsException when get is called with an index less than 0 `() {
        assertFailsWith<IndexOutOfBoundsException> { linkedList.get(-1) }
    }

    @Test
    fun `should throw IndexOutOfBoundsException when get is called with an index larger than the length`() {
        linkedList.push(0)

        assertFailsWith<IndexOutOfBoundsException> { linkedList.get(5) }
    }
}