class Solution {
    public String reversePrefix(String s, int k) {
        if (k == 1) {
            return s;
        }
        StringBuilder rev = new StringBuilder(s);
        for (int left = 0, right = k - 1; left < right; left++, right--) {
            char c = rev.charAt(left);
            rev.setCharAt(left, rev.charAt(right));
            rev.setCharAt(right, c);
        }
        return rev.toString();
    }
}