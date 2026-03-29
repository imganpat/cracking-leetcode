// Approach: Backtracking (Include / Exclude) + Bitwise OR
// 1. First compute the maximum possible OR (maxOr) by OR-ing all elements.
// 2. Use backtracking to explore all subsets:
//    - At each index, we have two choices:
//        • Include nums[i] → currOr | nums[i]
//        • Exclude nums[i]
// 3. When we reach the end (i == nums.length):
//    - If currOr == maxOr, increment the count.
// 4. Return the total count of such subsets.
//
// Time complexity: O(2^n)
//   - All subsets are explored
// Space complexity: O(n)
//   - Recursion depth

class Solution {

    int count = 0;

    // Step 1: Compute maximum OR possible
    public int getMaxOr(int[] nums) {
        int or = 0;
        for (int n : nums) {
            or |= n;
        }
        return or;
    }

    // Step 2: Backtracking over subsets
    public void backtrack(int[] nums,
                          int i,
                          int currOr,
                          int maxOr) {

        // Base case: reached end
        if (i == nums.length) {
            if (currOr == maxOr) {
                count++;
            }
            return;
        }

        // Choice 1: Include current element
        backtrack(nums, i + 1, currOr | nums[i], maxOr);

        // Choice 2: Exclude current element
        backtrack(nums, i + 1, currOr, maxOr);
    }

    public int countMaxOrSubsets(int[] nums) {

        int maxOr = getMaxOr(nums);

        backtrack(nums, 0, 0, maxOr);

        return count;
    }
}