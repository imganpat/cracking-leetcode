class Solution {
    public int scheduleCourse(int[][] courses) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        for (int[] course : courses) {
            minHeap.offer(course);
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        int days = 0;
        while (!minHeap.isEmpty()) {
            int[] top = minHeap.poll();
            days += top[0];
            maxHeap.offer(top[0]);

            if (days > top[1]) {
                days -= maxHeap.poll();
            }
        }

        return maxHeap.size();
    }
}