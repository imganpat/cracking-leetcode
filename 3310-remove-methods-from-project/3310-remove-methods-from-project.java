// Approach: DFS + Reachability
// 1. Build the directed graph where:
//      u -> v
//    means method u invokes method v.
// 2. Starting from the suspicious method k,
//    perform DFS to find every reachable method.
//    All reachable methods are also suspicious.
// 3. After collecting all suspicious methods,
//    check every invocation:
//      - If a non-suspicious method invokes a suspicious one,
//        then the suspicious methods cannot be removed.
//        Return all methods.
// 4. Otherwise, all suspicious methods can be removed.
//    Return only the remaining (non-suspicious) methods.
//
// Time complexity: O(n + m)
//   - O(n + m) for DFS
//   - O(m) to validate invocations
// Space complexity: O(n + m)
//   - Adjacency list + visited/suspicious sets

class Solution {
    List<List<Integer>> adj;

    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        Set<Integer> visited = new HashSet<>();
        Set<Integer> suspicious = new HashSet<>();

        adj = new ArrayList<>();

        // Build graph
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] invocation : invocations) {
            int u = invocation[0];
            int v = invocation[1];

            adj.get(u).add(v);
        }

        // Find all suspicious methods
        getSuspicious(k, suspicious, visited);

        // Check whether any safe method
        // calls a suspicious method
        for (int[] invocation : invocations) {
            int u = invocation[0];
            int v = invocation[1];

            if (!suspicious.contains(u) && suspicious.contains(v)) {
                List<Integer> ans = new ArrayList<>();
                for (int method = 0; method < n; method++) {
                    ans.add(method);
                }

                return ans;
            }
        }

        // Return remaining methods
        List<Integer> ans = new ArrayList<>();
        for (int method = 0; method < n; method++) {
            if (!suspicious.contains(method)) {
                ans.add(method);
            }
        }

        return ans;
    }

    private void getSuspicious(int node, Set<Integer> suspicious, Set<Integer> visited) {
        visited.add(node);
        suspicious.add(node);

        for (int neighbour : adj.get(node)) {
            if (!visited.contains(neighbour)) {
                getSuspicious(neighbour, suspicious, visited);
            }
        }
    }
}