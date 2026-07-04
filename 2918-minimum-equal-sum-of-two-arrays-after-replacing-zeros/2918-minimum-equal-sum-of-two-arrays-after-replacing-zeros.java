class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        int zerosInNums1 = 0;
        int zerosInNums2 = 0;
        long minSumOfNums1 = 0;
        long minSumOfNums2 = 0;

        for (int num: nums1) {
            minSumOfNums1 += num;

            if (num == 0) {
                zerosInNums1++;
                minSumOfNums1++;
            }
        }

        for (int num: nums2) {
            minSumOfNums2 += num;

            if (num == 0) {
                zerosInNums2++;
                minSumOfNums2++;
            }
        }

        if (minSumOfNums1 == minSumOfNums2) {
            return minSumOfNums1;
        }

        if (minSumOfNums1 < minSumOfNums2 && zerosInNums1 >= 1) {
            return minSumOfNums2;
        }

        if (minSumOfNums2 < minSumOfNums1 && zerosInNums2 >= 1) {
            return minSumOfNums1;
        }

        return -1;
    }
}