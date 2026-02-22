// Approach: Binary Search on Answer + Greedy Placement
// 1. Sort the positions so we can place balls from left to right.
// 2. The minimum possible distance = 1, and the maximum = lastPosition - firstPosition.
// 3. Use binary search to guess a minimum distance `mid` between balls.
// 4. For each guessed distance, greedily try placing balls:
//    - Place the first ball at position[0].
//    - Place the next ball only if the distance from the last placed ball ≥ mid.
//    - Count how many balls can be placed.
// 5. If we can place at least m balls, this distance is feasible → try a larger distance.
//    Otherwise, reduce the distance.
// 6. The largest feasible distance found during the search is the answer.
//
// Time complexity: O(n log D)
//   - n = number of positions
//   - D = max possible distance range
//   - Sorting takes O(n log n), each binary check scans O(n)
// Space complexity: O(1) – only constant extra variables used (excluding sorting)

class Solution {

    // Helper: checks if we can place m balls with at least distance b
    public boolean canDistribute(int[] position, int m, int b) {
        int count = 1;              // first ball placed at first position
        int last = position[0];

        for (int i = 1; i < position.length; i++) {
            if (position[i] - last >= b) {
                last = position[i];
                count++;
            }
        }

        return count >= m;
    }

    public int maxDistance(int[] position, int m) {
        // Step 1: Sort positions for greedy placement
        Arrays.sort(position);

        int res = 0;
        int low = 1;
        int high = position[position.length - 1] - position[0];

        // Step 2: Binary search for largest feasible minimum distance
        while (low <= high) {
            int mid = (low + high) / 2;

            if (canDistribute(position, m, mid)) {
                res = Math.max(mid, res); // distance works → try bigger
                low = mid + 1;
            } else {
                high = mid - 1;           // distance too large → shrink
            }
        }

        return res;
    }
}