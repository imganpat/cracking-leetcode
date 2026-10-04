class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[] maxInRows = new int[n];
        int[] maxInCols = new int[m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                maxInRows[i] = Math.max(maxInRows[i], grid[i][j]);
                maxInCols[j] = Math.max(maxInCols[j], grid[i][j]);
            }
        }

        int res = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res += Math.min(maxInRows[i], maxInCols[j]) - grid[i][j];
            }
        }

        return res;
    }
}