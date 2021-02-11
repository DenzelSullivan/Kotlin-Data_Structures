package data_structures

/**
 * A Queue is a FIFO data structure. Items are removed in the same order that they are entered
 * Pros: Often used in breadth-first searches as well as cashing
 * Cons: Difficult to update due to adding/removing happening on opposite ends
 */
class Queue {
    private val queue: MutableList<Int> = mutableListOf()

    fun enqueue(value: Int) = queue.add(value)

    fun dequeue() {
        queue.removeFirst()
    }

    fun peek():Int = queue[0]

    fun isEmpty(): Boolean = queue.isEmpty()

    val length: Int
        get() = queue.size

    override fun toString(): String {
        return "Queue: $queue"
    }
}