// Approach: Dynamic Programming
// 1. The first and last element of every row are always 1.
// 2. Every inner element is calculated using:
//      triangle[i][j] = triangle[i-1][j-1] + triangle[i-1][j]
// 3. Build each row using the previously constructed row.
//
// Time complexity: O(numRows²)
//   - There are O(numRows²) elements in the triangle.
//
// Space complexity: O(numRows²)
//   - Required to store the complete triangle.

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> tri = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {

            List<Integer> row = new ArrayList<>();

            // First element
            row.add(1);

            // Inner elements
            for (int j = 1; j < i; j++) {

                int value =
                        tri.get(i - 1).get(j - 1)
                        + tri.get(i - 1).get(j);

                row.add(value);
            }

            // Last element
            if (i > 0) {
                row.add(1);
            }

            tri.add(row);
        }

        return tri;
    }
}