class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int min = nums[0];
        int max = nums[0];
        int res = nums[0];
        int curr = nums[0];

        for(int i = 1; i < nums.length; i++){
            max += nums[i];
            if(max < 0){
                max = 0;
            }

            if(curr + nums[i] < nums[i]){
                curr += nums[i];
            }else{
                curr = nums[i];
            }

            if(curr < min){
                min = curr;
            }
            res = Math.max(res, Math.max(max, Math.abs(min)));
        }
        return Math.abs(res);
    }
}   