class Solution {
    public int minSteps(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();

        for (char c: s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        for (char c: t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) - 1);
        }

        int count = 0;

        for (char c: map.keySet()) {
            count += Math.abs(map.get(c));
        }

        return count;
    }
}