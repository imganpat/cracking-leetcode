class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        int[][] dp = new int[n][2];

        for (int i  = 0; i <  n; i++) {
            Arrays.fill(dp[i],  -1);
        }

        return helper(nums, 0, dp, false);
    }

    private int helper(int[] nums, int i, int[][]dp, boolean prevRobbed) {
        if (i >= nums.length) {
            return 0;
        }

        int flag = prevRobbed ? 1 : 0;

        if (dp[i][flag] != -1) {
            return dp[i][flag];
        }

        if (prevRobbed) {
            int skip = helper(nums, i + 1,  dp, !prevRobbed);
            dp[i][flag] = skip;
            return skip;
        }

        int c1 = nums[i] + helper(nums, i  +  1, dp, !prevRobbed);
        int c2 = helper(nums, i  +  1, dp, prevRobbed);
        int t = Math.max(c1, c2);
        return t; 
    }
}