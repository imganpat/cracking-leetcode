class Solution {
    public int orangesRotting(int[][] grid) {
        int freshOranges = 0;
        Deque<int[]> activeRottenOranges = new ArrayDeque<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    activeRottenOranges.offer(new int[]{i, j});
                }

                if (grid[i][j] == 1) {
                    freshOranges++;
                }
            }
        }


        int minutes = 0;
        int[][] directions = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0 , 1}};
        while (!activeRottenOranges.isEmpty() && freshOranges > 0) {
            minutes++;

            int s = activeRottenOranges.size();
            for (int i = 0; i < s; i++) {
                int[] node = activeRottenOranges.pop();

                for(int d = 0; d < directions.length; d++) {
                    int r = node[0] + directions[d][0];
                    int c = node[1] + directions[d][1];

                    if (isValid(grid.length, grid[0].length, r, c) && grid[r][c] == 1) {
                        grid[r][c] = 2;
                        activeRottenOranges.offer(new int[] {r, c});
                        freshOranges--;
                    }

                }
            }
        }

        return freshOranges > 0 ? -1 : minutes;
    }

    private boolean isValid(int m, int n, int r, int c) {
        return r >= 0 && r < m && c>= 0 && c < n;
    }
}