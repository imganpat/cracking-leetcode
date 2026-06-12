class Solution {
    public int[] divisibilityArray(String word, int m) {
        int n = word.length();
        int[] res = new int[n];

        long rem = 0;
        for (int i = 0; i < n; i++) {
            rem = (rem * 10 + Character.getNumericValue(word.charAt(i))) % m;

            if (rem == 0) {
                res[i] = 1;
            }
        }

        return res;
    }
}