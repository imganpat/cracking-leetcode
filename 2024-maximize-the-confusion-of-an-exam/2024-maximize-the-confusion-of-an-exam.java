class Solution {
    public int maxAnswer(String answer, int k, char target) {
        int start = 0;
        int end = 0;
        int res = 0;
        int flips = 0;

        while (end < answer.length()) {
            if (answer.charAt(end) != target) {
                flips++;
            }

            while (flips > k) {
                if (answer.charAt(start) != target) {
                    flips--;
                }
                start++;

            }
            res = Math.max(end - start + 1, res);
            end++;
        }
        return res;

    }

    public int maxConsecutiveAnswers(String answerKey, int k) {
        return Math.max(maxAnswer(answerKey, k, 'T'), maxAnswer(answerKey, k, 'F'));
    }
}