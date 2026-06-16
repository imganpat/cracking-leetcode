class Solution {
    public int minPartitions(String n) {
        int res = n.charAt(0) - '0';
        int len = n.length();

        for (int i = 1; i < len; i++) {
            int c = n.charAt(i) - '0';
            res = res < c ? c : res;
        }

        return res;
    }
}