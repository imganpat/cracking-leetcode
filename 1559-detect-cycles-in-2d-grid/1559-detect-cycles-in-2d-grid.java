class Solution {
    int[][] DIRECTIONS = new int[][] { { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 } };
    boolean[][] visited;

    public boolean containsCycle(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    if (dfs(grid, i, j, -1, -1)) {
                        return true;
                    }
                }
            }
        }

        return false;

    }

    private boolean dfs(char[][] grid, int row, int col, int prevRow, int prevCol) {
        visited[row][col] = true;

        for (int[] direction : DIRECTIONS) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];

            if (!isValid(grid.length, grid[0].length, newRow, newCol)
                    || grid[row][col] != grid[newRow][newCol]) {
                continue;
            }

            if (newRow == prevRow && newCol == prevCol) {
                continue;
            }

            if (visited[newRow][newCol]) {
                return true;
            }

            if (dfs(grid, newRow, newCol, row, col)) {
                return true;
            }
        }

        return false;
    }

    private boolean isValid(int m, int n, int row, int col) {
        return row >= 0 && row < m && col >= 0 && col < n;
    }
}