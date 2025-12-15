class Solution {
    public int maxDistinct(String s) {
        Set<Character> freq = new HashSet<>();
        
        for (int i = 0; i < s.length(); i++) {
            freq.add(s.charAt(i));
        }

        return freq.size();
    }
}