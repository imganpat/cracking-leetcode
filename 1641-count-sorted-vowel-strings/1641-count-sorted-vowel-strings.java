// Approach: 1D Dynamic Programming
// 1. The vowels are ordered:
//      a < e < i < o < u
// 2. Since the string must be non-decreasing,
//    if the last character is:
//      a -> previous character can only be a
//      e -> previous character can be a/e
//      i -> previous character can be a/e/i
//      o -> previous character can be a/e/i/o
//      u -> previous character can be a/e/i/o/u
// 3. Initially, for length 1, there is exactly one string
//    ending in each vowel:
//
//      [1, 1, 1, 1, 1]
//
// 4. For every additional character, update from left to right:
//      dp[i] += dp[i - 1]
// 5. After processing length n, the sum of dp[] gives the
//    number of valid strings of length n.
//
// Time complexity: O(n)
//   - For every length, process 5 vowels.
//   - O(5n) = O(n)
//
// Space complexity: O(1)
//   - Only 5 DP values are stored.

class Solution {
    public int countVowelStrings(int n) {
        // Number of valid strings of length 1
        // ending in:
        // a, e, i, o, u
        int[] dp = {1, 1, 1, 1, 1};

        // Build strings of length 2 through n
        for (int t = 2; t <= n; t++) {
            for (int i = 1; i < 5; i++) {
                // Add all strings ending at the previous vowel
                dp[i] += dp[i - 1];
            }
        }

        int count = 0;
        // Every ending vowel is a valid final string
        for (int num : dp) {
            count += num;
        }

        return count;
    }
}