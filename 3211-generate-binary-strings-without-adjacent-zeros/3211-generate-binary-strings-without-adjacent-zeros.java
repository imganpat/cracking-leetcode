// Approach: Backtracking with Constraint (No Consecutive '0's)
// 1. Build binary strings of length n using recursion.
// 2. At each position, we have two choices: '0' or '1'.
// 3. Constraint:
//    - We can add '0' only if the previous character is NOT '0'.
//    - This prevents consecutive zeros.
// 4. Always allowed to add '1'.
// 5. When the current length reaches n, add the string to result.
// 6. Use backtracking (append → recurse → remove) to explore all valid paths.
//
// Time complexity: O(2^n)
//   - Each position has at most 2 choices
//   - Pruning reduces actual count but upper bound is 2^n
// Space complexity: O(n)
//   - Recursion depth + StringBuilder

class Solution {

    public void backtrack(List<String> res,
            StringBuilder curr,
            int n,
            int i) {

        // Base case: valid string of length n
        if (i == n) {
            res.add(curr.toString());
            return;
        }

        // Choice 1: Add '0' only if previous is not '0'
        if (curr.length() == 0 ||
                curr.charAt(curr.length() - 1) != '0') {

            curr.append("0");
            backtrack(res, curr, n, i + 1);

            // Backtrack
            curr.deleteCharAt(curr.length() - 1);
        }

        // Choice 2: Always add '1'
        curr.append("1");
        backtrack(res, curr, n, i + 1);

        // Backtrack
        curr.deleteCharAt(curr.length() - 1);
    }

    public List<String> validStrings(int n) {
        List<String> res = new ArrayList<>();

        backtrack(res, new StringBuilder(), n, 0);

        return res;
    }
}