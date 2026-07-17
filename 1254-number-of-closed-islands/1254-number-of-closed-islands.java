// Approach: DFS + Eliminate Boundary Islands
// 1. A closed island is a land region (0's)
//    that is completely surrounded by water (1's).
// 2. First, remove every island connected to the boundary:
//      - Traverse the first and last rows.
//      - Traverse the first and last columns.
//      - For every boundary land cell (0),
//        perform DFS and mark the entire island as water.
// 3. After boundary-connected islands are removed,
//    every remaining island is guaranteed to be closed.
// 4. Traverse the entire grid:
//      - Whenever an unvisited land cell (0) is found,
//        perform DFS to mark the whole island.
//      - Increment the closed island count.
// 5. Return the total count.
//
// Time complexity: O(m × n)
//   - Every cell is visited at most once
// Space complexity: O(m × n)
//   - Recursion stack in the worst case

class Solution {

    // Four possible directions
    int[][] DIRECTIONS = {
            { 1, 0 },
            { -1, 0 },
            { 0, 1 },
            { 0, -1 }
    };

    public int closedIsland(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        // Remove islands touching top and bottom boundaries
        for (int i = 0; i < n; i++) {

            if (grid[0][i] == 0) {
                dfs(grid, 0, i);
            }

            if (grid[m - 1][i] == 0) {
                dfs(grid, m - 1, i);
            }
        }

        // Remove islands touching left and right boundaries
        for (int i = 0; i < m; i++) {

            if (grid[i][0] == 0) {
                dfs(grid, i, 0);
            }

            if (grid[i][n - 1] == 0) {
                dfs(grid, i, n - 1);
            }
        }

        int count = 0;

        // Count remaining closed islands
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

    private void dfs(int[][] grid,
                     int row,
                     int col) {

        // Mark visited
        grid[row][col] = 1;

        for (int[] direction : DIRECTIONS) {

            int newRow = row + direction[0];
            int newCol = col + direction[1];

            if (isValid(grid.length,
                        grid[0].length,
                        newRow,
                        newCol)
                    && grid[newRow][newCol] == 0) {

                dfs(grid, newRow, newCol);
            }
        }
    }

    private boolean isValid(int rows,
                            int cols,
                            int row,
                            int col) {

        return row >= 0 &&
               row < rows &&
               col >= 0 &&
               col < cols;
    }
}