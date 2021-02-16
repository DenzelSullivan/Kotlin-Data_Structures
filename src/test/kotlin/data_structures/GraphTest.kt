package data_structures

import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue
import kotlin.test.fail

internal class GraphTest {
    lateinit var graph: Graph

    @Before
    fun setUp(){
        graph = Graph(false)
    }

    @Test
    fun `should add a node when addNode is called`(){
        graph.addNode(0)
        graph.addNode(1)
        graph.addNode(2)

        assertEquals(3, graph.size)
    }

    @Test
    fun `should NOT add duplicate nodes when addNode is called`(){
        graph.addNode(0)
        graph.addNode(0)

        assertEquals(1, graph.size)
    }

    @Test
    fun `should add an edge when add edge is called`(){
        graph.addNode(0)
        graph.addNode(1)

        graph.addEdge(0,1)

        val node1 = graph.getNode(0)
        val node2 = graph.getNode(1)

        assertEquals(true, node1?.edges?.contains(node2))
        assertEquals(false, node2?.edges?.contains(node1))
    }

    @Test
    fun `should add both edges when add edge is called on an undirected graph`(){
        graph = Graph(true)

        graph.addNode(0)
        graph.addNode(1)

        graph.addEdge(0,1)

        val node1 = graph.getNode(0)
        val node2 = graph.getNode(1)

        assertEquals(true, node1?.edges?.contains(node2))
        assertEquals(true, node2?.edges?.contains(node1))
    }

    @Test
    fun `should remove a node when removeNode is called`(){
        graph.addNode(0)
        graph.addNode(1)

        assertEquals(2, graph.size)

        graph.removeNode(1)

        assertEquals(2, graph.size)

        graph.removeNode(0)

        assertEquals(0, graph.size)
    }

    @Test
    fun `should remove a nodes corresponding edges when removeNode is called`(){
        graph.addNode(0)
        graph.addNode(1)
        graph.addEdge(0, 1)

        var node1 = graph.getNode(0)
        val node2 = graph.getNode(1)

        assertEquals(true, node1?.edges?.contains(node2))

        graph.removeNode(1)

        node1 = graph.getNode(0)

        assertEquals(false, node1?.edges?.contains(node2))
        assertEquals(0, node1?.edges?.size)
    }
}