class SubrectangleQueries {
    int[][] r;
    public SubrectangleQueries(int[][] rectangle) {
        int n = rectangle.length;
        int m = rectangle[0].length;
        r = new int[rectangle.length][rectangle[0].length];

        for (int i = 0; i < n;  i++) {
            for (int j = 0; j < m; j++) {
                r[i][j] = rectangle[i][j];
            }
        }
    }
    
    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        for (int i = row1; i <= row2; i++) {
            for (int j = col1; j <= col2; j++) {
                r[i][j] = newValue;
            }
        }
    }
    
    public int getValue(int row, int col) {
        return r[row][col];
    }
}

/**
 * Your SubrectangleQueries object will be instantiated and called as such:
 * SubrectangleQueries obj = new SubrectangleQueries(rectangle);
 * obj.updateSubrectangle(row1,col1,row2,col2,newValue);
 * int param_2 = obj.getValue(row,col);
 */