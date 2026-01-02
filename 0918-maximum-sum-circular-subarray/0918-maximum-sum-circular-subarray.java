class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int maxSum = nums[0];
        int minSum = nums[0];
        int totalSum = nums[0];
        int cMin = nums[0];
        int cMax = nums[0];

        for (int i = 1; i < nums.length; i++) {
            cMin = Math.min(cMin + nums[i], nums[i]);
            cMax = Math.max(cMax + nums[i], nums[i]);

            minSum = Math.min(minSum, cMin);
            maxSum = Math.max(maxSum, cMax);
            
            totalSum += nums[i];
        }

        if (maxSum < 0) {
            return maxSum;
        }

        return Math.max(maxSum, totalSum - minSum);

    }
}