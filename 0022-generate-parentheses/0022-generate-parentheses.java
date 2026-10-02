class Solution {
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