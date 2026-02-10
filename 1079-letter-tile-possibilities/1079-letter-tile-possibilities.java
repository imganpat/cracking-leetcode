class Solution {

    public int numTilePossibilities(String tiles) {
        // Count frequency of each character
        int[] count = new int[26];
        
        for (char ch : tiles.toCharArray()) {
            count[ch - 'A']++;
        }
        
        return dfs(count);
    }

    private int dfs(int[] count) {
        int total = 0;
        
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) {
                // Use this letter
                total++;
                count[i]--;
                
                // Continue building sequences
                total += dfs(count);
                
                // Put it back
                count[i]++;
            }
        }
        
        return total;
    }
}
