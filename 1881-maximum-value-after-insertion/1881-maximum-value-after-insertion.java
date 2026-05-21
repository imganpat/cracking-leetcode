// Approach: Greedy Insertion
// 1. We want to insert digit x into number string n
//    such that the resulting value is maximized.
// 2. Handle two cases separately:
//
//    Case 1: Positive number
//      - Insert x before the first digit smaller than x.
//      - This makes larger digits appear earlier.
//
//    Case 2: Negative number
//      - Insert x before the first digit larger than x.
//      - For negatives, smaller magnitude gives larger value.
//
// 3. If no suitable position is found,
//    append x at the end.
// 4. Return the constructed string.
//
// Time complexity: O(n)
//   - Single traversal of string
// Space complexity: O(n)
//   - StringBuilder for result

class Solution {

    public String maxValue(String n, int x) {

        StringBuilder res = new StringBuilder();

        boolean isNegative =
                (n.charAt(0) == '-');

        char digit = (char) (x + '0');

        boolean inserted = false;

        // Case 1: Negative number
        if (isNegative) {

            res.append("-");

            for (int i = 1; i < n.length(); i++) {

                // Insert before first larger digit
                if (!inserted &&
                    n.charAt(i) > digit) {

                    res.append(digit);
                    inserted = true;
                }

                res.append(n.charAt(i));
            }

        }

        // Case 2: Positive number
        else {

            for (int i = 0; i < n.length(); i++) {

                // Insert before first smaller digit
                if (!inserted &&
                    n.charAt(i) < digit) {

                    res.append(digit);
                    inserted = true;
                }

                res.append(n.charAt(i));
            }
        }

        // If not inserted anywhere, append at end
        if (!inserted) {
            res.append(digit);
        }

        return res.toString();
    }
}