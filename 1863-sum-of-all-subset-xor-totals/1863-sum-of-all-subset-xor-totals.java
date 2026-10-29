class Solution {
    public int subsetXORSum(int[] nums) {
        return recursion(nums, 0, 0);
    }

    private int recursion(int[] nums, int i, int xor) {
        if (i == nums.length) {
            return xor;
        }

        int take = recursion(nums, i + 1, xor ^ nums[i]);

        int skip = recursion(nums, i + 1, xor);

        return take + skip;
    }
}