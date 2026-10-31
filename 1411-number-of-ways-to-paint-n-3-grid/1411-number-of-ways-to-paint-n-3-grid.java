class Solution {
    int mod = 1_000_000_007;

    public int numOfWays(int n) {
        int[][][][] dp = new int[n][4][4][4];
        for (int[][][] a : dp) {
            for (int[][] b : a) {
                for (int[] c : b) {
                    Arrays.fill(c, -1);
                }
            }
        }

        return helper(n, 0, -1, -1, -1, dp);
    }

    private int helper(int n,
            int i,
            int prev1,
            int prev2,
            int prev3,
            int[][][][] dp) {

        if (i == n) {
            return 1;
        }

        if (dp[i][prev1 + 1][prev2 + 1][prev3 + 1] != -1) {
            return dp[i][prev1 + 1][prev2 + 1][prev3 + 1];
        }

        int ans = 0;

        for (int c1 = 0; c1 < 3; c1++) {
            for (int c2 = 0; c2 < 3; c2++) {
                for (int c3 = 0; c3 < 3; c3++) {
                    if (isValid(prev1, prev2, prev3, c1, c2, c3)) {
                        ans = (ans + helper(n, i + 1, c1, c2, c3, dp)) % mod;
                    }
                }
            }
        }

        return dp[i][prev1 + 1][prev2 + 1][prev3 + 1] = ans;

    }

    private boolean isValid(int prev1,
            int prev2,
            int prev3,
            int c1,
            int c2,
            int c3) {

        return c1 != c2 &&
                c2 != c3 &&
                c1 != prev1 &&
                c2 != prev2 &&
                c3 != prev3;
    }
}