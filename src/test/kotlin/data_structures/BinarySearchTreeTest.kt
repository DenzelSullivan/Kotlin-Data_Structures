package data_structures

import org.junit.Assert.assertFalse
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertNull
import kotlin.test.assertTrue

class BinarySearchTreeTest {
    lateinit var bstTree: BinaryTree

    @Before
    fun setUp() {
        bstTree = BinaryTree()
    }

    @Test
    fun `should correctly add first Node`() {
        bstTree.addChild(0)

        assertNotNull(bstTree.root)
        assertEquals(0, bstTree.root!!.value)
        assertNull(bstTree.root!!.leftChild)
        assertNull(bstTree.root!!.rightChild)
    }

    @Test
    fun `should NOT add duplicate node`() {
        val addedFirst = bstTree.addChild(0)
        val addedSecond = bstTree.addChild(0)

        assertTrue(addedFirst)
        assertFalse(addedSecond)
    }

    @Test
    fun `should add a node less than the root to the left`() {
        bstTree.addChild(5)
        bstTree.addChild(1)

        assertNotNull(bstTree.root!!.leftChild)
        assertNull(bstTree.root!!.rightChild)
        assertEquals(1, bstTree.root!!.leftChild!!.value)
    }

    @Test
    fun `should add a node more than the root to the right`() {
        bstTree.addChild(5)
        bstTree.addChild(10)

        assertNotNull(bstTree.root!!.rightChild)
        assertNull(bstTree.root!!.leftChild)
        assertEquals(10, bstTree.root!!.rightChild!!.value)
    }

    @Test
    fun `should return false when removing a node that isnt found`() {
        bstTree.addChild(1)

        assertEquals(1, bstTree.root?.value)

        val isRemoved = bstTree.removeChild(5)

        assertFalse(isRemoved)
        assertNotNull(bstTree.root)
        assertEquals(1, bstTree.root?.value)
    }

    @Test
    fun `should correctly remove root node when there are no children`() {
        bstTree.addChild(5)

        assertEquals(5, bstTree.root?.value)

        val isRemoved = bstTree.removeChild(5)

        assertTrue(isRemoved)
        assertNull(bstTree.root)
    }

    @Test
    fun `should correctly remove root node when there is a left child`() {
        bstTree.addChild(5)
        bstTree.addChild(1)

        assertEquals(5, bstTree.root?.value)
        assertEquals(1, bstTree.root?.leftChild?.value)

        val isRemoved = bstTree.removeChild(5)

        assertTrue(isRemoved)
        assertEquals(1, bstTree.root?.value)
    }

    @Test
    fun `should correctly remove root node when there is a right child`() {
        bstTree.addChild(5)
        bstTree.addChild(10)

        assertEquals(5, bstTree.root?.value)
        assertEquals(10, bstTree.root?.rightChild?.value)

        val isRemoved = bstTree.removeChild(5)

        assertTrue(isRemoved)
        assertEquals(10, bstTree.root?.value)
    }

    @Test
    fun `should correctly remove root node when there are both children`() {
        bstTree.addChild(5)
        bstTree.addChild(1)
        bstTree.addChild(10)

        assertEquals(5, bstTree.root?.value)
        assertEquals(1, bstTree.root?.leftChild?.value)
        assertEquals(10, bstTree.root?.rightChild?.value)

        val isRemoved = bstTree.removeChild(5)

        assertTrue(isRemoved)
        assertEquals(5, bstTree.root?.value)
        assertEquals(1, bstTree.root?.leftChild?.value)
    }

    @Test
    fun `should correctly remove left node`() {
        bstTree.addChild(5)
        bstTree.addChild(1)

        assertEquals(5, bstTree.root?.value)
        assertEquals(1, bstTree.root?.leftChild?.value)

        val isRemoved = bstTree.removeChild(1)

        assertTrue(isRemoved)
        assertEquals(5, bstTree.root?.value)
        assertNull(bstTree.root?.leftChild)
    }

    @Test
    fun `should correctly remove right node`() {
        bstTree.addChild(5)
        bstTree.addChild(10)

        assertEquals(5, bstTree.root?.value)
        assertEquals(10, bstTree.root?.rightChild?.value)

        val isRemoved = bstTree.removeChild(10)

        assertTrue(isRemoved)
        assertEquals(5, bstTree.root?.value)
        assertNull(bstTree.root?.rightChild)
    }

    // TODO: Improve coverage. Currently testing removeChild on level down tree. Coverage = 86%
}