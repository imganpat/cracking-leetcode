class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int start = 0, end = k - 1;
        int max = Integer.MIN_VALUE;

        for (int i = start; i <= end; i++) {
            max = Math.max(nums[i], max);
        }

        int[] res = new int[nums.length - k + 1];
        int i = 0;

        while (end < nums.length) {
            res[i] = max;
            i++;

            if (end + 1 < nums.length) {
                if (nums[start] == max) {
                    max = Integer.MIN_VALUE;
                    
                    for (int j = start + 1; j <= end + 1; j++) {
                        max = Math.max(nums[j], max);
                    }

                } else {
                    max = Math.max(nums[end + 1], max);
                }
            }
            
            start++;
            end++;
        }

        return res;
    }
}