class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        int days = 0;
        for (int i = 0; i < courses.length; i++) {
            days += courses[i][0];
            maxHeap.offer(courses[i][0]);

            if (days > courses[i][1]) {
                days -= maxHeap.poll();
            }
        }

        return maxHeap.size();
    }
}