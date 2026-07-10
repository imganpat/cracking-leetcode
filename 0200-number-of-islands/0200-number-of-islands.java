class Solution {
    int [] dirX = { -1, 1, 0 , 0 };
    int [] dirY = { 0, 0, -1, 1 };
    

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int islands = 0;
        int r, c;
        boolean[][] visited = new boolean [m][n];

        for (int i = 0; i < m; i++ ) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    dfs(grid, m, n, i, j, visited);
                    islands++;
                }
            }
        }
        return islands;
    }

    public void dfs(char[][]grid, int m, int n, int r, int c, boolean[][] visited) {
        visited[r][c] = true;

        for (int i = 0; i < dirX.length; i++) {
            int row = r + dirX[i];
            int col = c + dirY[i];

            if (isValid(row, col, m , n) && grid[row][col] == '1' && !visited[row][col]) {
                 dfs(grid, m, n, row, col, visited);
            }
        }
        return;
    }

    public boolean isValid(int row, int col, int m, int n) {
        if (row < 0 || row >= m || col < 0 || col >= n) {
            return false;
        }
        return true;
    }
}