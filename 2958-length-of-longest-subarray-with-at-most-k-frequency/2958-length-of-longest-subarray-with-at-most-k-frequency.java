class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        Map<Integer, Integer> map = new HashMap<>();

        for (int s = 0, e = 0; e < nums.length; e++) {
            map.put(nums[e], map.getOrDefault(nums[e], 0) + 1);

            while (map.get(nums[e]) > k) {
                map.put(nums[s], map.get(nums[s]) - 1);
                if (map.get(nums[s]) == 0) {
                    map.remove(nums[s]);
                }
                s++;

            }
            max = Math.max(max, e - s + 1);
        }
        return max;
    }
}