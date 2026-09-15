class Solution {
    public boolean checkDivisibility(int n) {
        int product = 1;
        int sum = 0;
        int t = n;

        while (t != 0) {
            int d = t % 10;
            
            sum += d;
            product *= d;
            t /= 10;
        }

        return n % (sum + product) == 0;
    }
}