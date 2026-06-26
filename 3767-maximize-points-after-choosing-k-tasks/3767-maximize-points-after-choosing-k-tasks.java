// Approach: Greedy + Min Heap
// 1. For each index, choose the technique that gives more points.
//    - If technique1 >= technique2:
//         • Take technique1.
//         • Count one usage of technique1.
//    - Otherwise:
//         • Take technique2.
//         • Store the extra gain (technique2 - technique1) in a min heap.
// 2. After processing all indices:
//    - If we already selected k or more elements from technique1,
//      the answer is ready.
//    - Otherwise, we must switch some choices from technique2 to technique1.
// 3. Each switch decreases the score by:
//      technique2 - technique1
// 4. To minimize the loss, always switch the smallest differences first.
//    A min heap gives these differences efficiently.
// 5. Perform exactly (k - count) switches and return the final score.
//
// Time complexity: O(n log n)
//   - Heap insertions and removals
// Space complexity: O(n)
//   - Min heap

class Solution {

    public long maxPoints(int[] technique1,
                          int[] technique2,
                          int k) {

        long res = 0;

        // Number of times technique1 is already chosen
        int count = 0;

        // Stores extra gain of choosing technique2 over technique1
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Greedily choose the larger value
        for (int i = 0; i < technique1.length; i++) {

            if (technique1[i] >= technique2[i]) {

                res += technique1[i];
                count++;

            } else {

                res += technique2[i];

                pq.offer(technique2[i] - technique1[i]);
            }
        }

        // Number of mandatory switches to technique1
        int need = k - count;

        while (need > 0) {

            // Lose the minimum possible points
            res -= pq.poll();

            need--;
        }

        return res;
    }
}