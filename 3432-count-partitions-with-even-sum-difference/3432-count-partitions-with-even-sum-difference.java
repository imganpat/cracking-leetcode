class Solution {
    public int countPartitions(int[] nums) {
        int n = nums.length;       
        int[] prefixSum = new int[n + 1], suffixSum = new int[n + 1];
        for (int i = 0, j = n - 1; i < n; i++, j--) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
            suffixSum[j] = suffixSum[j+1] + nums[j];
        }

        int count = 0;
        for(int i = 1; i < n; i++){
            if((prefixSum[i] - suffixSum[i]) % 2 == 0){
                count++;
            }
        }
        return count;
    }
}