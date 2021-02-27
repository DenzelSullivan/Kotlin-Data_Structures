package data_structures

/**
 * A BinarySearchTree is a data structure that contains nodes similar to a graph. The top most node is the root.
 * The BST is a special type of tree in that each node can only have zero - 2 children. Also, values are placed based on
 * the value of the root. Lesser values to the left and higher values to the right.
 *
 * The main benefit of using a BST is that you can use Binary Search to find a value. (Runtime = O(log n)
 */
class BinaryTree {
    var root: BSTNode? = null

    fun addChild(value: Int): Boolean {
        if (root == null) {
            root = BSTNode(value)
            return true
        } else {
            var currentNode = root
            var added = false

            while (!added && currentNode != null) {
                if (value == currentNode.value) {
                    println("Duplicates cannot be added.")
                    return false
                }

                if (value < currentNode.value) {
                    if (currentNode.leftChild == null) {
                        currentNode.leftChild = BSTNode(value)
                        added = true
                    } else {
                        currentNode = currentNode.leftChild
                    }
                } else if (value > currentNode.value) {
                    if (currentNode.rightChild == null) {
                        currentNode.rightChild = BSTNode(value)
                        added = true
                    } else {
                        currentNode = currentNode.rightChild
                    }
                }
            }

            return added
        }

    }

    fun removeChild(value: Int): Boolean {
        var currentNode = root
        var found = false
        var nodeToRemove: BSTNode? = null
        var parentNode: BSTNode? = null

        while (!found) {
            if (currentNode?.value == null) {
                println("Node not found.")
                return false
            }

            when {
                value == currentNode.value -> {
                    nodeToRemove = currentNode
                    found = true
                }
                value < currentNode.value -> {
                    parentNode = currentNode
                    currentNode = currentNode.leftChild
                }
                else -> {
                    parentNode = currentNode
                    currentNode = currentNode.rightChild
                }
            }
        }

        val nodeToRemoveIsParentsLeftChild = parentNode?.leftChild == nodeToRemove

        if (nodeToRemove?.leftChild == null && nodeToRemove?.rightChild == null) {
            // If node is a leaf node remove it
            when {
                parentNode == null -> root = null
                nodeToRemoveIsParentsLeftChild -> parentNode.leftChild = null
                !nodeToRemoveIsParentsLeftChild -> parentNode.rightChild = null
            }
        } else if (nodeToRemove.leftChild != null && nodeToRemove.rightChild == null) {
            // only has a left child
            when {
                parentNode == null -> root = nodeToRemove.leftChild
                nodeToRemoveIsParentsLeftChild -> parentNode.leftChild = nodeToRemove.leftChild
                !nodeToRemoveIsParentsLeftChild -> parentNode.rightChild = nodeToRemove.leftChild
            }
        } else if (nodeToRemove.leftChild == null && nodeToRemove.rightChild != null) {
            // only has a right child
            when {
                parentNode == null -> root = nodeToRemove.rightChild
                nodeToRemoveIsParentsLeftChild -> parentNode.leftChild = nodeToRemove.rightChild
                !nodeToRemoveIsParentsLeftChild -> parentNode.rightChild = nodeToRemove.rightChild
            }
        } else {
            // has two children
            val rightSubTree = nodeToRemove.rightChild
            val leftSubTree = nodeToRemove.leftChild

            // set parent node child to the right sub tree
            if (nodeToRemoveIsParentsLeftChild) {
                parentNode?.leftChild = rightSubTree
            } else {
                parentNode?.rightChild = rightSubTree
            }

            // Find the lowest free space on the left side of the
            // right sub tree and add the leftSubTree
            var currentLeftNode = rightSubTree
            var currentLeftParent: BSTNode? = null
            var foundSpace = false

            while (!foundSpace) {
                if (currentLeftNode == null) {
                    foundSpace = true
                } else {
                    currentLeftParent = currentLeftNode
                    currentLeftNode = currentLeftNode.leftChild
                }
            }
            currentLeftParent?.leftChild = leftSubTree
            return true
        }

        return true
    }
}

data class BSTNode(
    val value: Int,
    var leftChild: BSTNode? = null,
    var rightChild: BSTNode? = null
)