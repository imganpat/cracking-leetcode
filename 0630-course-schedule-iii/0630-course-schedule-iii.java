// Approach: Greedy + Sorting by Deadline + Max Heap
// 1. Sort all courses by their deadline (end day) in ascending order.
// 2. Iterate through each course in this order.
// 3. Maintain a max heap that stores durations of selected courses.
// 4. Keep track of total time (days) spent so far.
// 5. For each course:
//    - Add its duration to total days and push it into the heap.
//    - If total days exceed the current course’s deadline,
//      remove the course with the longest duration from the heap.
// 6. This ensures we keep the maximum number of courses while staying within deadlines.
// 7. The size of the heap gives the maximum number of courses that can be taken.
//
// Time complexity: O(n log n)
//   - Sorting: O(n log n)
//   - Heap operations: O(n log n)
// Space complexity: O(n) – for the max heap

class Solution {
    public int scheduleCourse(int[][] courses) {

        // Step 1: Sort courses by deadline
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);

        // Step 2: Max heap to store durations
        PriorityQueue<Integer> maxHeap =
                new PriorityQueue<>((a, b) -> b - a);

        int days = 0;

        // Step 3: Process each course
        for (int[] c : courses) {

            // Add current course duration
            days += c[0];
            maxHeap.offer(c[0]);

            // If deadline exceeded, remove the longest course taken so far
            if (days > c[1]) {
                days -= maxHeap.poll();
            }
        }

        // Step 4: Number of courses successfully taken
        return maxHeap.size();
    }
}