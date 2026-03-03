import java.util.*;

class Solution {

    public int[] getFinalState(int[] nums, int k, int multiplier) {

        // Min heap storing {value, index}
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> {
                    if (a[0] == b[0]) {
                        return a[1] - b[1]; // tie-break by index
                    }
                    return a[0] - b[0];
                });

        // Add elements with index
        for (int i = 0; i < nums.length; i++) {
            pq.add(new int[] { nums[i], i });
        }

        // Perform k operations
        while (k > 0) {
            int[] smallest = pq.poll();
            smallest[0] *= multiplier; // multiply value
            pq.add(smallest); // push back
            k--;
        }

        // Build final result array
        int[] result = new int[nums.length];

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            result[curr[1]] = curr[0];
        }

        return result;
    }
}