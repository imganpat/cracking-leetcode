class Solution {
    public int minSteps(String s, String t) {
        int[] sFreq = new int[26];
        int[] tFreq = new int[26];

        for (char c : s.toCharArray()) {
            sFreq[c - 'a']++;
        }

        for (char c : t.toCharArray()) {
            tFreq[c - 'a']++;
        }

        int steps = 0;

        for (int i = 0; i < 26; i++) {
            int tCount = tFreq[i];
            int sCount = sFreq[i];
            
            if (tCount > sCount) {
                steps += tCount - sCount;
            }
        }

        return steps;
    }
}