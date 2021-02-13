package data_structures.linked_list

/**
 * Doubly LinkedLists are just like there Singly counterpart except a Doubly node contains a pointer to both the
 * previous node in the list and the next node in the list. This drastically improves search and remove both in
 * runtime and complexity
 */
class DoublyLinkedList : LinkedList<DoublyNode>() {

    override fun push(value: Int) {
        val node = DoublyNode(value)
        if (isEmpty()) {
            head = node
            tail = node
        } else {
            tail?.next = node
            node.previous = tail
            tail = node
        }

        length++
    }

    override fun pop(): DoublyNode? = when {
        isEmpty() -> null
        length == 1 -> {
            val nodeToRemove = head
            head = null
            tail = null
            length--
            nodeToRemove
        }
        else -> {
            val nodeToRemove = tail
            val newTail = tail?.previous
            newTail?.next = null
            tail = newTail
            length--
            nodeToRemove
        }

    }

    override fun get(index: Int): DoublyNode {
        if (index < 0 || index >= length || isEmpty()) {
            throw IndexOutOfBoundsException()
        }

        if (index == 0) return head as DoublyNode
        if (index == lastIndex) return tail as DoublyNode

        // Split with if to optimize
        var current: DoublyNode?
        val middleIndex = lastIndex / 2
        if (index < middleIndex) {
            current = head
            var currentIndex = 0
            while (currentIndex < index) {
                current = current?.next
                currentIndex++
            }
        } else {
            current = tail
            var currentIndex = lastIndex
            while (currentIndex > index) {
                current = current?.previous
                currentIndex--
            }
        }

        return current as DoublyNode
    }
}