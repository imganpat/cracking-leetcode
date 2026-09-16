// Approach: Use recursion to decide whether to take or skip each element.
//
// At every index, we track the previous selected element.
// If the current element is greater than the previous selected element,
// we have two choices:
//
// 1. Skip the current element.
// 2. Take the current element and continue.
//
// Memoization avoids recalculating the same (index, previous index) state.
//
// Time complexity: O(n²)
// Space complexity: O(n²)

class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        // dp[i][prev + 1] stores the LIS length starting from index i,
        // where prev is the index of the previously selected element.
        //
        // prev can be -1, so we use prev + 1 as the DP column:
        //
        // prev = -1 -> column 0
        // prev = 0  -> column 1
        // prev = 1  -> column 2
        // ...
        int[][] dp = new int[n][n + 1];

        // -1 means this state has not been calculated yet.
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        // Start from index 0.
        // No element has been selected before, so prev = -1.
        return helper(nums, 0, -1, dp);
    }

    private int helper(
        int[] nums,
        int i,
        int prev,
        int[][] dp
    ) {

        // We have processed every element.
        if (i == nums.length) {
            return 0;
        }

        // Convert prev into a valid DP column.
        int prevIndex = prev + 1;

        // Return the already calculated answer for this state.
        if (dp[i][prevIndex] != -1) {
            return dp[i][prevIndex];
        }

        // If there is no previous element selected,
        // or the current element is greater than the previous selected element,
        // we can choose the current element.
        if (prev == -1 || nums[i] > nums[prev]) {

            // Choice 1: Skip the current element.
            int skip = helper(
                nums,
                i + 1,
                prev,
                dp
            );

            // Choice 2: Take the current element.
            //
            // The current element becomes the new previous element.
            int take = 1 + helper(
                nums,
                i + 1,
                i,
                dp
            );

            // Store the better choice.
            return dp[i][prevIndex] = Math.max(skip, take);
        }

        // If nums[i] is not greater than nums[prev],
        // we cannot take it.
        //
        // Therefore, we must skip it.
        return dp[i][prevIndex] = helper(
            nums,
            i + 1,
            prev,
            dp
        );
    }
}