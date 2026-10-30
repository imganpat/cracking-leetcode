class Solution {
    public int[] countBits(int n) {
        int[] counts = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            counts[i] = countSetBits(i);
        }

        return counts;
    }

    public int countSetBits(int num) {
        int count = 0;

        while (num > 0) {
            if ((num & 1) == 1) {
                count++;
            }
            num = num >> 1;
        }

        return count;
    }
}