class Solution {
    public int countPartitions(int[] nums) {
        int n = nums.length;       
        int[] prefixSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }

        int count = 0;
        for(int i = 1; i < n; i++){
            int right = prefixSum[n] - prefixSum[i];
            if((prefixSum[i] - right) % 2 == 0){
                count++;
            }
        }
        return count;
    }
}