class Solution {
    public int smallestNumber(int n, int t) {
        for (int i = n; i <= 100; i++) {
            int product = getProduct(i);
            if (product % t == 0) {
                return i;
            }
        }
        return -1;
    }

    private int getProduct(int num) {
        if (num == 0) {
            return 0;
        }
        
        int product = 1;
        while (num > 0) {
            int d = num % 10;
            product *= d;
            num /= 10;
        }
        return product;
    }
}