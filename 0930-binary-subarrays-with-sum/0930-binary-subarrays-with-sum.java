class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int subArrayCount = 0;
        int prefixSum = 0;
        Map<Integer, Integer> prefixFreq = new HashMap<>();

        prefixFreq.put(0, 1);

        for (int n : nums) {
            prefixSum += n;

            int neededSum = prefixSum - goal;
            if (prefixFreq.containsKey(neededSum)) {
                subArrayCount += prefixFreq.get(neededSum);
            }

            prefixFreq.put(prefixSum, prefixFreq.getOrDefault(prefixSum, 0) + 1);
        }

        return subArrayCount;
    }
}