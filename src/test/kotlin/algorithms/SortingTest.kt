package algorithms

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import kotlin.test.assertNotEquals

class SortingTest {

    private val expectedList = intArrayOf(0, 1, 2, 3, 4, 5)
    private val unsorted = expectedList.clone()

    @Before
    fun setUp(){
        unsorted.shuffle()
    }

    @Test
    fun `bubble sort should correctly sort`() {
        assertNotEquals(expectedList, unsorted)
        unsorted.bubbleSort()
        assertEquals(expectedList.toList(), unsorted.toList())
    }

    @Test
    fun `merge sort should correctly sort`() {
        assertNotEquals(expectedList, unsorted)
        val sorted = unsorted.mergeSort()
        assertEquals(expectedList.toList(), sorted.toList())
    }

    @Test
    fun `quick sort should correctly sort`(){
        assertNotEquals(expectedList, unsorted)
        val sorted = unsorted.quickSort()
        assertEquals(expectedList.toList(), sorted.toList())
    }

    @Test
    fun `insertion sort should correctly sort`(){
        assertNotEquals(expectedList, unsorted)
        unsorted.insertionSort()
        assertEquals(expectedList.toList(), unsorted.toList())
    }

}