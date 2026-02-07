class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();

        for (Character c : ransomNote.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (Character c : magazine.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
            }
        }

        for (Map.Entry<Character, Integer> e : map.entrySet()) {
            int v = e.getValue();
            if (v > 0) {
                return false;
            }
        }

        return true;
    }
}