package algorithms

/**
 * Bubble Sort: Sorting algorithm where each value in an array is compared to the next and swapped if the left value
 * is greater than the right.
 *
 * Runtime: O(n^2)
 */
fun IntArray.bubbleSort() {
    for (i in 0..this.lastIndex) {
        for (j in 0 until this.lastIndex) {
            if (this[j] > this[j + 1]) {
                val temp = this[j]
                this[j] = this[j + 1]
                this[j + 1] = temp
            }
        }
    }
}

/**
 * Merge Sort: A divide and conquer algorithm that divides an array into two halves and recursively calls itself
 * on each half, then merges the two sorted halves back together.
 *
 * Runtime: O(n log n)
 */
fun IntArray.mergeSort(): IntArray {
    if (this.size < 2) return this

    val middle = this.size / 2
    val left = this.slice(0 until middle).toIntArray()
    val right = this.slice(middle..this.lastIndex).toIntArray()

    return merge(left.mergeSort(), right.mergeSort())
}

private fun merge(leftArray: IntArray, rightArray: IntArray): IntArray {
    val left = leftArray.toMutableList()
    val right = rightArray.toMutableList()
    var sorted: IntArray = intArrayOf()

    while (left.isNotEmpty() && right.isNotEmpty()) {
        sorted = if (left.first() <= right.first()) {
            sorted.plus(left.removeFirst())
        } else {
            sorted.plus(right.removeFirst())
        }
    }

    return intArrayOf().plus(sorted).plus(left).plus(right)
}

/**
 * Quick Sort: A divide and conquer algorithm that picks an element as a pivot and partitions the array around the pivot.
 * Pivot Selection: Always First, Always Last, Random, Median
 *
 * Runtime: O(n log n)
 */
fun IntArray.quickSort(): IntArray {
    if (this.size < 2) return this

    val pivotIndex = this.size / 2
    val pivot = this[pivotIndex]

    val less = mutableListOf<Int>()
    val greater = mutableListOf<Int>()
    for (i in this) {
        if (i != pivotIndex) {
            if (this[i] > pivot) greater.add(this[i]) else less.add(this[i])
        }
    }
    return intArrayOf().plus(less).plus(pivot).plus(greater)
}

/**
 * Insertion Sort: Picks an element and inserts it in its correct position between 0 and the element before it.
 * Every element is swapped with every other element.
 *
 * Runtime: O(n^2)
 */
fun IntArray.insertionSort() {
    for(i in 1..this.lastIndex){
        val key = this[i]
        var j = i - 1

        // shift until you find the position to place the key
        while (j >= 0 && this[j] > key){
            this[j+1] = this[j]
            j--
        }
        this[j+1] = key
    }
}
