class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char select = board[i][j];

                if (select == '.') {
                    continue;
                }

                for (int c = 0; c < 9; c++) {
                    if (c == j) {
                        continue;
                    }

                    if (board[i][c] == select) {
                        return false;
                    }
                }

                for (int r = 0; r < 9; r++) {
                    if (r == i) {
                        continue;
                    }

                    if (board[r][j] == select) {
                        return false;
                    }
                }

                int sr = (i / 3) * 3;
                int sc = (j / 3) * 3;

                for (int r = sr; r < sr + 3; r++) {
                    for (int c = sc; c < sc + 3; c++) {
                        if (r == i && c == j) {
                            continue;
                        }

                        if (board[r][c] == select) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}