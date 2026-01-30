class Solution {
    public int minLengthAfterRemovals(String s) {
        int aCount = 0, bCount = 0;
        for (char c : s.toCharArray()) {
            if (c == 'a') {
                aCount++;
            } else {
                bCount++;
            }
        }

        return Math.abs(bCount - aCount);
    }
}