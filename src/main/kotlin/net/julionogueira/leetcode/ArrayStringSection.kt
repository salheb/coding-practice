package net.julionogueira.leetcode

class ArrayStringSection {
    fun removeDuplicates(nums: IntArray): Int {
        var lastItem:Int? = null;
        var arrayFinalSize = nums.size;
        var y = 0

        while (y < arrayFinalSize) {

            // If lastItem is equal to the actual item
            // means that we have a duplicate item that need to be removed
            if ((lastItem != null) && (nums[y] == lastItem)){
                // loop bringing next element to actual position
                for (x in y until nums.size){
                    // if inner loop is at the last position
                    // just overwrite last item of the loop with
                    // the lastItem val, because it is an unused position of the loop
                    if (x == nums.size-1) nums[x] = lastItem
                    else nums[x] = nums[x+1]
                }
                arrayFinalSize -= 1
            }
            // If lastItem var is null means that it's the
            // first interaction, so we don't have to compare nothing
            else{
                lastItem = nums[y]
                y += 1
            }

        }
        return arrayFinalSize
    }

    /**
     * This function is a better approach to remove duplicates
     * because it doesn't need to move the elements of the array
     * to remove the duplicates. Also, it presents a technique called
     * "Two Pointers" that is a common technique to solve problems
     * with arrays.
     */
    fun removeDuplicatesV2(nums: IntArray): Int {
        var uniquePointer = 0

        if (nums.isNotEmpty()) {
            for (i in 1 until nums.size) {
                if (nums[i] != nums[uniquePointer]) {
                    uniquePointer++
                    nums[uniquePointer] = nums[i]
                }
            }
            // Adding 1 because the uniquePointer is 0 based
            uniquePointer++
        }

        return uniquePointer
    }

    /** Merge two sorted arrays
     */
    fun mergeSorted(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
        // If n == zero means that we don't have to merge anything
        if (n == 0) return
        // If m == zero means that we have to copy all elements of nums2
        // to nums1 because nums2 is already sorted and nums 1 is empty
        if (m == 0){
            for (i in 0 until n){
                nums1[i] = nums2[i]
            }
            return
        }

        // Another scenarios, m and n not zero
        var n2index = n-1
        var n1index = m-1

        for (nMNindex in m+n-1 downTo 0){
            if ((n2index >= 0) && (n1index >= 0)) {
                if (nums1[n1index] < nums2[n2index]) {
                    nums1[nMNindex] = nums2[n2index]
                    n2index--
                } else if (nums1[n1index] > nums2[n2index]) {
                    nums1[nMNindex] = nums1[n1index]
                    n1index--
                } else if (nums1[n1index] == nums2[n2index]) {
                    nums1[nMNindex] = nums2[n2index]
                    n2index--
                }
            }
            else if ((n2index >= 0) && (nums2[n2index] != nums1[nMNindex])){
                nums1[nMNindex] = nums2[n2index]
                n2index--
            }
        }

    }

    fun removeElement(nums: IntArray, values: Int){

    }
}