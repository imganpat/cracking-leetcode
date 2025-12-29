// Approach: Kadane’s Algorithm (Dynamic Programming)
// 1. Use a variable `prefixSum` to store the running sum of the subarray.
// 2. At each index, add the current element to `prefixSum`.
// 3. Update `maxSum` with the maximum value between current `maxSum` and `prefixSum`.
// 4. If `prefixSum` becomes negative, reset it to 0 because a negative sum will reduce
//    the sum of any future subarray.
// 5. Continue this process for all elements and return `maxSum`.
//
// Time complexity: O(n) – single pass through the array
// Space complexity: O(1) – constant extra space used

class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int prefixSum = 0;

        for (int i = 0; i < nums.length; i++) {
            // Add current element to running sum
            prefixSum += nums[i];

            // Update maximum subarray sum
            maxSum = Math.max(maxSum, prefixSum);

            // Reset prefix sum if it becomes negative
            if (prefixSum < 0) {
                prefixSum = 0;
            }
        }

        return maxSum;
    }
}
