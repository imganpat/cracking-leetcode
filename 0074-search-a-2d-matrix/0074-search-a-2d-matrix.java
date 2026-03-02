class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            int l = 0;
            int r = matrix[0].length - 1;

            while (l <= r) {
                int m = l + (r - l) / 2;

                if (matrix[i][m] == target) {
                    return true;
                } else if (matrix[i][m] < target) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
        }

        return false;
    }
}