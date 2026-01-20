class Solution {
    public boolean increasingTriplet(int[] nums) {
        int s1 = Integer.MAX_VALUE, s2 = Integer.MAX_VALUE;

        for(int n: nums){
            if(n <= s1){
                s1 = n;
            }else if(n <= s2){
                s2 = n;
            }else{
                return true;
            }
        }

        return false;
    }
}