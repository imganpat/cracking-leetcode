class Solution {
    public int numberOfSubstrings(String s) {
        int start = 0;
        int end = 0;
        int n = s.length();

        Map<Character, Integer> freq = new HashMap<>();
        int count = 0;

        while (end < n) {
            char rightChar = s.charAt(end);
            freq.put(rightChar, freq.getOrDefault(rightChar, 0) + 1);
            // freq.merge(rightChar, 1, Integer::sum);
            
            while (freq.containsKey('a') &&
                    freq.containsKey('b') &&
                    freq.containsKey('c')) {

                count += n - end;

                char leftChar = s.charAt(start);
                freq.put(leftChar, freq.get(leftChar) - 1);
                // freq.merge(leftChar, -1, Integer::sum);

                if (freq.get(leftChar) == 0) {
                    freq.remove(leftChar);
                }

                start++;
            }

            end++;
        }

        return count;
    }
}