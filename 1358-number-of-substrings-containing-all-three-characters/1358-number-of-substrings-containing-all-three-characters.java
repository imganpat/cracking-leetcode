class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int[] freq = new int[26];
        int count = 0;

        for (int start = 0, end = 0; end < n; end++) {
            freq[s.charAt(end) - 'a']++;

            while (freq[0] > 0 &&
                    freq[1] > 0 &&
                    freq[2] > 0) {

                count += n - end;
                freq[s.charAt(start) - 'a']--;
                start++;
            }
        }

        return count;
    }
}