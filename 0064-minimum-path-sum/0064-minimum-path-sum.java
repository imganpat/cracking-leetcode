class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m =  grid[0].length;

        Map<String, Integer>  dp = new HashMap<>();

        return helper(grid, 0, 0, n, m, dp);
    }

    private int helper(int[][] grid,
            int i, 
            int j, 
            int n, 
            int m,
            Map<String,Integer> dp
    ) {

        if (i == n  || j  ==  m) {
            return Integer.MAX_VALUE;
        }

        if (i == n - 1 && j == m - 1) {
            return grid[i][j];
        }

        String key = i + "," + j;
        if (dp.containsKey(key)) {
            return dp.get(key);
        }


        int down = helper(grid, i + 1, j,n,m, dp);
        int right = helper(grid, i, j + 1 ,n,m, dp);
        
        int minSum = grid[i][j] + Math.min(down, right);
        
        dp.put(key, minSum);

        return minSum;
    }
}