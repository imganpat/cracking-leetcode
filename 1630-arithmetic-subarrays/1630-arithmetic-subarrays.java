// Approach: Min–Max + HashSet (Without Sorting)
// 1. For each query (l[i], r[i]), extract the subarray from nums.
// 2. Instead of sorting, compute the minimum and maximum values of the subarray.
// 3. If all elements are equal (min == max), it is trivially an arithmetic sequence.
// 4. Check if (max - min) is divisible by (n - 1). If not, an arithmetic sequence is impossible.
// 5. Compute the common difference d = (max - min) / (n - 1).
// 6. Use a HashSet to verify that all expected values
//    (min, min + d, min + 2d, ..., max) exist in the subarray.
// 7. If any required value is missing, return false; otherwise, return true.
// 8. Store the result for each query and return the final list.
//
// Time complexity: O(q * k)
//   - q = number of queries
//   - k = length of each subarray
// Space complexity: O(k)
//   - HashSet used for each subarray

class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> res = new ArrayList<>();

        // Process each query
        for (int i = 0; i < l.length; i++) {
            List<Integer> subArray = new ArrayList<>();

            // Extract subarray
            for (int j = l[i]; j <= r[i]; j++) {
                subArray.add(nums[j]);
            }

            // Check if subarray forms arithmetic sequence
            res.add(check(subArray));
        }

        return res;
    }

    public boolean check(List<Integer> arr) {
        int n = arr.size();
        if (n < 2) {
            return true;
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        Set<Integer> set = new HashSet<>();

        for (int val : arr) {
            min = Math.min(val, min);
            max = Math.max(val, max);
            set.add(val);
        }

        if (min == max) {
            return true;
        }

        if ((max - min) % (n - 1) != 0) {
            return false;
        }

        int d = (max - min) / (n - 1);
        int curr = min + d;
        while (curr < max) {
            if (!set.contains(curr)) {
                return false;
            }
            curr += d;
        }

        return true;
    }
}
