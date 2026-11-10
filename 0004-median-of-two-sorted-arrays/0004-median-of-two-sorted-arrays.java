class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> nums = new ArrayList<>();

        int i = 0;
        int j = 0;

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                nums.add(nums1[i++]);
            }  else {
                nums.add(nums2[j++]);
            }
        }

        while(i < nums1.length) {
            nums.add(nums1[i++]);
        }

        while(j < nums2.length) {
            nums.add(nums2[j++]);
        }


        int n = nums.size();

        if (n % 2 != 0) {
            return nums.get(n / 2);
        } else {
            int x = n / 2 - 1;
            int y = x + 1;

            return (nums.get(x) + nums.get(y)) / 2.0; 
        }
    }
}