// Approach: Binary Search on Answer (Capacity)
// 1. The minimum ship capacity must be at least the maximum single weight,
//    and at most the total sum of all weights.
// 2. Use binary search between [maxWeight, totalWeight] to guess a capacity.
// 3. For each guessed capacity, simulate shipping using the helper function `daysNeeded()`:
//    - Keep adding weights until capacity is exceeded, then start a new day.
//    - Count how many days are required.
// 4. If required days ≤ allowed days, try a smaller capacity (search left).
//    Otherwise, increase capacity (search right).
// 5. Continue until the smallest valid capacity is found and return it.
//
// Time complexity: O(n log S)
//   - n = number of weights
//   - S = sum of weights (search range)
//   - Each binary step scans the array once
// Space complexity: O(1) – only constant extra variables used

class Solution {

    // Helper function: calculates how many days are needed for a given capacity
    public int daysNeeded(int[] weights, int capacity) {
        int days = 1, load = 0;

        for (int w : weights) {
            // If adding this weight exceeds capacity, move to next day
            if (load + w > capacity) {
                days++;
                load = w;
            } else {
                load += w;
            }
        }

        return days;
    }

    public int shipWithinDays(int[] weights, int days) {
        int low = 0, high = 0;

        // Step 1: Determine search range
        for (int w : weights) {
            low = Math.max(low, w); // capacity must handle the heaviest item
            high += w;              // max capacity = sum of all weights
        }

        // Step 2: Binary search for minimum valid capacity
        while (low <= high) {
            int mid = low + (high - low) / 2;

            // If we can ship within allowed days, try smaller capacity
            if (daysNeeded(weights, mid) <= days) {
                high = mid - 1;
            } else {
                // Otherwise increase capacity
                low = mid + 1;
            }
        }

        // Step 3: 'low' is the smallest valid capacity
        return low;
    }
}
