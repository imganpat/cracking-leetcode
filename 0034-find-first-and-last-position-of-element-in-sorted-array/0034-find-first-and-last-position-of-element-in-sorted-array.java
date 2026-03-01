class Solution {
    public int findFirstIndex(int nums[], int target) {
        int l = 0;
        int h = nums.length - 1;
        int res = -1;

        while (l <= h) {
            int m = l + (h - l) / 2;

            if (nums[m] == target) {
                res = m;
                h = m - 1;
            } else if (nums[m] < target) {
                l = m + 1;
            } else {
                h = m - 1;
            }

        }

        return res;
    }

    public int findLastIndex(int nums[], int target) {
        int l = 0;
        int h = nums.length - 1;
        int res = -1;

        while (l <= h) {
            int m = l + (h - l) / 2;

            if (nums[m] == target) {
                res = m;
                l = m + 1;
            } else if (nums[m] < target) {
                l = m + 1;
            } else {
                h = m - 1;
            }
        }

        return res;
    }

    public int[] searchRange(int[] nums, int target) {
        return new int[] { findFirstIndex(nums, target), findLastIndex(nums, target) };
    }
}