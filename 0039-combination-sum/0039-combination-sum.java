// Approach: Backtracking (Include / Skip Pattern with Reuse)
// 1. At each index `i`, we have two choices:
//    - Skip the current element → move to i + 1.
//    - Include the current element → stay at i (since reuse is allowed).
// 2. Maintain current sum and combination (curr).
// 3. If sum == target → add the combination to result.
// 4. If index reaches end OR sum exceeds target → stop recursion.
// 5. Backtrack by undoing the last choice.
//
// Time complexity: O(2^n) (approx, depends on pruning)
// Space complexity: O(target)
//   - recursion depth + current combination

class Solution {

    private void backtrack(List<List<Integer>> res,
                           List<Integer> curr,
                           int i,
                           int sum,
                           int[] candidates,
                           int target) {

        // Base case: valid combination
        if (sum == target) {
            res.add(new ArrayList<>(curr));
            return;
        }

        // Stop if index out of bounds
        if (i == candidates.length) {
            return;
        }

        // Choice 1: Skip current element
        backtrack(res, curr, i + 1, sum, candidates, target);

        // Choice 2: Include current element (if it doesn't exceed target)
        if (sum + candidates[i] <= target) {
            curr.add(candidates[i]);

            // Stay at same index → reuse allowed
            backtrack(res, curr, i, sum + candidates[i], candidates, target);

            // Backtrack
            curr.remove(curr.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();

        backtrack(res, new ArrayList<>(), 0, 0, candidates, target);

        return res;
    }
}