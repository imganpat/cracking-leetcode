class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp  = new int[coins.length][amount + 1];
        
        for (int i = 0; i < coins.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        

        int res =  helper(
                coins,
                0,
                amount,
                dp);

        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private int helper(int[] coins,
            int i,
            int remainingAmount,
            int[][] dp
    ) {
        if (remainingAmount == 0) {
            return 0;
        }

        if (i == coins.length || remainingAmount < 0) {
            return Integer.MAX_VALUE;
        }

        if (dp[i][remainingAmount] !=  -1) {
            return dp[i][remainingAmount];
        }

        int take = helper(
                coins,
                i,
                remainingAmount - coins[i],
                dp
            );

        if (take != Integer.MAX_VALUE) {
            take++;  
        }

        int skip = helper(
                coins,
                i + 1,
                remainingAmount,
                dp
            );

        return dp[i][remainingAmount] = Math.min(
                skip,
                take);
    }
}