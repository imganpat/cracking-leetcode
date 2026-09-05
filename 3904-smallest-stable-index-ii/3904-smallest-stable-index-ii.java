class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int[] minSuffix = new int[nums.length];
        int[] maxPrefix = new int[nums.length];

        maxPrefix[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            maxPrefix[i] = Math.max(maxPrefix[i - 1], nums[i]);
        }

        minSuffix[nums.length - 1] = nums[nums.length - 1];

        for (int i = nums.length - 2; i >= 0; i--) {
            minSuffix[i] = Math.min(minSuffix[i  + 1] ,nums[i]);
        }

        for (int i = 0; i < nums.length; i++) {
            int maxScore = maxPrefix[i];
            int minScore = minSuffix[i];

            if (maxScore - minScore <= k) {
                return i;
            }
        }

        return -1;
    }
}