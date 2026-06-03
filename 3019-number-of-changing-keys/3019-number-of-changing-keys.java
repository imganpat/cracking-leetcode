class Solution {
    public int countKeyChanges(String s) {
        int n = s.length();
        int count = 0;

        for (int i = 1; i < n; i++) {
            char p = Character.toLowerCase(s.charAt(i - 1));
            char q = Character.toLowerCase(s.charAt(i));
            if (p != q) {
                count++;
            }
        }

        return count;
    }
}