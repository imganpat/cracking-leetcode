class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] map = new int[26];

        for (Character c : ransomNote.toCharArray()) {
            // map.put(c, map.getOrDefault(c, 0) + 1);
            map[c - 'a']++;
        }

        for (Character c : magazine.toCharArray()) {
            map[c - 'a']--;
        }

        for (int i = 0; i < map.length; i++) {
            int v = map[i];
            if (v > 0) {
                return false;
            }
        }

        return true;
    }
}