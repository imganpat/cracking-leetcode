// Approach: Prefix/Suffix Consecutive Counts
// 1. A day i is "good" if:
//      - Previous `time` days are non-increasing.
//      - Next `time` days are non-decreasing.
// 2. Build two arrays:
//      left[i]  = consecutive non-increasing days ending at i.
//      right[i] = consecutive non-decreasing days starting at i.
// 3. Compute left[]:
//      - If security[i] <= security[i-1],
//        extend previous streak.
// 4. Compute right[]:
//      - If security[i] <= security[i+1],
//        extend next streak.
// 5. A day is valid if:
//      left[i] >= time
//      AND
//      right[i] >= time
// 6. Collect all such indices.
//
// Time complexity: O(n)
//   - Three linear traversals
// Space complexity: O(n)
//   - Two auxiliary arrays

class Solution {

    public List<Integer> goodDaysToRobBank(int[] security,
                                           int time) {

        List<Integer> goodDays = new ArrayList<>();

        int n = security.length;

        // Every day is valid
        if (time == 0) {

            for (int i = 0; i < n; i++) {
                goodDays.add(i);
            }

            return goodDays;
        }

        int[] left = new int[n];
        int[] right = new int[n];

        // Non-increasing streak ending at i
        for (int i = 1; i < n; i++) {

            if (security[i] <= security[i - 1]) {
                left[i] = left[i - 1] + 1;
            }
        }

        // Non-decreasing streak starting at i
        for (int i = n - 2; i >= 0; i--) {

            if (security[i] <= security[i + 1]) {
                right[i] = right[i + 1] + 1;
            }
        }

        // Check valid days
        for (int i = time;
             i < n - time;
             i++) {

            if (left[i] >= time &&
                right[i] >= time) {

                goodDays.add(i);
            }
        }

        return goodDays;
    }
}