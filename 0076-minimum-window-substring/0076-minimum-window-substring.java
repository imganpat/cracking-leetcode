// Approach: Sliding Window + Frequency Map
// 1. Store the frequency of each character of string `t` in a HashMap.
// 2. Use two pointers (`start` and `end`) to form a sliding window over string `s`.
// 3. Expand the window by moving `end` and decrease character count when a required character is found.
// 4. When all required characters are matched (count == 0), try shrinking the window from the left
//    to find the minimum-length valid window.
// 5. Keep updating the minimum window length and its starting index.
// 6. Return the smallest substring that contains all characters of `t`.
// 7. If no such window exists, return an empty string.
//
// Time complexity: O(n) – each character is processed at most twice
// Space complexity: O(1) – at most 52 characters stored (uppercase + lowercase)

class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }

        // Store frequency of characters in t
        Map<Character, Integer> requiredChars = new HashMap<>();
        for (char c : t.toCharArray()) {
            requiredChars.put(c, requiredChars.getOrDefault(c, 0) + 1);
        }

        int start = 0, end = 0;
        int count = requiredChars.size(); // number of unique characters to match
        int min = Integer.MAX_VALUE;
        int minStart = 0;

        // Sliding window
        while (end < s.length()) {
            char rightChar = s.charAt(end);

            // Decrease frequency if character is required
            if (requiredChars.containsKey(rightChar)) {
                requiredChars.put(rightChar, requiredChars.get(rightChar) - 1);
                if (requiredChars.get(rightChar) == 0) {
                    count--;
                }
            }

            // Try shrinking the window when all chars are matched
            while (count == 0) {
                int len = end - start + 1;
                if (len < min) {
                    min = len;
                    minStart = start;
                }

                char leftChar = s.charAt(start);
                if (requiredChars.containsKey(leftChar)) {
                    requiredChars.put(leftChar, requiredChars.get(leftChar) + 1);
                    if (requiredChars.get(leftChar) > 0) {
                        count++;
                    }
                }
                start++;
            }
            end++;
        }

        return min == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + min);
    }
}
