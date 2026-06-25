class Solution {
    public long maximumProduct(int[] nums, int m) {
        int n = nums.length;
        long ans = Long.MIN_VALUE;

        long maxStart = Long.MIN_VALUE;
        long minStart = Long.MAX_VALUE;

        for (int j = m - 1; j < n; j++) {
            int startIdx = j - m + 1;

            maxStart = Math.max(maxStart, nums[startIdx]);
            minStart = Math.min(minStart, nums[startIdx]);

            ans = Math.max(ans, maxStart * nums[j]);
            ans = Math.max(ans, minStart * nums[j]);
        }

        return ans;
    }
}