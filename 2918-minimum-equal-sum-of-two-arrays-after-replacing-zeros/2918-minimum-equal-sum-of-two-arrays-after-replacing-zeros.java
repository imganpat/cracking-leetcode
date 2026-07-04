// Approach: Greedy + Minimum Possible Sum
// 1. Every 0 must be replaced by a positive integer.
// 2. To minimize the total sum, replace each 0 with 1.
// 3. Compute the minimum possible sum for each array:
//      sum + numberOfZeros
// 4. Compare the two minimum sums.
//
//    Case 1:
//      Minimum sums are equal.
//      -> This is already the smallest achievable answer.
//
//    Case 2:
//      One minimum sum is smaller.
//      -> It can only be increased if that array
//         contains at least one zero.
//      -> Increase one of its replaced values until
//         both sums become equal.
//
//    Case 3:
//      Smaller-sum array has no zero.
//      -> Its sum is fixed.
//      -> Equalization is impossible.
//
// 5. Return the minimum achievable equal sum,
//    otherwise return -1.
//
// Time complexity: O(n + m)
//   - One pass through each array
// Space complexity: O(1)

class Solution {

    public long minSum(int[] nums1, int[] nums2) {

        int zerosInNums1 = 0;
        int zerosInNums2 = 0;

        long minSumOfNums1 = 0;
        long minSumOfNums2 = 0;

        // Minimum possible sum of nums1
        for (int num : nums1) {

            minSumOfNums1 += num;

            if (num == 0) {
                zerosInNums1++;

                // Replace 0 with 1
                minSumOfNums1++;
            }
        }

        // Minimum possible sum of nums2
        for (int num : nums2) {

            minSumOfNums2 += num;

            if (num == 0) {
                zerosInNums2++;

                // Replace 0 with 1
                minSumOfNums2++;
            }
        }

        // Already equal
        if (minSumOfNums1 == minSumOfNums2) {
            return minSumOfNums1;
        }

        // nums1 can still be increased
        if (minSumOfNums1 < minSumOfNums2 &&
            zerosInNums1 > 0) {

            return minSumOfNums2;
        }

        // nums2 can still be increased
        if (minSumOfNums2 < minSumOfNums1 &&
            zerosInNums2 > 0) {

            return minSumOfNums1;
        }

        // Impossible
        return -1;
    }
}