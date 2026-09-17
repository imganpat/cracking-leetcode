class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        int[][][] dp = new int[len][m + 1][n + 1];

        for (int i = 0; i < len; i++) {
            for (int j = 0; j <= m; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return helper(strs, 0, m, n, dp);
    }

    private int helper(
            String[] strs,
            int i,
            int m,
            int n,
            int[][][] dp
    ) {
        
        if (i == strs.length) {
            return 0;
        }

        if (dp[i][m][n] != -1) {
            return dp[i][m][n];
        }

        int zeros = 0;
        int ones = 0;

        for (char c : strs[i].toCharArray()) {
            if (c == '0') {
                zeros++;
            } else {
                ones++;
            }
        }

        if (zeros <= m && ones <= n) {
            int skip = helper(
                strs,
                i + 1,
                m,
                n,
                dp
            );

            int take = 1 + helper(
                strs,
                i + 1,
                m - zeros,
                n - ones,
                dp
            );

            return dp[i][m][n] = Math.max(skip, take);
        }

        return dp[i][m][n] = helper(
            strs,
            i + 1,
            m,
            n,
            dp
        );
    }
}