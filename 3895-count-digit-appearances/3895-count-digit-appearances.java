class Solution {
    public int countDigitOccurrences(int[] nums, int digit) {
        int [] freq = new int[10];

        for (int num: nums) {
            while (num > 0) {
                int d = num % 10;
                freq[d]++;
                num /= 10;
            }
        }

        return freq[digit];
    }
}