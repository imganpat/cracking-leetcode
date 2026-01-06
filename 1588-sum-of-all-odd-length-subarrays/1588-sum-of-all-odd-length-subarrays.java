class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                for (int k = i; k <= j; k++) {
                    int len = j - i + 1;
                    if(len % 2 == 1){
                        sum += arr[k];
                    }
                }
            }
        }
        return sum;
    }
}