class Solution {
    public int[] divisibilityArray(String word, int m) {
        int n = word.length();
        int[] res = new int[n];

        long rem = 0;
        for (int i = 0; i < n; i++) {
            rem = (rem * 10 + Character.getNumericValue(word.charAt(i))) % m;
            res[i] = rem == 0 ? 1 : 0;
        }

        return res;
    }
}