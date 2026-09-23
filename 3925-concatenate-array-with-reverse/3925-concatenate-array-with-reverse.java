class Solution {
    public int[] concatWithReverse(int[] nums) {
        int n  = nums.length;
        int[] res = new int [2 * n];

        for (int i = 0; i < n; i++){
            res[i] = nums[i];
        }

        for (int i = n;  i < n * 2; i++) {
            res[i] = nums[2 * n - 1 - i];
        }

        return res;
    }
}