class Solution {
    public int mirrorDistance(int n) {
        int rev = 0;
        int og = n;

        while (n != 0) {
            rev = rev * 10 + n % 10;
            n /= 10;
        }

        return Math.abs(og - rev);
    }
}