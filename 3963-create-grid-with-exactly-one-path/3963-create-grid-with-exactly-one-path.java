class Solution {
    public String[] createGrid(int m, int n) {
        String[] res = new String[m];
        char[][] matrix = new char[m][n];

        for (int j = 0; j < n ; j++) {
            matrix[0][j] = '.';
        }

        for (int i = 0; i < m ; i++) {
            matrix[i][n - 1] = '.';
        }

        for (int i = 0; i < m; i++)  {
            StringBuilder s = new StringBuilder();
            
            for (int j = 0; j < n; j++) {
                s.append(matrix[i][j] != '.' ? '#' : '.');   
            }

            res[i] = (s.toString());
        }

        return res;
    }
}