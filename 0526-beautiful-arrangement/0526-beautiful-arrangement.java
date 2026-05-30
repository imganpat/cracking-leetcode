// Approach: Backtracking + Constraint Checking
// 1. We need to build a permutation of numbers [1...n].
// 2. Position `pos` can only contain a number `num` if:
//      pos % num == 0
//      OR
//      num % pos == 0
// 3. Use a boolean[] used to track numbers already placed.
// 4. At each position:
//    - Try every unused number.
//    - If it satisfies the divisibility condition,
//      place it and recurse to the next position.
// 5. When all positions are filled (pos > n),
//    one valid arrangement is found.
// 6. Increment the count.
// 7. Backtrack by removing the number and marking it unused.
//
// Time complexity: O(n!)
//   - In worst case, explores permutations
//   - Pruning significantly reduces actual work
// Space complexity: O(n)
//   - Recursion depth + used array

class Solution {
    int count = 0;

    public int countArrangement(int n) {
        backtrack(1, n, new boolean[n + 1]);
        return count;
    }

    public void backtrack(int pos,
            int n,
            boolean[] used) {

        // Valid arrangement formed
        if (pos > n) {
            count++;
            return;
        }

        // Try every number
        for (int num = 1; num <= n; num++) {

            // Number unused and satisfies condition
            if (!used[num] &&
                    (pos % num == 0 || num % pos == 0)) {

                // Choose
                used[num] = true;

                // Explore
                backtrack(pos + 1, n, used);

                // Backtrack
                used[num] = false;
            }
        }
    }
}