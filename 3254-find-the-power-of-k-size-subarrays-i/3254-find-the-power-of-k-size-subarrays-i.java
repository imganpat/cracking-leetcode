// Approach: Sliding Window + Consecutive Check
// 1. Use a sliding window of size k.
// 2. For every window:
//      [start ... end]
//    check whether elements are consecutive increasing:
//      nums[i] + 1 == nums[i + 1]
// 3. If all adjacent pairs satisfy the condition:
//      power = last element of window
//    otherwise:
//      power = -1
// 4. Store result for every window.
// 5. Slide the window forward.
//
// Time complexity: O(n * k)
//   - For each window, up to k comparisons
// Space complexity: O(1)
//   - Ignoring output array

class Solution {

    public int[] resultsArray(int[] nums, int k) {

        int n = nums.length;

        int index = 0;

        int[] res = new int[n - k + 1];

        // Sliding window
        for (int start = 0, end = 0;
             end < n;
             end++) {

            // Window reached size k
            if (end - start + 1 == k) {

                boolean isValid = true;

                // Check consecutive increasing sequence
                for (int i = start; i < end; i++) {

                    if (nums[i] + 1 != nums[i + 1]) {
                        isValid = false;
                        break;
                    }
                }

                // Store result
                int power =
                        isValid ? nums[end] : -1;

                res[index++] = power;

                // Slide window
                start++;
            }
        }

        return res;
    }
}