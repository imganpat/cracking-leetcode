class Solution {
    private int rows;
    private int cols;

    private final int[][] DIRECTIONS = new int[][] {
            { 1, 0 },
            { -1, 0 },
            { 0, 1 },
            { 0, -1 }
    };

    public int countIslands(int[][] grid, int k) {
        rows = grid.length;
        cols = grid[0].length;

        int count = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] != 0) {
                    long sum = dfs(grid, i, j);

                    if (sum % k == 0) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    private long dfs(int[][] grid, int i, int j) {
        long sum = grid[i][j];

        grid[i][j] = 0;

        for (int[] dir : DIRECTIONS) {
            int newRow = i + dir[0];
            int newCol = j + dir[1];

            if (isValid(newRow, newCol)
                    && grid[newRow][newCol] != 0) {
                sum += dfs(grid, newRow, newCol);
            }
        }

        return sum;
    }

    private boolean isValid(int row, int col) {
        return row >= 0
                && row < rows
                && col >= 0
                && col < cols;
    }
}