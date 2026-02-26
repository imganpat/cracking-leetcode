// Approach: Single Binary Search in Rotated Sorted Array
// 1. Use binary search without explicitly finding the pivot.
// 2. At each step, determine whether the middle element lies in the left sorted portion
//    or the right sorted portion by comparing it with nums[n - 1].
// 3. If nums[m] > nums[n - 1], then m lies in the left sorted part.
//    - Decide whether the target is inside this sorted part or in the other half.
// 4. Otherwise, m lies in the right sorted part.
//    - Again decide whether the target belongs to this portion or the opposite side.
// 5. Adjust l and r accordingly to narrow down the search.
// 6. Continue until the element is found or search space becomes empty.
//
// Time complexity: O(log n) – standard binary search
// Space complexity: O(1) – constant extra space used

class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int l = 0, r = n - 1;

        while (l <= r) {
            int m = (l + r) / 2;

            // Target found
            if (nums[m] == target) {
                return m;
            }

            // Check if mid is in left sorted portion
            if (nums[m] > nums[n - 1]) {

                // Target is greater than mid → move right
                if (nums[m] < target) {
                    l = m + 1;
                } else {
                    // Decide if target lies in right half
                    if (nums[0] > target) {
                        l = m + 1;
                    } else {
                        r = m - 1;
                    }
                }

            } else { // mid is in right sorted portion

                // Target smaller than mid → move left
                if (nums[m] > target) {
                    r = m - 1;
                } else {
                    // Decide if target lies in left half
                    if (nums[n - 1] < target) {
                        r = m - 1;
                    } else {
                        l = m + 1;
                    }
                }
            }
        }

        return -1; // Target not found
    }
}