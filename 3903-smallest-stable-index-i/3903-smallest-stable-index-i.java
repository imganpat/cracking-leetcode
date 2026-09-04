class Solution {
    public int firstStableIndex(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            int maxScore = getMaxScore(nums, i);
            int minScore = getMinScore(nums, i);

            if (maxScore - minScore <= k) {
                return i;
            }
        }

        return -1;
    }

    private int getMaxScore(int[] nums, int i) {
        int score = nums[i];
        for (int j = 0; j <= i; j++) {
            score = Math.max(nums[j], score);
        }

        return score;
    }

    private int getMinScore(int[] nums, int i) {
        int score = nums[i];
        for (int j = i; j < nums.length; j++) {
            score = Math.min(nums[j], score);
        }
        return score;
    }

}