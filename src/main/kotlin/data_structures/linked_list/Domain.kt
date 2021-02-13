package data_structures.linked_list

abstract class LinkedList<T> {
    var head: T? = null
    var tail: T? = null
    var length: Int = 0
    val lastIndex: Int
        get() = if (length > 0) length - 1 else length

    abstract fun push(value: Int)
    abstract fun pop(): T?
    abstract fun get(index: Int): T
    fun isEmpty(): Boolean = length == 0
}

data class SinglyNode(
    val value: Int,
    var next: SinglyNode? = null
)

data class DoublyNode(
    val value: Int,
    var next: DoublyNode? = null,
    var previous: DoublyNode? = null
) {
    override fun toString(): String {
        return "DoublyNode( previous = ${previous?.value}, value = $value, next = ${next?.value})"
    }
}