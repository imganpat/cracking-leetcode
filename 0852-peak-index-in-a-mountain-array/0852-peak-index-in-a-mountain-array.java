// Approach: Binary Search on Mountain Array
// 1. In a mountain array, values strictly increase up to the peak and then strictly decrease.
// 2. Use binary search with two pointers `low` and `high`.
// 3. At each step, check the middle index `mid`:
//    - If arr[mid] < arr[mid + 1], we are in the increasing part → move right (low = mid + 1).
//    - Otherwise, we are in the decreasing part or at the peak → move left (high = mid).
// 4. Continue until low == high; this index is the peak.
// 5. Return the peak index.
//
// Time complexity: O(log n) – binary search halves the search space each step
// Space complexity: O(1) – constant extra space used

class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int low = 0, high = arr.length - 1;

        // Binary search to find peak
        while (low < high) {
            int mid = low + (high - low) / 2;

            // If increasing, peak lies to the right
            if (arr[mid] < arr[mid + 1]) {
                low = mid + 1;
            } else {
                // If decreasing or at peak, move left
                high = mid;
            }
        }

        // low == high → peak index
        return low;
    }
}
