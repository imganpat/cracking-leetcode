class Solution {
    public int minimumPushes(String word) {
        int n = word.length();
        int res = 0;
        int count = 0; 
        int pressTime = 1;

        for (int i = 0; i < n; i++) {
            count++;
            if (count == 8) {
                res += count * pressTime;
                count = 0;
                pressTime++;
            }
        }

        res += count * pressTime;
        return res;
    }
}