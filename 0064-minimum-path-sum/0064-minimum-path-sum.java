class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m =  grid[0].length;

        int[][] dp= new int[n][m];

        for (int i =0; i < n;  i++) {
            Arrays.fill(dp[i],  -1);
        }

        return helper(grid, 0, 0, n, m, dp);
    }

    private int helper(int[][] grid,
            int i, 
            int j, 
            int n, 
            int m,
            int[][] dp
    ) {

        if (i == n  || j  ==  m) {
            return Integer.MAX_VALUE;
        }

        if (i == n - 1 && j == m - 1) {
            return grid[i][j];
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }


        int down = helper(grid, i + 1, j,n,m, dp);
        int right = helper(grid, i, j + 1 ,n,m, dp);
        
        return dp[i][j] = grid[i][j] + Math.min(down, right);
    }
}