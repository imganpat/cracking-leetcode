class Solution {
    public int missingNumber(int[] nums) {
        int numsSum = 0;
        int naturalSum = nums.length;
        for(int i = 0; i < nums.length; i++){
            naturalSum += i;
            numsSum += nums[i];
        }

        return naturalSum - numsSum;
    }
}