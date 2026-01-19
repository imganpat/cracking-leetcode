class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        Map<Character, Integer> map = new HashMap<>();
        for (char c : s1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int count = s1.length();
        int start = 0, end = 0;

        while (end < s2.length()) {
            char endChar = s2.charAt(end);
            if (map.containsKey(endChar)) {
                if (map.get(endChar) > 0) {
                    count--;
                }
                map.put(endChar, map.get(endChar) - 1);
            }

            while (end - start + 1 > s1.length()) {
                char startChar = s2.charAt(start);
                if (map.containsKey(startChar)) {
                    if (map.get(startChar) >= 0) {
                        count++;
                    }
                    map.put(startChar, map.get(startChar) + 1);
                }
                start++;
            }
            
            if (count == 0){
                return true;
            }

            end++;
        }
        return false;
    }
}