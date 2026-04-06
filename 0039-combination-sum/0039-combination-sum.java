// Approach: Backtracking (Combination Sum - Reuse Allowed)
// 1. Use backtracking to build combinations whose sum equals target.
// 2. At each step, iterate from index `i` to avoid duplicates.
// 3. For each candidate:
//    - Add it to current combination.
//    - Recurse with same index (j) because reuse is allowed.
// 4. If sum == target → add current combination to result.
// 5. If sum > target → prune the branch (stop exploring).
// 6. Backtrack by removing the last added element and restoring sum.
//
// Time complexity: O(2^n) (approx, depends on pruning and input)
// Space complexity: O(target)
//   - recursion depth + current combination

class Solution {

    public void backtrack(
            List<List<Integer>> res,
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

        // Prune: if sum exceeds target
        if (sum > target) {
            return;
        }

        // Try all candidates starting from index i
        for (int j = i; j < candidates.length; j++) {

            // Choose
            curr.add(candidates[j]);
            sum += candidates[j];

            // Reuse allowed → pass j again
            backtrack(res, curr, j, sum, candidates, target);

            // Backtrack
            sum -= candidates[j];
            curr.remove(curr.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> res = new ArrayList<>();

        backtrack(res, new ArrayList<>(), 0, 0, candidates, target);

        return res;
    }
}