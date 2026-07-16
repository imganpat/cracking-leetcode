// Approach: Connected Components by Consecutive Differences
// 1. Since nums is sorted, adjacent elements are connected
//    if their difference is at most maxDiff.
// 2. Build connected components:
//      - Start component 0 at index 0.
//      - Traverse the array.
//      - If nums[i] - nums[i-1] <= maxDiff,
//        current index belongs to the same component.
//      - Otherwise, start a new component.
// 3. Store the component id for every index.
// 4. For each query (u, v):
//      - If both indices belong to the same component,
//        a path exists.
//      - Otherwise, no path exists.
// 5. Return the answers.
//
// Time complexity: O(n + q)
//   - O(n) to build components
//   - O(q) to answer queries
// Space complexity: O(n)
//   - Component array

class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        // Component id for each index
        int[] component = new int[n];

        int comp = 0;

        component[0] = comp;

        // Assign component ids
        for (int i = 1; i < n; i++) {
            if (nums[i] - nums[i - 1] <= maxDiff) {
                component[i] = comp;
            } else {
                component[i] = ++comp;
            }
        }

        int qn = queries.length;

        boolean[] res = new boolean[qn];

        // Answer queries
        for (int i = 0; i < qn; i++) {
            int u = queries[i][0];
            int v = queries[i][1];

            res[i] = component[u] == component[v];
        }

        return res;
    }
}