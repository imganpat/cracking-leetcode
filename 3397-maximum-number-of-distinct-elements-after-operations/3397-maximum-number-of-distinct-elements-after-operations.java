class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);

        int count = 0;
        int prev = Integer.MIN_VALUE;

        for (int num: nums) {
            int start = num - k;
            int end = num + k;

            int choice = Math.max(prev + 1, start);

            if (choice <= end) {
                count++;
                prev = choice;
            }
        }

        return count;
    }
}