class Solution {
    public int minPartitions(String n) {
        int res = n.charAt(0) - '0';

        for (char c: n.toCharArray()) {
            res = Math.max(c - '0', res);
        }

        return res;
    }
}