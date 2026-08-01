// Approach: Minimax Recursion (Score Difference)
// 1. Let helper(l, r) represent the maximum score difference
//    (current player - opponent) obtainable from subarray [l...r].
// 2. At each turn, the current player has two choices:
//      - Pick the left number.
//      - Pick the right number.
// 3. If the current player picks:
//      nums[l]
//    then the opponent becomes the current player for
//    subarray [l+1...r].
//    The resulting score difference is:
//      nums[l] - helper(l+1, r)
// 4. Similarly, if the current player picks:
//      nums[r]
//    the score difference becomes:
//      nums[r] - helper(l, r-1)
// 5. The current player always chooses the option that
//    maximizes the score difference.
// 6. If the final score difference is non-negative,
//    Player 1 can win (or tie).
//
// Time complexity: O(2^n)
//   - Every state branches into two recursive calls
// Space complexity: O(n)
//   - Recursion stack

class Solution {
    public boolean predictTheWinner(int[] nums) {
        int diff = helper(nums, 0, nums.length - 1);
        return diff >= 0;
    }

    // Maximum score difference (current player - opponent)
    private int helper(int[] nums,
                       int l,
                       int r) {

        // No numbers left
        if (l > r) {
            return 0;
        }

        // Only one number left
        if (l == r) {
            return nums[l];
        }

        // Pick left
        int left =
                nums[l] - helper(nums, l + 1, r);

        // Pick right
        int right =
                nums[r] - helper(nums, l, r - 1);

        // Best possible difference
        return Math.max(left, right);
    }
}