class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int max [] = {0,0};

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if ( mat[max[0]][max[1]] < mat[i][j]) {
                    max[0] = i;
                    max[1] = j;
                }
            }
        }

        return max;
    }
}