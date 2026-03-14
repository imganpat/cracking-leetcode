// Approach: Sliding Window + Recompute When Needed
// 1. Maintain a window of size k using two pointers: start and end.
// 2. First compute the maximum element of the initial window.
// 3. Slide the window one step at a time:
//    - Store the current maximum in the result array.
//    - When the window moves forward:
//        • If the outgoing element (nums[start]) was the maximum,
//          recompute the maximum for the new window.
//        • Otherwise, compare the incoming element (nums[end + 1]) with the
//          current maximum and update it if necessary.
// 4. Continue sliding until the window reaches the end of the array.
// 5. Return the result array containing maximum values of each window.
//
// Time complexity: O(n * k) worst case
//   - Recomputing maximum may take O(k) when the previous maximum leaves the window.
// Space complexity: O(n - k + 1) – for the result array

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int start = 0, end = k - 1;
        int max = Integer.MIN_VALUE;

        // Step 1: Compute max for first window
        for (int i = start; i <= end; i++) {
            max = Math.max(nums[i], max);
        }

        int[] res = new int[nums.length - k + 1];
        int i = 0;

        // Step 2: Slide the window
        while (end < nums.length) {

            // Store current maximum
            res[i] = max;
            i++;

            if (end + 1 < nums.length) {

                // If outgoing element was the max → recompute
                if (nums[start] == max) {
                    max = Integer.MIN_VALUE;

                    for (int j = start + 1; j <= end + 1; j++) {
                        max = Math.max(nums[j], max);
                    }

                } else {
                    // Otherwise only compare new incoming element
                    max = Math.max(nums[end + 1], max);
                }
            }

            start++;
            end++;
        }

        return res;
    }
}