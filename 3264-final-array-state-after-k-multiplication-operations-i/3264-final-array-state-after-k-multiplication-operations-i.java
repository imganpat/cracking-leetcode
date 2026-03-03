class Solution {
    public int getMinIndex(int[] nums) {
        int min = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[min] > nums[i]) {
                min = i;
            }
        }

        return min;
    }

    public int[] getFinalState(int[] nums, int k, int multiplier) {
        while (k > 0) {
            int i = getMinIndex(nums);
            nums[i] *= multiplier;
            k--;
        }

        return nums;
    }
}