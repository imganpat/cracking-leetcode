class Solution {
    public long getDescentPeriods(int[] prices) {
        long count = 0;
        int j = 0;

        for(int i = 0; i < prices.length; i++){
            if(i > 0 && prices[i] - prices[i-1] != -1){
                j = i;
            }
            count += i - j + 1;
        }

        return count;
    }
}