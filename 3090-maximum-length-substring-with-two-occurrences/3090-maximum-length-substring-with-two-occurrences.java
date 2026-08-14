class Solution {
    public int maximumLengthSubstring(String s) {
        int max = Integer.MIN_VALUE;
        Map<Character, Integer> map = new HashMap<>();

        for (int start = 0, end = 0; end < s.length(); end++) {
            char ch = s.charAt(end);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            while (map.get(ch) > 2) {
                char leftChar = s.charAt(start);
                map.put(leftChar, map.get(leftChar) - 1);
                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }
                start++;
            }

            max = Math.max(max, end - start + 1);
        }

        return max;
    }
}