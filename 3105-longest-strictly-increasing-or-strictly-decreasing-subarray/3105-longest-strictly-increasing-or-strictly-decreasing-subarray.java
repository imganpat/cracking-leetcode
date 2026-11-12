
class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int increasing = 1;
        int decreasing = 1;
        int maxLength = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                increasing++;
                decreasing = 1;
            } 
            else if (nums[i] < nums[i - 1]) {
                decreasing++;
                increasing = 1;
            } 
            else {
                increasing = 1;
                decreasing = 1;
            }

            maxLength = Math.max(maxLength,
                    Math.max(increasing, decreasing));
        }

        return maxLength;
    }
}
