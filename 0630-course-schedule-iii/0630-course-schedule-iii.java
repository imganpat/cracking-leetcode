class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        int days = 0;
        for (int[] c: courses) {
            days += c[0];
            maxHeap.offer(c[0]);

            if (days > c[1]) {
                days -= maxHeap.poll();
            }
        }

        return maxHeap.size();
    }
}