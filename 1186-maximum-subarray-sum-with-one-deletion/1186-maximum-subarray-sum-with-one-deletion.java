// Approach: Dynamic Programming (Kadane’s Algorithm with One Deletion Allowed)
// 1. Maintain two states while traversing the array:
//    - noDel → maximum subarray sum ending at current index WITHOUT deleting any element.
//    - oneDel → maximum subarray sum ending at current index WITH exactly one deletion.
// 2. For each element:
//    - Update noDel using standard Kadane’s logic.
//    - Update oneDel by either:
//        a) Extending previous oneDel, or
//        b) Deleting the current element (using previous noDel).
// 3. Track the global maximum result from both states.
// 4. Return the maximum value obtained.
//
// Time complexity: O(n) – single pass through the array
// Space complexity: O(1) – only constant extra variables used

class Solution {
    public int maximumSum(int[] arr) {
        int res = arr[0];              // Stores the final maximum result
        int noDel = arr[0];            // Max sum without deletion
        int oneDel = Integer.MIN_VALUE; // Max sum with one deletion

        for (int i = 1; i < arr.length; i++) {
            int prevNoDel = noDel;
            int prevOneDel = oneDel;

            // Case 1: No deletion used yet
            noDel = Math.max(prevNoDel + arr[i], arr[i]);

            // Case 2: One deletion used
            int temp;
            if (prevOneDel == Integer.MIN_VALUE) {
                temp = arr[i];
            } else {
                temp = prevOneDel + arr[i];
            }
            oneDel = Math.max(temp, prevNoDel);

            // Update global result
            res = Math.max(res, Math.max(noDel, oneDel));
        }

        return res;
    }
}
