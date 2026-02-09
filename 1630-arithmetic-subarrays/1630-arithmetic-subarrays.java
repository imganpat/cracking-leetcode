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
        // Sort the subarray
        Collections.sort(arr);

        // Compute common difference
        int d = arr.get(1) - arr.get(0);

        // Verify all consecutive differences
        for (int i = 2; i < arr.size(); i++) {
            if (arr.get(i) - arr.get(i - 1) != d) {
                return false;
            }
        }

        return true;
    }
}
