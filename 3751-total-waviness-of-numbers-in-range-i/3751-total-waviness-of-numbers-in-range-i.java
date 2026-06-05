class Solution {
    public int totalWaviness(int num1, int num2) {
        int count = 0;

        for (int n = num1; n <= num2; n++) {
            String s = n + "";

            for (int i = 1; i < s.length() - 1; i++) {
                char c = s.charAt(i);

                if ((c > s.charAt(i - 1) && c > s.charAt(i + 1)
                        || (c < s.charAt(i - 1) && c < s.charAt(i + 1)))) {
                    
                    count++;
                }
            }
        }

        return count;
    }
}