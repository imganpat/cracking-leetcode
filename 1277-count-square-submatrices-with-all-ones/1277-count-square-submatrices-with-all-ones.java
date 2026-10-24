class Solution {
    public int countSquares(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[][] dp = new int[n][m];
        int count = 0;

        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = matrix[i][j];
                count += dp[i][j];

            }
        }

        for (int i = 1; i < n; i++) {
            dp[i][0] = matrix[i][0];
            count += dp[i][0];
        }

        for (int i = 1; i < n; i++){
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] == 1) {
                    dp[i][j] = 1 +  Math.min(
                            dp[i - 1][j - 1],
                            Math.min(dp[i - 1][j], dp[i][j - 1])
                    );
                }

                count += dp[i][j];
            }
        }

        return count;
    }
}