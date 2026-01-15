class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals.length == 0){
            return new int[][] {newInterval};
        }

        List<int[]> temp = new ArrayList<>();

        boolean inserted = false;
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] >= newInterval[0] && !inserted) {
                temp.add(newInterval);
                inserted = true;
            }
            temp.add(intervals[i]);
        }

        if(!inserted){
            temp.add(newInterval);
        }

        int start1 = temp.get(0)[0];
        int end1 = temp.get(0)[1];
        List<int[]> res = new ArrayList<>();

        for (int i = 1; i < temp.size(); i++) {
            int start2 = temp.get(i)[0];
            int end2 = temp.get(i)[1];
            
            if (end1 >= start2) {
                end1 = Math.max(end1, end2);
            } else {
                res.add(new int[] { start1, end1 });
                start1 = start2;
                end1 = end2;
            }
        }
        res.add(new int[] { start1, end1 });
        
        return res.toArray(new int[res.size()][]);

    }
}