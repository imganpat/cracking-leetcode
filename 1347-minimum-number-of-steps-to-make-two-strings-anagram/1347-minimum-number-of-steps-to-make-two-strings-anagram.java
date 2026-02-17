class Solution {
    public int minSteps(String s, String t) {
        Map<Character, Integer> sFreq = new HashMap<>();
        Map<Character, Integer> tFreq = new HashMap<>();

        for (char c : s.toCharArray()) {
            sFreq.put(c, sFreq.getOrDefault(c, 0) + 1);
        }

        for (char c : t.toCharArray()) {
            tFreq.put(c, tFreq.getOrDefault(c, 0) + 1);
        }

        int steps = 0;

        for (Map.Entry<Character, Integer> e : tFreq.entrySet()) {
            char c = e.getKey();
            int tCount = e.getValue();
            int sCount = sFreq.getOrDefault(c, 0);
            
            if (tCount > sCount) {
                steps += tCount - sCount;
            }
        }

        return steps;
    }
}