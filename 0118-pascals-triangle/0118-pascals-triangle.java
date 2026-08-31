class Solution {
    public List<List<Integer>> generate(int numRows) {
        int[][] res = new int[numRows][numRows];

        for (int i = 0; i < numRows; i++) {
            res[i][0] = 1;
            res[i][i] = 1;

            for (int j = 1; j < i; j++) {
                res[i][j] = res[i - 1][j - 1] + res[i -1][j];
            }
        }

        List<List<Integer>> tri = new ArrayList<>();

        for (int i = 0; i < res.length; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < res[i].length; j++) {
                if (res[i][j] != 0) {
                    row.add(res[i][j]);
                }
            }
            tri.add(row);
        }

        return tri;
    }
}