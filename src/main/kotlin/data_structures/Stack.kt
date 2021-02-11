package data_structures

/**
 * A Stack is a LIFO data structure. This means that the newest items added are the first to be removed.
 * Pros: Add and remove have a constant runtime - O(1)
 * Cons: Accessing a specific item has a linear runtime - O(n)
 */
class Stack {

    private val stack: MutableList<Int> = mutableListOf()

    fun pop() = stack.removeAt(stack.lastIndex)

    fun push(value: Int) = stack.add(value)

    fun peek(): Int = stack[stack.lastIndex]

    fun isEmpty(): Boolean = stack.isEmpty()

    val length: Int
        get() = stack.size

    override fun toString(): String {
        return "Stack: $stack"
    }
}

