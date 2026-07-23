class Solution {
    int[][] DIRECTIONS = { { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 } };
    boolean[][] visited;

    public int countBattleships(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        visited = new boolean[n][m];
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'X' && !visited[i][j]) {
                    dfs(board, i, j);
                    count++;
                }
            }
        }

        return count;
    }

    private void dfs(char[][] board, int row, int col) {

        if (!isValid(board.length, board[0].length, row, col))
            return;

        if (visited[row][col])
            return;

        if (board[row][col] == '.')
            return;

        visited[row][col] = true;

        for (int[] direction : DIRECTIONS) {
            dfs(board, row + direction[0], col + direction[1]);
        }
    }

    private boolean isValid(int n, int m, int row, int col) {
        return row >= 0 && row < n && col >= 0 && col < m;
    }
}