// Approach: Graph Traversal (Cycle Detection using Visited Array)
// 1. Treat the array as a directed graph:
//      i → nums[i]
// 2. Since nums contains values in range [0, n-1],
//    every index points to another valid index.
// 3. Start from each index and follow the chain:
//      i → nums[i] → nums[nums[i]] → ...
// 4. Use a visited array:
//    - If a node is already visited, stop traversal.
//    - This prevents processing the same cycle multiple times.
// 5. Count the length of the current chain.
// 6. Update the maximum length found.
// 7. Return the maximum cycle length.
//
// Time complexity: O(n)
//   - Each index is visited at most once
// Space complexity: O(n)
//   - Visited array

class Solution {

    public int arrayNesting(int[] nums) {

        int n = nums.length;

        boolean[] visited = new boolean[n];

        int maxLen = 0;

        for (int i = 0; i < n; i++) {

            int len = 0;
            int curr = i;

            // Traverse current cycle
            while (!visited[curr]) {
                visited[curr] = true;

                curr = nums[curr];

                len++;
            }

            maxLen = Math.max(maxLen, len);
        }

        return maxLen;
    }
}