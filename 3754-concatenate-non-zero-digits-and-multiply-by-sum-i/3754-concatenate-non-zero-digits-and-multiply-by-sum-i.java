class Solution {
    public long sumAndMultiply(int n) {
        String s = n + "";
        StringBuilder sb = new StringBuilder();
        long sum = 0;

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c != '0') {
                sb.append(c);
                sum += c - '0';
            }
        }

        long x = sb.length() == 0 ? 0: sum * Long.parseLong(sb.toString());

        return x;
    }
}