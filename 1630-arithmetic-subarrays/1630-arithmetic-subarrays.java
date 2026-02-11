// Approach: Extract Subarray + Sort + Check Arithmetic Property
// 1. For each query (l[i], r[i]):
//    - Extract the subarray from nums between indices l[i] and r[i].
// 2. Sort the extracted subarray.
// 3. Check if the sorted subarray forms an arithmetic sequence:
//    - Compute the common difference using the first two elements.
//    - Verify that the difference between every consecutive pair remains the same.
// 4. Store true/false result for each query in the result list.
// 5. Return the list of boolean results.
//
// Time complexity: O(q * k log k)
//   - q = number of queries
//   - k = length of each subarray (sorting dominates)
// Space complexity: O(k)
//   - Temporary list created for each query

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
