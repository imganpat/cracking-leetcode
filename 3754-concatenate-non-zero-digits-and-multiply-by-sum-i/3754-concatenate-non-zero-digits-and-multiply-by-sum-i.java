class Solution {
    public long sumAndMultiply(int n) {
        String s = String.valueOf(n).replace("0", "");
        long sum = 0;

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            sum += c - '0';
        }

        long x = s.isEmpty() ? 0: sum * Long.parseLong(s);

        return x;
    }
}