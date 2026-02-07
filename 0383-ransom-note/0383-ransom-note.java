class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int n = 26;
        int[] map = new int[n], map2 = new int[n];

        for (Character c : ransomNote.toCharArray()) {
            map[c - 'a']++;
        }

        for (Character c : magazine.toCharArray()) {
            map[c - 'a']--;
        }

        for (Character c : ransomNote.toCharArray()) {
            if (map[c - 'a'] > map2[c - 'a']) {
                return false;
            }
        }

        return true;
    }
}