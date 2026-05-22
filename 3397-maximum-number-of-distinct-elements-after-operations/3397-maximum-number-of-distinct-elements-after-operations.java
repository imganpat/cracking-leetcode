// Approach: Greedy + Sorting
// 1. Each number nums[i] can be changed to any value in range:
//      [nums[i] - k, nums[i] + k]
// 2. Sort the array so we process numbers in increasing order.
// 3. Greedily assign the smallest possible distinct value
//    for each number.
// 4. Maintain `prev` = last assigned value.
// 5. For current number:
//    - start = nums[i] - k
//    - end   = nums[i] + k
// 6. Choose:
//      max(prev + 1, start)
//    because:
//      - it must be greater than previous assigned value
//      - it must stay inside valid range
// 7. If chosen value <= end:
//    - assignment is valid
//    - increment distinct count
//    - update prev
// 8. Return total count.
//
// Time complexity: O(n log n)
//   - Sorting dominates
// Space complexity: O(1)
//   - Ignoring sorting overhead

class Solution {

    public int maxDistinctElements(int[] nums, int k) {

        // Step 1: Sort numbers
        Arrays.sort(nums);

        int count = 0;

        // Last assigned value
        int prev = Integer.MIN_VALUE;

        // Step 2: Greedily assign values
        for (int num : nums) {

            int start = num - k;
            int end = num + k;

            // Smallest valid distinct choice
            int choice = Math.max(prev + 1, start);

            // If assignment possible
            if (choice <= end) {
                count++;
                prev = choice;
            }
        }

        return count;
    }
}