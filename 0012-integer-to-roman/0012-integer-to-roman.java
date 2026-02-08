// Approach: Greedy Mapping with Value–Symbol Pairs
// 1. Define arrays of Roman symbols and their corresponding integer values.
// 2. Traverse the values array from largest to smallest.
// 3. For each value, determine how many times it fits into the remaining number.
// 4. Append the corresponding Roman symbol that many times to the result.
// 5. Reduce the number using modulo and continue until the number becomes 0.


// Time complexity: O(1) – the loop runs over a fixed set of Roman values
// Space complexity: O(1) – constant extra space used (excluding output string)

class Solution {
    public String intToRoman(int num) {
        String[] symbols = {
            "I", "IV", "V", "IX", "X", "XL", "L", "XC",
            "C", "CD", "D", "CM", "M"
        };
        int[] values = {
            1, 4, 5, 9, 10, 40, 50, 90,
            100, 400, 500, 900, 1000
        };

        StringBuilder roman = new StringBuilder();

        // Traverse from largest value to smallest
        for (int i = values.length - 1; i >= 0; i--) {
            int count = num / values[i];

            // Append symbol 'count' times
            while (count-- > 0) {
                roman.append(symbols[i]);
            }

            // Reduce num by the value used
            num %= values[i];
        }

        return roman.toString();
    }
}
