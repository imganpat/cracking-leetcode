class Solution {
    public long maximumProduct(int[] nums, int m) {
        long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;
        long res = Long.MIN_VALUE;

        for (int i = m - 1; i < nums.length; i++) {
            int index = i - m + 1;

            min = Math.min(nums[index], min);
            max = Math.max(nums[index], max);

            res = Math.max(1L * nums[i] * min, res);
            res = Math.max(1L * nums[i] * max, res);
        }

        return res;
    }
}
