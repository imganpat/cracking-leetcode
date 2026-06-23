class Solution {
    public int kthFactor(int n, int k) {
        List<Integer> factors = new ArrayList<>();

        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                if (--k == 0){
                    return i;
                }
                
                if (i != n / i) {
                    factors.add(n / i);
                }
            }
        }

        for (int i = factors.size() - 1; i >= 0; i--) {
            if (--k == 0) {
                return factors.get(i);
            }
        }

        return -1;
    }
}