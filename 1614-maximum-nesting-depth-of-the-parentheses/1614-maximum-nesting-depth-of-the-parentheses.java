class Solution {
    public int maxDepth(String s) {
        int maxCount = 0;
        int count = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                count++;
                maxCount = Math.max(maxCount, count);
            } else if (c == ')') {
                count--;
            }
        }

        return maxCount;
    }
}