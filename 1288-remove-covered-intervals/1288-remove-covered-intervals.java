class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) {
                return Integer.compare(b[1], a[1]);
            }
            return Integer.compare(a[0], b[0]);
        });

        int count = 1;
        int end1 = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            int end2 = intervals[i][1];
            if (end1 < end2) {
                count++;
                end1 = end2;
            }
        }
        
        return count;
    }
}