// Approach: Brute Force + Local Peak/Valley Check
// 1. Iterate through every number from num1 to num2.
// 2. Convert the number into a string for easy digit access.
// 3. For every middle digit:
//      prev curr next
//    check whether curr forms:
//      - a peak  : curr > prev AND curr > next
//      - a valley: curr < prev AND curr < next
// 4. If yes, increment waviness count.
// 5. Return total count.
//
// Time complexity: O((num2 - num1 + 1) * d)
//   - d = number of digits
// Space complexity: O(d)
//   - String conversion

class Solution {

    public int totalWaviness(int num1, int num2) {

        int count = 0;

        // Check every number in range
        for (int n = num1; n <= num2; n++) {

            String s = n + "";

            // Check every middle digit
            for (int i = 1; i < s.length() - 1; i++) {

                char curr = s.charAt(i);
                char prev = s.charAt(i - 1);
                char next = s.charAt(i + 1);

                // Peak OR valley
                if ((curr > prev && curr > next)
                        ||
                    (curr < prev && curr < next)) {

                    count++;
                }
            }
        }

        return count;
    }
}