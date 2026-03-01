class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int i = 0;
        int j = n - 1;

        while (i < n - 1 && nums[i] != target) {
            i++;
        }

        while (j >= 0 && nums[j] != target) {
            j--;
        }

        if (i > j) {
            i = -1;
            j = -1;
        }

        return new int[] { i, j };
    }
}