class Solution {
    public long sumAndMultiply(int n) {
        long sum = 0;
        long reversedX = 0;

        while (n != 0) {
            int d = n % 10;
            sum += d;
            
            if (d != 0) {
                reversedX = reversedX * 10 + d;
            }

            n /= 10;
        }

        long x = 0;

        while (reversedX != 0) {
            x = x * 10 + reversedX % 10;
            reversedX /= 10;
        }

        return x * sum;
    }
}