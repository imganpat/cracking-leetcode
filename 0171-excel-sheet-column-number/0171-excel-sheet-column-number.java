class Solution {
    public int titleToNumber(String columnTitle) {
        int res = 0;
        int n = columnTitle.length();

        for (int i = 0; i < n; i++) {
            int power = n - 1 - i;
            int curr = columnTitle.charAt(i) - 'A' + 1;

            res += curr * Math.pow(26, power);
        }

        return res;
    }
}