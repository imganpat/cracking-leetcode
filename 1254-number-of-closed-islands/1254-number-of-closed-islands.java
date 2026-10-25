class Solution {
    int[][] DIRECTIONS = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < n; i++) {
            if (grid[0][i] == 0) {
                dfs(grid, 0, i);
            }

            if (grid[m - 1][i] == 0) {
                dfs(grid, m - 1, i);
            }
        } 
        
        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 0) {
                dfs(grid, i, 0);
            }

            if (grid[i][n - 1] == 0) {
                dfs(grid, i, n - 1);
            }
        }


        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }

        return count;
    }


    private void dfs(int[][] grid, int row, int col) {
        grid[row][col] = 1;

        for (int[] direction: DIRECTIONS) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];

            if (isValid(grid.length, grid[0].length, newRow, newCol) 
                    && grid[newRow][newCol] == 0) {
                        dfs(grid, newRow, newCol);
            }
        }
    }


    private boolean isValid(int rows, int cols, int row, int col) {
        return row >= 0
                && row < rows
                && col >= 0
                && col < cols;
    }
}