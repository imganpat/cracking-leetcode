class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // dp[row][col][xor] stores the minimum result
        // from this cell onward, given the current XOR state.
        int[][][] dp = new int[m][n][1024];

        // -1 means the state has not been calculated yet.
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        // Start at the top-left with XOR = 0.
        return helper(grid, 0, 0, 0, dp);
    }

    private int helper(
        int[][] grid,
        int row,
        int col,
        int xor,
        int[][][] dp
    ) {
        int m = grid.length;
        int n = grid[0].length;

        // Invalid path: outside the grid.
        if (row >= m || col >= n) {
            return Integer.MAX_VALUE;
        }

        // Include the current cell in the path XOR.
        xor ^= grid[row][col];

        // Destination reached: return the final XOR.
        if (row == m - 1 && col == n - 1) {
            return xor;
        }

        // Reuse the answer for this (row, col, xor) state.
        if (dp[row][col][xor] != -1) {
            return dp[row][col][xor];
        }

        // Explore both allowed moves.
        int right = helper(grid, row, col + 1, xor, dp);
        int down = helper(grid, row + 1, col, xor, dp);

        // Choose the smaller final XOR.
        return dp[row][col][xor] = Math.min(right, down);
    }
}