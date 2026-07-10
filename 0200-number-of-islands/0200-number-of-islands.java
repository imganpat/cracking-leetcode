// Approach: DFS (Connected Components)
// 1. Traverse every cell in the grid.
// 2. When an unvisited land cell ('1') is found:
//      - It represents a new island.
//      - Perform DFS to visit all land cells connected
//        to it in four directions.
// 3. During DFS:
//      - Mark the current cell as visited.
//      - Explore its valid neighboring land cells.
// 4. After DFS finishes, the entire island has been explored.
// 5. Continue scanning the grid for the next unvisited island.
// 6. Return the total number of islands.
//
// Time complexity: O(rows × cols)
//   - Every cell is visited at most once
// Space complexity: O(rows × cols)
//   - Visited array + recursion stack in the worst case

class Solution {
    private int rows;
    private int cols;

    // Four possible directions
    private final int[][] DIRECTIONS = {
            { -1, 0 },
            { 1, 0 },
            { 0, -1 },
            { 0, 1 }
    };

    public int numIslands(char[][] grid) {
        rows = grid.length;
        cols = grid[0].length;

        int islands = 0;

        // Visit every cell
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    islands++;
                }
            }
        }

        return islands;
    }

    private void dfs(char[][] grid, int row, int col) {
        grid[row][col] = '0';

        // Explore all four neighbors
        for (int[] dir : DIRECTIONS) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];

            if (isValid(newRow, newCol)
                    && grid[newRow][newCol] == '1') {

                dfs(grid, newRow, newCol);
            }
        }
    }

    private boolean isValid(int row, int col) {
        return row >= 0
                && row < rows
                && col >= 0
                && col < cols;
    }
}