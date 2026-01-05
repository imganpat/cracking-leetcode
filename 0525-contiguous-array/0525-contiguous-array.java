// Approach: Prefix Sum + HashMap
// 1. Treat 0 as -1 and 1 as +1, so equal number of 0s and 1s results in sum = 0.
// 2. Maintain a running sum while traversing the array.
// 3. Use a HashMap to store the first index where each running sum occurs.
// 4. If the same sum appears again at index i, it means the subarray between
//    the previous index and i has equal number of 0s and 1s.
// 5. If sum becomes 0 at index i, then the subarray from index 0 to i is valid.
// 6. Keep updating the maximum length found.
//
// Time complexity: O(n) – single pass through the array
// Space complexity: O(n) – HashMap stores prefix sums and their first indices

class Solution {
    public int findMaxLength(int[] nums) {
        int sum = 0;   // Running sum after converting 0 → -1 and 1 → +1
        int res = 0;   // Stores maximum length found
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            // Convert 0 to -1 and 1 to +1
            if (nums[i] == 0) {
                sum--;
            } else {
                sum++;
            }

            // If sum is zero, subarray from 0 to i is valid
            if (sum == 0) {
                res = i + 1;
            }

            // If this sum was seen before, calculate subarray length
            if (map.containsKey(sum)) {
                res = Math.max(res, i - map.get(sum));
            } else {
                // Store the first occurrence of this sum
                map.put(sum, i);
            }
        }

        return res;
    }
}
