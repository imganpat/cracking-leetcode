class Solution {
    Integer[][] memo;
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        memo = new Integer[n][n];
        int diff = helper (piles, 0, n - 1);
        return diff > 0;
    }

    private int helper(int[] piles, int l, int r) {
        if (l > r) {
            return 0;
        }

        if (l == r) {
            return piles[l];
        }

        if (memo[l][r] != null) {
            return memo[l][r];
        }

        int left = piles[l] - helper(piles, l + 1, r);
        int right = piles[r] - helper(piles, l, r - 1);

        memo[l][r] = Math.max(left, right);
        return memo[l][r];
    }
}