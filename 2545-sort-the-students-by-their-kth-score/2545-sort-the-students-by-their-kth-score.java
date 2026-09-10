class Solution {
    public int[][] sortTheStudents(int[][] score, int k) {
        for (int  i = 0; i < score.length; i++) {
            for (int j = 1; j < score.length - i; j++) {
                if (score[j - 1][k] < score[j][k]) {
                    swap(score, j - 1, j);
                }
            }
        }

        return score;
    }

    private void swap(int[][] score,  int i, int j) {
        int[] temp = score[i];
        score[i] = score[j];
        score[j] = temp;
    }
}