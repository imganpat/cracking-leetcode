class Solution {
    private int rows;
    private int cols;
    private boolean[][] visited;

    private final int[][] DIRECTIONS = {
            { -1, 0 },
            { 1, 0 },
            { 0, -1 },
            { 0, 1 }
    };

    public int numIslands(char[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        visited = new boolean[rows][cols];

        int islands = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    dfs(grid, i, j);
                    islands++;
                }
            }
        }

        return islands;

    }

    private void dfs(char[][] grid, int row, int col) {
        visited[row][col] = true;

        for (int[] dir : DIRECTIONS) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];

            if (isValid(newRow, newCol)
                    && grid[newRow][newCol] == '1'
                    && !visited[newRow][newCol]) {

                dfs(grid, newRow, newCol);
            }
        }
    }

    private boolean isValid(int row, int col) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }
}