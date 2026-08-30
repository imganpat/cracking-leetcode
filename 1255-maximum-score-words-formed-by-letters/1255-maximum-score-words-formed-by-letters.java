class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] freq = new int[26];

        for (char letter : letters) {
            freq[letter  - 'a']++;
        }

        return backtrack(0, words, freq, score);
    }

    private int backtrack(int i, String[] words, int[] freq, int[] score)  {
        if (i == words.length) {
            return 0;
        }

        int res  = 0;

        res  =  backtrack(i + 1, words, freq, score);

        if (canWordForm(words[i], freq)) {
            for (char c : words[i].toCharArray())  {
                freq[c - 'a']--;
            }

            res = Math.max(res, getScore(words[i], score) + backtrack(i + 1,  words, freq, score));
            
            for (char c  : words[i].toCharArray()) {
                freq[c-'a']++;
            }
        }

        return res;
    }

    private boolean canWordForm(String word, int[] freq) {
        int[] wordFreq = new int[26];

        for (char c : word.toCharArray()) {
            wordFreq[c - 'a']++;
        }

        for (char c: word.toCharArray()) {
            int i = c - 'a';
            if (wordFreq[i] >  freq[i])  {
                return false;
            }
        }
        
        return true;
    }

    private int getScore(String word, int[] score) {
        int res = 0;

        for (char c  : word.toCharArray()) {
            res += score[c - 'a'];
        }

        return res;
    }
}