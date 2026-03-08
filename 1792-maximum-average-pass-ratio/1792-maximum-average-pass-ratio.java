// Approach: Greedy + Max Heap (Priority Queue)
// 1. Define a helper function `gain(pass, total)` that calculates how much the pass ratio
//    increases if we add one extra passing student to that class.
// 2. Use a max heap (priority queue) to always pick the class with the maximum gain.
// 3. Insert each class into the heap as {gain, pass, total}.
// 4. While extraStudents > 0:
//      - Extract the class with the highest gain.
//      - Add one passing student to that class (pass++, total++).
//      - Recalculate the gain and push the updated class back into the heap.
// 5. After distributing all extra students, compute the average pass ratio
//    of all classes by summing pass/total values.
// 6. Return the average ratio.
//
// Time complexity: O((n + extraStudents) log n)
//   - n insertions into heap
//   - extraStudents heap operations
// Space complexity: O(n) – heap stores all classes

class Solution {

    // Helper function to compute improvement in pass ratio
    public double gain(int pass, int total) {
        double before = (double) pass / total;
        double after = (double) (pass + 1) / (total + 1);
        return after - before;
    }

    public double maxAverageRatio(int[][] classes, int extraStudents) {

        // Max heap based on gain
        PriorityQueue<double[]> pq =
                new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));

        // Step 1: Initialize heap
        for (int[] cls : classes) {
            int pass = cls[0];
            int total = cls[1];
            double gain = gain(pass, total);

            pq.add(new double[]{gain, pass, total});
        }

        // Step 2: Assign extra students greedily
        while (extraStudents > 0) {
            double[] top = pq.poll();

            int pass = (int) top[1];
            int total = (int) top[2];

            pass++;
            total++;

            double gain = gain(pass, total);

            pq.add(new double[]{gain, pass, total});

            extraStudents--;
        }

        // Step 3: Compute final average ratio
        double sum = 0;
        while (!pq.isEmpty()) {
            double[] c = pq.poll();
            int pass = (int) c[1];
            int total = (int) c[2];

            sum += (double) pass / total;
        }

        return sum / classes.length;
    }
}