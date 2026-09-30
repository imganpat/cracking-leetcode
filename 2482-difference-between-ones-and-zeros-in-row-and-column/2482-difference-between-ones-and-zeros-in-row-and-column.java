class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[] rowOnes = new int[m];
        int[] colOnes = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rowOnes[i] += grid[i][j];
                colOnes[j] += grid[i][j];
            }
        }

        int[][] diff = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int rowZeros = n - rowOnes[i];
                int colZeros = m - colOnes[j];

                diff[i][j] = rowOnes[i] + colOnes[j] - rowZeros - colZeros;
            }
        }

        return diff;
    }
}