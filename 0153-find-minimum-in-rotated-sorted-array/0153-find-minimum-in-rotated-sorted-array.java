class Solution {
    public int findMin(int[] nums) {
        int min = Integer.MAX_VALUE;

        for(int n: nums){
            min = Math.min(n, min);
        }

        return min;
    }
}