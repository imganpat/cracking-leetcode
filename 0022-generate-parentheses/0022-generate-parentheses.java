// Approach: Backtracking (Generate Valid Parentheses)
// 1. Build the string step by step using recursion.
// 2. Keep track of:
//    - open → number of '(' used
//    - close → number of ')' used
// 3. At any point:
//    - You can add '(' if open < n.
//    - You can add ')' only if close < open (to maintain validity).
// 4. When open == n and close == n, a valid combination is formed.
// 5. Use StringBuilder for efficient add/remove (backtracking).
// 6. Backtrack by removing the last character after each recursive call.
//
// Time complexity: O(Cn)
//   - Cn = nth Catalan number ≈ (4^n / √n)
//   - Number of valid combinations
// Space complexity: O(n)
//   - Recursion depth + StringBuilder

class Solution {

    // Backtracking function
    public void backtrack(int open, int close, int n,
                          StringBuilder str, List<String> res) {

        // Base case: valid sequence formed
        if (open == n && close == n) {
            res.add(str.toString());
            return;
        }

        // Add '(' if we still can
        if (open < n) {
            str.append("(");
            backtrack(open + 1, close, n, str, res);

            // Backtrack: remove last character
            str.deleteCharAt(str.length() - 1);
        }

        // Add ')' only if it keeps sequence valid
        if (close < open) {
            str.append(")");
            backtrack(open, close + 1, n, str, res);

            // Backtrack
            str.deleteCharAt(str.length() - 1);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder str = new StringBuilder();

        backtrack(0, 0, n, str, res);

        return res;
    }
}