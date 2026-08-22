// Approach: Kahn's Algorithm + Ancestor Set Propagation
// 1. Build the directed graph and calculate indegrees.
// 2. Start BFS with all nodes having indegree 0.
//    These nodes have no ancestors.
// 3. When processing an edge curr -> next:
//      - curr is an ancestor of next.
//      - Every ancestor of curr is also an ancestor of next.
//    Therefore, propagate all ancestors from curr to next.
// 4. Decrease next's indegree.
//    Once its indegree becomes 0, all of its parents have
//    been processed, so it can safely enter the queue.
// 5. Finally, convert every ancestor set to a list and sort it,
//    because the answer requires ancestors in increasing order.
//
// Time complexity: O(V + E + propagation + sorting)
//   - Graph construction: O(V + E)
//   - Each ancestor can potentially be propagated across edges.
//   - Final sorting ensures the required order.
//
// Space complexity: O(V + E)
//   - Graph + ancestor sets + queue

class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[n];

        // Build graph
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];

            graph.get(from).add(to);
            indegree[to]++;
        }

        Deque<Integer> queue = new ArrayDeque<>();

        List<Set<Integer>> ancestors = new ArrayList<>();

        // Initialize ancestor sets
        // and add source nodes to the queue
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }

            ancestors.add(new HashSet<>());
        }

        // Topological traversal
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int next : graph.get(curr)) {

                // curr is an ancestor of next
                ancestors.get(next).add(curr);

                // Every ancestor of curr is also
                // an ancestor of next
                for (int ancestor : ancestors.get(curr)) {
                    ancestors.get(next).add(ancestor);
                }

                indegree[next]--;

                // All parents of next have been processed
                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        // Convert sets to sorted lists
        List<List<Integer>> result = new ArrayList<>();
        for (Set<Integer> set : ancestors) {
            List<Integer> list = new ArrayList<>(set);
            Collections.sort(list);
            result.add(list);
        }

        return result;
    }
}