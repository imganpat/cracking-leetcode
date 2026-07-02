class Solution {
    public String baseNeg2(int n) {
        if (n == 0) {
            return "0";
        }

        StringBuilder res = new StringBuilder();

        while (n != 0) {
            int rem = Math.abs(n % 2);
            res.append(rem);
            n = (n - rem) / -2;
        }

        return res.reverse().toString();
    }
}