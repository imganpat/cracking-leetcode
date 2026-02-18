class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int start = 0;
        int end = 0;
        int minSum = Integer.MAX_VALUE;
        int sum = 0;
        int totalSum = 0;
        for (int x : cardPoints)
            totalSum += x;
        while (end < n) {
            sum += cardPoints[end];
            while (end - start + 1 > n - k) {
                sum -= cardPoints[start];
                start++;
            }

            if (end - start + 1 == n - k) {
                minSum = Math.min(sum, minSum);
            }

            end++;
        }

        return totalSum - minSum;
    }
}