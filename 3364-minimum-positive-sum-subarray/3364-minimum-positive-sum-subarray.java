class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int minSum = Integer.MAX_VALUE;
        int n = nums.size();

        for (int k = l; k <= r; k++) {
            int start = 0;
            int end = 0;
            int sum = 0;

            while (end < n) {
                sum += nums.get(end);

                while (end - start + 1 > k) {
                    sum -= nums.get(start);
                    start++;
                }

                if (end - start + 1 == k && sum > 0) {
                    minSum = Math.min(sum, minSum);
                }

                end++;
            }
        }

        return minSum == Integer.MAX_VALUE ? -1 : minSum;
    }
}