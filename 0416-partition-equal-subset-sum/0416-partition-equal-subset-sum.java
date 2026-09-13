class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 != 0) {
            return false;
        }

        int target = sum / 2;
        int[][] dp = new int[nums.length][target + 1];

        for  (int i = 0; i < nums.length; i++) {
            Arrays.fill(dp[i], - 1);
        }

        return helper(nums, 0, target, dp);
    }

    private boolean helper(int[] nums, int i, int sum, int[][]  dp) {
        if (i == nums.length) {
            if (sum == 0) {
                return true;
            }
            return false;
        }

        if (dp[i][sum] != -1) {
            return dp[i][sum] == 1;
        }

        if  (nums[i] > sum) {
            boolean res = helper (nums, i + 1, sum, dp);
            dp[i][sum] = res ? 1 : 0;
            return res;
        }

        boolean c1 = helper(nums, i + 1, sum, dp);
        boolean c2 = helper(nums, i + 1, sum - nums[i], dp);

        boolean res= c1 || c2;
        dp[i][sum] = (res)  ?  1 : 0;

        return res;
    }
}