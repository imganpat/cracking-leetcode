// Approach: Backtracking / DFS on Directed Graph
// 1. Start DFS from source node (0).
// 2. Maintain a current path (list).
// 3. At each node:
//    - Add the node to the current path.
//    - If it is the target node (n - 1), add the path to result.
// 4. Otherwise, explore all neighbors recursively.
// 5. After exploring each neighbor, backtrack by removing the last node.
// 6. Continue until all paths from source to target are explored.
//
// Time complexity: O(2^n)
//   - In worst case (DAG), number of paths can be exponential
// Space complexity: O(n)
//   - Recursion depth + path storage

class Solution {

    public void backtrack(List<List<Integer>> res,
                          List<Integer> curr,
                          int node,
                          int[][] graph) {

        // Add current node to path
        curr.add(node);

        // If target reached, store path
        if (node == graph.length - 1) {
            res.add(new ArrayList<>(curr));
        } else {
            // Explore neighbors
            for (int next : graph[node]) {
                backtrack(res, curr, next, graph);
            }
        }

        // Backtrack: remove current node before returning
        curr.remove(curr.size() - 1);
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();

        backtrack(res, new ArrayList<>(), 0, graph);

        return res;
    }
}