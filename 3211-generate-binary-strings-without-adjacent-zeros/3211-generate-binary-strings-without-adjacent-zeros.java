class Solution {
    public void backtrack(List<String> res, StringBuilder curr, int n, int i) {
        if (i == n) {
            res.add(curr.toString());
            return;
        }
        if (curr.length() == 0 || curr.charAt(curr.length() - 1) != '0') {
            curr.append("0");
            backtrack(res, curr, n, i + 1);
            curr.deleteCharAt(curr.length() - 1);
        }
        curr.append("1");
        backtrack(res, curr, n, i + 1);
        curr.deleteCharAt(curr.length() - 1);

        return;
    }

    public List<String> validStrings(int n) {
        List<String> res = new ArrayList<>();

        backtrack(res, new StringBuilder(), n, 0);

        return res;
    }

}