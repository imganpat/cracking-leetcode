class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        // dp[i][0] -> maximum money from index i when previous house
        //              was NOT robbed
        //
        // dp[i][1] -> maximum money from index i when previous house
        //              WAS robbed
        int[][] dp = new int[n][2];

        // -1 means this state has not been calculated yet
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        // Start from house 0.
        // Initially, there is no previous house robbed.
        return helper(nums, 0, dp, false);
    }

    private int helper(
            int[] nums,
            int i,
            int[][] dp,
            boolean prevRobbed) {

        // No houses left
        if (i >= nums.length) {
            return 0;
        }

        // Convert boolean state into array index
        // false -> 0
        // true  -> 1
        int flag = prevRobbed ? 1 : 0;

        // Already calculated this state
        if (dp[i][flag] != -1) {
            return dp[i][flag];
        }

        // If previous house was robbed,
        // we CANNOT rob current house.
        if (prevRobbed) {

            // Must skip current house.
            int skip = helper(
                    nums,
                    i + 1,
                    dp,
                    !prevRobbed);

            dp[i][flag] = skip;

            return skip;
        }

        // Option 1: Rob current house
        //
        // Since we rob current house,
        // next house knows that previous house was robbed.
        int c1 = nums[i] +
                helper(nums, i + 1, dp, !prevRobbed);

        // Option 2: Skip current house
        //
        // Since current house wasn't robbed,
        // next house knows previous house was NOT robbed.
        int c2 = helper(
                nums,
                i + 1,
                dp,
                prevRobbed);

        // Choose the better option
        int t = Math.max(c1, c2);

        // IMPORTANT:
        // You forgot this in your code.
        dp[i][flag] = t;

        return t;
    }
}