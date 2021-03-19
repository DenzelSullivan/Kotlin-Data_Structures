package algorithms

/**
 * BinarySearch: Searching algorithm that repeatedly divides a list in half until the
 * element is found or there are no other elements left to search.
 *
 * Runtime = O(log n)
 */
fun IntArray.binarySearch(item: Int): Boolean {
    this.sort()

    var low = 0
    var high = this.size

    while(low <= high){
        val mid = (low + high) / 2
        val guess = this[mid]
        when {
            guess == item -> return true
            guess < item -> low = mid + 1
            else -> high = mid - 1
        }
    }
    return false
}

/**
 * Binary search psudocode
 *
 * 1. Get the list
 * 2. Sort the list
 * 3. Get the size/length
 * 4. Create while -> low less than or equal to high
 * 5. Get middle index -> low + high / 2
 * 6. If guess = middle value -> Done
 * 7. Else, if quess is bigger -> low = middle + 1
 * 8. Else, if guess is smaller -> high = middle - 1
 * 9. If no value is found return false
 */