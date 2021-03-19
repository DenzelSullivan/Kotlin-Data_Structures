package algorithms

import org.junit.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class BinarySearchTest {

    companion object {
        private val list = intArrayOf(3, 5, 7, 9, 0, 1, 4)
    }

    @Test
    fun `should return true when value is found`() {
        assertTrue(list.binarySearch(5))
    }

    @Test
    fun `should return false when value is NOT found`() {
        assertFalse(list.binarySearch(10))
    }
}