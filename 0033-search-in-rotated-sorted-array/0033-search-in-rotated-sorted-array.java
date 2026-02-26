class Solution {
    public int getMinIndex(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;

            if (mid >= 1 && nums[mid] < nums[mid - 1]) {
                return mid;
            }

            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    public int search(int[] nums, int target) {
        int pivot = getMinIndex(nums);
        int l1 = 0, r1 = pivot - 1;
        int l2 = pivot, r2 = nums.length - 1;

        while (l1 <= r1) {
            int m = (l1 + r1) / 2;

            if (nums[m] == target) {
                return m;
            }

            if (nums[m] > target) {
                r1 = m - 1;
            } else {
                l1 = m + 1;
            }
        }

        while (l2 <= r2) {
            int m = (l2 + r2) / 2;

            if (nums[m] == target) {
                return m;
            }

            if (nums[m] > target) {
                r2 = m - 1;
            } else {
                l2 = m + 1;
            }
        }

        return -1;
    }
}