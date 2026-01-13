class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] temp = new int[intervals.length + 1][2];
        int i = 0;
        for(i = 0; i < intervals.length; i++){
            temp[i] = intervals[i];
        }
        temp[i] = newInterval;

        Arrays.sort(temp, Comparator.comparingInt(a -> a[0]));

        List<int[]> mergedIntervals = new ArrayList<>();
        mergedIntervals.add(temp[0]);

        for (i = 1; i < temp.length; i++) {
            int[] last = mergedIntervals.get(mergedIntervals.size() - 1);

            if (last[1] >= temp[i][0]) {
                last[1] = Math.max(last[1], temp[i][1]);
            } 
            else {
                mergedIntervals.add(temp[i]);
            }
        }

        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);

    }
}