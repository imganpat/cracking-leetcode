class Solution {
    public int minMoves(int[] nums) {
        int moves = 0;
        int maxIndex = getMaxIndex(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i != maxIndex && nums[i] != nums[maxIndex]) {
                moves += nums[maxIndex] - nums[i];
            }
        }

        return moves;
    }

    private int getMaxIndex(int[] nums) {
        int maxIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }

        return maxIndex;
    }
}