class Solution {
    public int maximumCount(int[] nums) {
        int posCount = 0;
        int negCount = 0;
        for(int n: nums){
            if (n > 0){
                posCount++;
            }
            else if(n < 0){
                negCount++;
            }
        }

        return Math.max(negCount, posCount);
    }
}