class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int min = nums[0];
        int max = nums[0];
        int currMin = nums[0];
        int currMax = nums[0];
        int res = nums[0];

        for(int i = 1; i < nums.length; i++){
            currMin = Math.min(currMin + nums[i], nums[i]);
            min = Math.min(min, currMin);

            currMax = Math.max(currMax + nums[i], nums[i]);
            max = Math.max(max, currMax);
            
            res = Math.max(res, Math.max(max, Math.abs(min)));
        }
        
        return Math.abs(res);
    }
}   