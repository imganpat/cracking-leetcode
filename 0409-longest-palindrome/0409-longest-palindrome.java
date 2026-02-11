class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        int length = 0;
        boolean hasOdd = false;

        for (int v : freq.values()) {
            if (v % 2 == 1) {
                hasOdd = true;
            }

            length += (v / 2) * 2;
        }

        return hasOdd ? length + 1 : length;
    }
}