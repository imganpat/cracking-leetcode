class Solution {
    public boolean predictTheWinner(int[] nums) {
        int diff = helper(nums, 0, nums.length - 1);
        return diff >= 0;
    }

    private int helper(int[] nums, int l, int r) {
        if (l > r) {
            return 0;
        }

        if (l == r) {
            return nums[l];
        }

        int left = nums[l] - helper(nums, l + 1, r);
        int right = nums[r] - helper(nums, l, r - 1);
        
        return Math.max(left, right);
    }
}