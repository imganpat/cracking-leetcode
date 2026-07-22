class Solution {
    public int[] findDegrees(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] degrees = new int[m];

        for (int i = 0; i < m; i++) {
            int degree = 0;
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    degree++;
                }
            }

            degrees[i] = degree;
        }

        return degrees;
    }
}