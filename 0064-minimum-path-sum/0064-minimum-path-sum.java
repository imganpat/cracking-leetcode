class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        // dp[i][j] stores the minimum path sum
        // from cell (i, j) to the bottom-right cell.
        int[][] dp = new int[n][m];

        // -1 means this state has not been calculated yet.
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        // Start from the top-left cell.
        return helper(grid, 0, 0, n, m, dp);
    }

    private int helper(
        int[][] grid,
        int i,
        int j,
        int n,
        int m,
        int[][] dp
    ) {

        // We moved outside the grid.
        //
        // This path is invalid, so return a very large value.
        // That way, Math.min() will never choose this path.
        if (i == n || j == m) {
            return Integer.MAX_VALUE;
        }

        // We reached the bottom-right cell.
        // Its path sum is simply its own value.
        if (i == n - 1 && j == m - 1) {
            return grid[i][j];
        }

        // Return the already calculated answer for this cell.
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        // Option 1: Move down.
        int down = helper(
            grid,
            i + 1,
            j,
            n,
            m,
            dp
        );

        // Option 2: Move right.
        int right = helper(
            grid,
            i,
            j + 1,
            n,
            m,
            dp
        );

        // Current cell cost + minimum of the two possible paths.
        dp[i][j] = grid[i][j] + Math.min(down, right);

        return dp[i][j];
    }
}