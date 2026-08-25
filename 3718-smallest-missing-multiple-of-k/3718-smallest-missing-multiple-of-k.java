class Solution {
    public int missingMultiple(int[] nums, int k) {
        boolean[] set = new boolean[101];

        for (int num : nums) {
            set[num] = true;
        }

        for (int i = 1; k * i <= 100; i++) {
            if (!set[k * i]) {
                return k * i;
            }
        }

        return k * ((100 / k) + 1);
    }
}   