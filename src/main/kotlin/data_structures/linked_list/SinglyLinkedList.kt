package data_structures.linked_list

/**
 * A LinkedList is a LIFO data structure similar to a stack. A Singly LinkedList contains nodes that hold a value
 * and a reference(pointer) to the next node in the list. Because searching must start from the front, it has
 * a runtime of O(n)
 */
class SinglyLinkedList : LinkedList<SinglyNode>() {

    override fun push(value: Int) {
        val node = SinglyNode(value)
        if (isEmpty()) {
            head = node
            tail = node
        } else {
            tail?.next = node
            tail = node
        }

        length++
    }

    override fun pop(): SinglyNode? = when {
        isEmpty() -> null
        length == 1 -> {
            val nodeToRemove = head
            head = null
            tail = null
            length--
            nodeToRemove
        }
        else -> {
            var current: SinglyNode? = head
            val nodeToRemove: SinglyNode? = tail
            var secondToLast: SinglyNode? = null
            while (current != null) {
                if (current.next == tail) {
                    secondToLast = current
                    break
                }
                current = current.next
            }
            secondToLast?.next = null
            tail = secondToLast
            length--
            nodeToRemove
        }
    }

    override fun get(index: Int): SinglyNode {
        if (index < 0 || index >= length || isEmpty()) {
            throw IndexOutOfBoundsException()
        }

        if (index == 0) return head as SinglyNode
        if (index == lastIndex) return tail as SinglyNode

        var current = head
        var currentIndex = 0
        while (currentIndex < index) {
            current = current?.next
            currentIndex++
        }

        return current as SinglyNode
    }

    override fun toString(): String {
        if (isEmpty())
            return "[]"

        val values = mutableListOf<Int>()
        for (i in 0 until length) {
            values.add(get(i).value)
        }

        return values.toString()
    }
}
