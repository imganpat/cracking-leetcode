// Approach: Minimax + Dynamic Programming
// 1. Let helper(i) represent the maximum score difference
//    (current player - opponent) starting from index i.
// 2. At each turn, the current player can take
//    1, 2, or 3 stones.
// 3. For every possible choice:
//      - Compute the total value of stones taken.
//      - The opponent then starts from the next index.
//      - Score difference becomes:
//            takenSum - helper(nextIndex)
// 4. Choose the move that maximizes the score difference.
// 5. Memoize each index since the same states
//    are visited multiple times.
// 6. After computing helper(0):
//      - diff > 0  -> Alice wins
//      - diff == 0 -> Tie
//      - diff < 0  -> Bob wins
//
// Time complexity: O(n)
//   - Each index is computed once
// Space complexity: O(n)
//   - Memo array + recursion stack

class Solution {
    Integer[] memo;

    public String stoneGameIII(int[] stoneValue) {
        memo = new Integer[stoneValue.length];

        int diff = helper(stoneValue, 0);
        
        if (diff > 0) {
            return "Alice";
        }

        if (diff == 0) {
            return "Tie";
        }

        return "Bob";
    }

    // Maximum score difference from index i
    private int helper(int[] stoneValue,
                       int i) {
        if (i >= stoneValue.length) {
            return 0;
        }

        if (memo[i] != null) {
            return memo[i];
        }

        int take = 0;
        int best = Integer.MIN_VALUE;

        // Take 1, 2 or 3 stones
        for (int k = 0; k < 3 && i + k < stoneValue.length; k++) {
            take += stoneValue[i + k];

            best = Math.max(
                    best,
                    take - helper(stoneValue,i + k + 1)
            );
        }

        memo[i] = best;
        return best;
    }
}