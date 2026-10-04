class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[] maxInRows = new int[n];
        int[] maxInCols = new int[m];

        int[][] newGrid =  new int[n][m];

        for (int i = 0; i < n; i++) {
            int rm = grid[i][0];
            for  (int j = 0; j < m; j++) {
                rm = Math.max(rm, grid[i][j]);
            }
            maxInRows[i] = rm;
        }

        for (int i = 0; i < m; i++) {
            int cm = grid[0][i];
            for  (int j = 0; j < n; j++) {
                cm = Math.max(cm, grid[j][i]);
            }

            maxInCols[i] = cm;
        }

        for (int i = 0; i < n; i++) {
            for  (int j = 0; j < m; j++) {
                newGrid[i][j] = Math.min(maxInRows[i], maxInCols[j]);
            }
        }

        int res = 0;

        for (int i = 0; i < n; i++) {
            for  (int j = 0; j < m; j++) {
                res += newGrid[i][j] - grid[i][j];
            }
        }

        return res;
    }
}