class Solution {
    Map<Integer,Integer> dp = new HashMap<>();
    public int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        if (dp.containsKey(n)) {
            return dp.get(n);
        }
        
        int num = fib(n-1) + fib(n  - 2);

        dp.put(n, num);

        return num;
    }
}