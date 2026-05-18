class Solution {
    List<String> res = new ArrayList<>();

    public void backtrack(StringBuilder curr, int i) {
        if (i < 0) {
            res.add(curr.toString());
            return;
        }

        if (Character.isDigit(curr.charAt(i))) {
            backtrack(curr, i - 1);
        } else {
            char original = curr.charAt(i);

            curr.setCharAt(i, Character.toLowerCase(original));
            backtrack(curr, i - 1);

            curr.setCharAt(i, Character.toUpperCase(original));
            backtrack(curr, i - 1);

            // curr.setCharAt(i, original);
        }

    }

    public List<String> letterCasePermutation(String s) {
        backtrack(new StringBuilder(s), s.length() - 1);
        return res;
    }
}