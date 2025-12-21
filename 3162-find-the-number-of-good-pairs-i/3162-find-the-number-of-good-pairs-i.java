class Solution {
    public int numberOfPairs(int[] nums1, int[] nums2, int k) {
        int count = 0;
        for(int n1: nums1){
            for(int n2: nums2){
                if(n1 % (k * n2) == 0){
                    count++;
                }
            }
        }
        return count;
    }
}