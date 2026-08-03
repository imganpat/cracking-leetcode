class Solution {
    Integer[] memo;

    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        memo = new Integer[n];
        int diff = helper(stoneValue, 0);
        
        if (diff == 0) {
            return "Tie";
        } else if (diff > 0) {
            return "Alice";
        }
        return "Bob";
    }

    private int helper(int[] stoneValue, int i) {
        if (i >= stoneValue.length) {
            return 0;
        }

        if (memo[i] != null) {
            return memo[i];
        }

        int take = 0;
        int best = Integer.MIN_VALUE;

        for (int k = 0; k < 3 && i + k < stoneValue.length; k++) {
            take += stoneValue[i + k];
            best = Math.max(best, take - helper(stoneValue,  i + k + 1));
        }

        memo[i] = best;
        return best;
    }
}