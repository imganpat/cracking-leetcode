class Solution {
    public String stringHash(String s, int k) {
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < s.length(); i += k) {
            String sub = s.substring(i, i  +  k);
            int sum = 0;
            
            for (int j = 0; j < k; j++) {
                sum += (sub.charAt(j) - 'a');
            }

            res.append((char) ('a' + (sum % 26)));
        }

        return res.toString();
    }
}