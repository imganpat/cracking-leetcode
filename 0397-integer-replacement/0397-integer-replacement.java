// Approach: Greedy + Bit Pattern
// 1. If the number is even, the only useful operation is:
//      n / 2
// 2. If the number is odd, we have two choices:
//      n - 1
//      n + 1
// 3. For most odd numbers, choose the option that creates
//    more factors of 2, allowing us to divide by 2 repeatedly.
// 4. An odd number has two possible cases:
//      - n % 4 == 1:
//          n - 1 is divisible by 4, so choose n - 1.
//      - n % 4 == 3:
//          n + 1 is divisible by 4, so choose n + 1.
// 5. The exception is n == 3:
//      3 -> 2 -> 1
//    takes fewer operations than:
//      3 -> 4 -> 2 -> 1
// 6. Continue until the number becomes 1.
//
// Time complexity: O(log n)
//   - Even numbers are repeatedly divided by 2.
//   - Greedy odd-number choices quickly create divisible-by-2 values.
// Space complexity: O(1)

class Solution {
    public int integerReplacement(int n) {
        int operations = 0;

        // long prevents overflow when n = Integer.MAX_VALUE
        long num = n;
        
        while (num > 1) {

            // Even number
            if (num % 2 == 0) {
                num /= 2;
            }

            // Odd number
            else {
                // Special case:
                // 3 -> 2 -> 1 is optimal
                //
                // Also, if num % 4 == 1,
                // num - 1 is divisible by 4.
                if (num == 3 || num % 4 == 1) {
                    num--;
                } else {
                    // num % 4 == 3
                    // num + 1 is divisible by 4.
                    num++;
                }
            }
            operations++;
        }
        return operations;
    }
}