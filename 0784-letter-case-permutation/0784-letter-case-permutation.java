// Approach: Backtracking (Case Toggle Permutations)
// 1. Traverse the string character by character using recursion.
// 2. For each position:
//    - If it is a digit:
//        • Digits cannot change, so move to next position.
//    - If it is a letter:
//        • Try lowercase version.
//        • Try uppercase version.
// 3. Use StringBuilder so characters can be modified in-place.
// 4. After exploring both choices, restore original character (backtracking).
// 5. When all positions are processed, add the current string to result.
//
// Time complexity: O(2^k)
//   - k = number of letters
//   - Each letter has 2 choices
// Space complexity: O(k)
//   - Recursion depth

class Solution {

    List<String> res = new ArrayList<>();

    public void backtrack(StringBuilder curr, int i) {

        // Base case: all characters processed
        if (i < 0) {
            res.add(curr.toString());
            return;
        }

        // Digits → only one choice
        if (Character.isDigit(curr.charAt(i))) {
            backtrack(curr, i - 1);
        }

        // Letters → two choices
        else {

            char original = curr.charAt(i);

            // Choice 1: lowercase
            curr.setCharAt(i,
                    Character.toLowerCase(original));

            backtrack(curr, i - 1);

            // Choice 2: uppercase
            curr.setCharAt(i,
                    Character.toUpperCase(original));

            backtrack(curr, i - 1);

            // Backtrack
            curr.setCharAt(i, original);
        }
    }

    public List<String> letterCasePermutation(String s) {

        backtrack(new StringBuilder(s),
                s.length() - 1);

        return res;
    }
}