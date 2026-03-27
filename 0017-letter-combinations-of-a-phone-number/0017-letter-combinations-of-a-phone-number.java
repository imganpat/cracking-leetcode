// Approach: Backtracking (Digit → Letter Mapping)
// 1. Map each digit (2–9) to its corresponding letters (phone keypad).
// 2. Use backtracking to build combinations:
//    - At index i, get all possible letters for digits[i].
//    - For each letter:
//        • Add it to the current string.
//        • Recurse for next index.
//        • Backtrack (remove last character).
// 3. When index reaches digits.length(), a full combination is formed.
// 4. Add the combination to the result list.
// 5. Return all generated combinations.
//
// Time complexity: O(4^n)
//   - Each digit can map to up to 4 letters
// Space complexity: O(n)
//   - Recursion depth + current string

class Solution {

    Map<Character, String> map;

    public Solution() {
        map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }

    public void backtrack(List<String> res,
                          StringBuilder curr,
                          int i,
                          String digits) {

        // Base case: full combination formed
        if (i == digits.length()) {
            res.add(curr.toString());
            return;
        }

        // Get possible letters for current digit
        String choices = map.get(digits.charAt(i));

        for (int j = 0; j < choices.length(); j++) {
            curr.append(choices.charAt(j));

            backtrack(res, curr, i + 1, digits);

            // Backtrack
            curr.deleteCharAt(curr.length() - 1);
        }
    }

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();

        // Edge case: empty input
        if (digits.length() == 0) {
            return res;
        }

        backtrack(res, new StringBuilder(), 0, digits);

        return res;
    }
}