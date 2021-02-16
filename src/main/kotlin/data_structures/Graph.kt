package data_structures

/**
 * A graph is a data structure composed of a collection of nodes and edges. Graphs are non-linear as
 * opposed to stacks, queues, linked lists.
 * There are 2 types:
 *      Directed - Nodes are one way and have a direction. A -> B = true doesnt mean B -> A = true
 *      Undirected -Nodes are 2 way. A -> B = B -> A
 */
class Graph(
    private val undirected: Boolean = false
) {
    private val nodes: MutableList<Node> = mutableListOf()

    val size: Int
        get() = nodes.size

    fun addNode(value: Int) {
        if (nodes.any { it.value == value }) return

        nodes.add(Node(value))
    }

    fun removeNode(value: Int) {
        val updatedNodes = nodes.filter { it.value != value }
        nodes.clear()
        nodes.addAll(updatedNodes)

        nodes.forEach { node ->
            val updatedEdges = node.edges.filter { it.value != value }
            node.edges.clear()
            node.edges.addAll(updatedEdges)
        }
    }

    fun getNode(value: Int) = nodes.find { it.value == value }

    fun addEdge(first: Int, second: Int): Boolean {
        val firstNode = getNode(first)
        val secondNode = getNode(second)

        if (firstNode == null || secondNode == null) {
            println("Edge creation failed: Node Not found.")
            return false
        }

        firstNode.edges.add(secondNode)
        if (undirected) secondNode.edges.add(firstNode)
        println("An edge between ${firstNode.value} and ${secondNode.value} has been created")
        return true
    }
}

data class Node(
    val value: Int,
    val edges: MutableList<Node> = mutableListOf()
)