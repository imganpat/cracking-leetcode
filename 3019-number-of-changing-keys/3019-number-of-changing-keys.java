class Solution {
    public int countKeyChanges(String s) {
        int n = s.length();
        String l = s.toLowerCase();
        int count = 0;

        for (int i = 1; i < n; i++) {
            if (l.charAt(i - 1) != l.charAt(i)) {
                count++;
            }
        }

        return count;
    }
}