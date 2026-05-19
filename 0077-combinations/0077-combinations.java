// Approach: Backtracking (Include / Exclude for Combinations)
// 1. Generate all combinations of size k from numbers [1...n].
// 2. At each number `i`, we have two choices:
//    - Include i in current combination.
//    - Exclude i.
// 3. If current combination size becomes k:
//    - Add it to result.
// 4. If i exceeds n:
//    - Stop recursion.
// 5. Use backtracking:
//    - Add number → recurse → remove number.
//
// Time complexity: O(C(n, k) * k)
//   - Total combinations = C(n, k)
//   - Copying each combination takes O(k)
// Space complexity: O(k)
//   - Recursion depth + current combination

class Solution {

    List<List<Integer>> res = new ArrayList<>();

    public void backtrack(List<Integer> curr,
            int i,
            int k,
            int n) {

        // Base case: valid combination formed
        if (curr.size() == k) {
            res.add(new ArrayList<>(curr));
            return;
        }

        // Out of bounds
        if (i > n) {
            return;
        }

        // Choice 1: Include current number
        curr.add(i);

        backtrack(curr, i + 1, k, n);

        // Backtrack
        curr.remove(curr.size() - 1);

        // Choice 2: Exclude current number
        backtrack(curr, i + 1, k, n);
    }

    public List<List<Integer>> combine(int n, int k) {

        backtrack(new ArrayList<>(), 1, k, n);

        return res;
    }
}