// Approach: Base-26 Conversion
// 1. Excel column titles work like a base-26 number system.
// 2. Mapping:
//      A -> 1
//      B -> 2
//      ...
//      Z -> 26
// 3. Traverse characters from left to right.
// 4. For each character:
//      value = current character contribution
//      contribution = value * 26^(position power)
// 5. Add all contributions to result.
// 6. Return final number.
//
// Time complexity: O(n)
//   - Traverse string once
// Space complexity: O(1)

class Solution {

    public int titleToNumber(String columnTitle) {

        int res = 0;

        int n = columnTitle.length();

        for (int i = 0; i < n; i++) {

            int power = n - 1 - i;

            // Convert character to value
            int curr =
                    columnTitle.charAt(i) - 'A' + 1;

            // Add positional contribution
            res += curr * Math.pow(26, power);
        }

        return res;
    }
}