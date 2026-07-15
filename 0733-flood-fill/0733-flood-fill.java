class Solution {
    int[][] directions = new int[][] { { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 } };

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int change = image[sr][sc];

        if (change == color) {
            return image;
        }

        dfs(image, change, color, sr, sc);

        return image;
    }

    private void dfs(int[][] image, int change, int color, int row, int col) {
        image[row][col] = color;

        for (int[] direction : directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];

            if (isValid(image.length, image[0].length, newRow, newCol) 
                    && image[newRow][newCol] == change) {
                dfs(image, change, color, newRow, newCol);
            }
        }
    }

    private boolean isValid(int m, int n, int row, int col) {
        return row >= 0 && row < m && col >= 0 && col < n;
    }
}