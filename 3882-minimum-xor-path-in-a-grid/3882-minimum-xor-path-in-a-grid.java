class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][][] dp = new int[m][n][1024];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return helper(grid, 0, 0, 0, dp);
    }

    private int helper(int[][] grid,
            int row,
            int col,
            int xor,
            int[][][] dp) {

        int m = grid.length;
        int n = grid[0].length;

        if (row >= m || col >= n) {
            return Integer.MAX_VALUE;
        }

        xor ^= grid[row][col];

        if (row == m - 1 && col == n - 1) {
            return xor;
        }

        if (dp[row][col][xor] != -1) {
            return dp[row][col][xor];
        }

        int right = helper(grid, row, col + 1, xor, dp);
        int down = helper(grid, row + 1, col, xor, dp);

        return dp[row][col][xor] = Math.min(right, down);
    }
}