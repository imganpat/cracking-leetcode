class Solution {
    public int maxProduct(int[] nums) {
        int prefix = 1;
        int suffix = 1;
        int res = nums[0];
        for (int i = 0, j = nums.length - 1; i < nums.length; i++, j--) {
            if (prefix == 0) {
                prefix = 1;
            }
            if (suffix == 0) {
                suffix = 1;
            }
            prefix *= nums[i];
            suffix *= nums[j];

            res = Math.max(res, Math.max(prefix, suffix));

        }

        return res;
    }
}