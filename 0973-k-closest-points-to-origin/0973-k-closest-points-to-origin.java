// Approach: Max Heap (Keep k Closest Points)
// 1. For each point, compute its squared distance from origin: (x^2 + y^2).
//    - We use squared distance to avoid unnecessary sqrt computation.
// 2. Maintain a max heap of size k:
//    - Store {distance, point}.
//    - The heap keeps the k closest points seen so far.
// 3. For each point:
//    - Add it to the heap.
//    - If heap size exceeds k, remove the farthest point (max distance).
// 4. At the end, the heap contains k closest points.
// 5. Extract them into the result array.
//
// Time complexity: O(n log k)
//   - n = number of points
//   - Heap operations take O(log k)
// Space complexity: O(k) – heap stores at most k elements

class Solution {

    // Helper class to store distance and point
    class Pair {
        int key; // distance
        int[] values; // point [x, y]

        Pair(int key, int[] values) {
            this.key = key;
            this.values = values;
        }
    }

    public int[][] kClosest(int[][] points, int k) {

        // Max heap based on distance
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a, b) -> b.key - a.key);

        // Step 1: Process each point
        for (int[] point : points) {
            int x = point[0];
            int y = point[1];

            // Compute squared distance
            int dist = x * x + y * y;

            maxHeap.offer(new Pair(dist, new int[] { x, y }));

            // Maintain heap size ≤ k
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        // Step 2: Extract results
        int[][] res = new int[k][2];
        int i = 0;

        while (!maxHeap.isEmpty()) {
            res[i++] = maxHeap.poll().values;
        }

        return res;
    }
}