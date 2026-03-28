// Approach: Backtracking + Lexicographic Order + Early Pruning
// 1. Generate all "happy strings" of length n using backtracking.
//    - A happy string has no two consecutive characters equal.
// 2. At each step, try characters from 'a' to 'c' (lexicographic order).
// 3. Skip a character if it is the same as the previous one.
// 4. Use pruning:
//    - If we already collected k strings, stop further recursion.
// 5. When a string of length n is formed, add it to the result list.
// 6. Since we generate in lexicographic order, the k-th string is directly at index (k-1).
// 7. If fewer than k strings exist, return "".
//
// Time complexity: O(k * n)
//   - We stop early once k strings are generated
// Space complexity: O(n)
//   - Recursion depth + current string

class Solution {

    public void backtrack(List<String> res,
                          StringBuilder curr,
                          int n,
                          int k) {

        // Prune: stop if we already have k strings
        if (res.size() >= k) {
            return;
        }

        // Base case: valid string formed
        if (curr.length() == n) {
            res.add(curr.toString());
            return;
        }

        // Try characters in lexicographic order
        for (char c = 'a'; c <= 'c'; c++) {

            // Skip if same as previous character
            if (curr.length() > 0 &&
                curr.charAt(curr.length() - 1) == c) {
                continue;
            }

            curr.append(c);

            backtrack(res, curr, n, k);

            // Backtrack
            curr.deleteCharAt(curr.length() - 1);
        }
    }

    public String getHappyString(int n, int k) {
        List<String> res = new ArrayList<>();

        backtrack(res, new StringBuilder(), n, k);

        // Return k-th string (1-based index)
        return k <= res.size() ? res.get(k - 1) : "";
    }
}