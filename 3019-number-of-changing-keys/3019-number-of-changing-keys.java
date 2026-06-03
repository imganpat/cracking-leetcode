class Solution {
    public int countKeyChanges(String s) {
        String l = s.toLowerCase();
        
        int count = 0;

        for (int i = 1; i < s.length(); i++) {
            if (l.charAt(i - 1) != l.charAt(i)) {
                count++;
            }
        }

        return count;
    }
}