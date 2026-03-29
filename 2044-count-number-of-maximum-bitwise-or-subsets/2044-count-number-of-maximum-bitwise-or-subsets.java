class Solution {
    int count = 0;

    public int getMaxOr(int[] nums){
        int or = 0;
        for(int n : nums){
            or |= n;
        }
        return or;
    }

    public void backtrack(int[] nums, int i, int currOr, int maxOr){
        if(i == nums.length){
            if(currOr == maxOr){
                count++;
            }
            return;
        }

        backtrack(nums, i+1, currOr | nums[i], maxOr);
        
        backtrack(nums, i+1, currOr, maxOr);
    }

    public int countMaxOrSubsets(int[] nums) {
        int maxOr = getMaxOr(nums);

        backtrack(nums, 0, 0, maxOr);

        return count;
    }
}