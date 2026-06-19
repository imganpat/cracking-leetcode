class Solution {
    public int[] countPoints(int[][] points, int[][] queries) {
        int [] answer = new int[queries.length];

        for(int i = 0; i < queries.length; i++) {
            int cx = queries[i][0];
            int cy = queries[i][1];
            int r = queries[i][2];
            int count = 0;

            for (int j = 0; j < points.length; j++) {
                int dx = points[j][0] - cx;
                int dy = points[j][1] - cy;

                if (dx * dx + dy * dy <= r * r) {
                    count++;
                }
            }

            answer[i] = count;
        }

        return answer;
    }
 }