// Approach: Greedy Conversion using Value–Symbol Mapping
// 1. Maintain two parallel arrays:
//    - `values` for integer values.
//    - `symbols` for their corresponding Roman numerals.
// 2. Traverse the arrays from largest value to smallest value.
// 3. While the current value can be subtracted from `num`:
//    - Append the corresponding Roman symbol to the result.
//    - Subtract the value from `num`.
// 4. Stop early if `num` becomes 0.
// 5. The constructed string is the Roman numeral representation of the number.
//
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

        // Traverse from largest to smallest value
        for (int i = values.length - 1; i >= 0; i--) {

            // Stop if number has been fully converted
            if (num == 0) {
                break;
            }

            // Append symbol while value fits into num
            while (num >= values[i]) {
                roman.append(symbols[i]);
                num -= values[i];
            }
        }

        return roman.toString();
    }
}
