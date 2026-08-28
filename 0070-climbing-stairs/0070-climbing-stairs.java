class Solution {
    public int climbStairs(int n) {
        Map<Integer, Integer> dp = new HashMap<>();
        return helper(0, n, dp);
    }

    private int helper(int i, int n, Map<Integer,Integer> dp) {
        if (i == n) {
            return 1;
        }

        if (i > n) {
            return 0;
        }

        if (dp.containsKey(i)) {
            return dp.get(i);
        }

        int res = helper(i + 1, n, dp) + helper(i + 2, n, dp);

        dp.put(i, res);

        return res;
    }
}