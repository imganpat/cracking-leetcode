// Approach: Sorting + Greedy + Max Heap
// 1. Combine capital and profit into a single array of projects.
// 2. Sort projects based on required capital in ascending order.
// 3. Use a max heap to store profits of all projects that can be afforded
//    with the current capital (w).
// 4. Maintain a pointer `i` to iterate through sorted projects:
//    - Add all projects where capital ≤ w into the max heap.
// 5. For at most k steps:
//    - Pick the project with the maximum profit from the heap.
//    - Add its profit to current capital (w).
//    - Repeat the process.
// 6. If at any step no project is available, break early.
// 7. Return the final capital.
//
// Time complexity: O(n log n + k log n)
//   - Sorting takes O(n log n)
//   - Each project is pushed once → O(n log n)
//   - Up to k heap operations → O(k log n)
// Space complexity: O(n) – for projects array and heap

class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {

        int n = profits.length;

        // Step 1: Combine capital and profit
        int[][] projects = new int[n][2];
        for (int i = 0; i < n; i++) {
            projects[i][0] = capital[i];
            projects[i][1] = profits[i];
        }

        // Step 2: Sort by capital requirement
        Arrays.sort(projects, (a, b) -> a[0] - b[0]);

        // Step 3: Max heap to pick highest profit
        PriorityQueue<Integer> maxHeap =
                new PriorityQueue<>((a, b) -> b - a);

        int i = 0;

        // Step 4: Perform up to k selections
        for (int step = 0; step < k; step++) {

            // Add all affordable projects to heap
            while (i < n && w >= projects[i][0]) {
                maxHeap.offer(projects[i][1]);
                i++;
            }

            // If no project available, stop early
            if (maxHeap.isEmpty()) {
                break;
            }

            // Select most profitable project
            w += maxHeap.poll();
        }

        return w;
    }
}