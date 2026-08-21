// Approach: Reverse Graph + Kahn's Algorithm
// 1. A terminal node has no outgoing edges.
//    Therefore, its outdegree is 0.
// 2. Every terminal node is automatically safe.
// 3. Reverse every edge:
//      original: u -> v
//      reversed: v -> u
// 4. Start BFS from all terminal nodes.
// 5. When a safe node is removed from the queue,
//    reduce the outdegree of every node that points to it.
// 6. If one of those nodes reaches outdegree 0,
//    all of its outgoing neighbors are known to be safe,
//    so that node is also safe.
// 7. Continue until the queue is empty.
// 8. Sort the safe nodes because the problem requires
//    the answer in increasing order.
//
// Time complexity: O(V + E + V log V)
//   - O(V + E) for graph construction and BFS
//   - O(V log V) for sorting
//
// Space complexity: O(V + E)
//   - Reversed graph + queue + arrays

class Solution {

    public List<Integer> eventualSafeNodes(int[][] graph) {

        int n = graph.length;

        List<List<Integer>> reversed =
                new ArrayList<>();

        int[] outdegree = new int[n];

        // Create reversed graph
        for (int i = 0; i < n; i++) {
            reversed.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {

            // Number of outgoing edges
            outdegree[i] = graph[i].length;

            for (int neighbour : graph[i]) {

                // Original:
                // i -> neighbour
                //
                // Reversed:
                // neighbour -> i
                reversed.get(neighbour).add(i);
            }
        }

        Deque<Integer> queue = new ArrayDeque<>();

        List<Integer> res = new ArrayList<>();

        // Terminal nodes are initially safe
        for (int i = 0; i < n; i++) {

            if (outdegree[i] == 0) {
                queue.offer(i);
            }
        }

        // Kahn's algorithm
        while (!queue.isEmpty()) {

            int node = queue.poll();

            res.add(node);

            // Find nodes that point to this safe node
            for (int previous : reversed.get(node)) {

                outdegree[previous]--;

                // All outgoing edges of previous
                // now lead to safe nodes
                if (outdegree[previous] == 0) {
                    queue.offer(previous);
                }
            }
        }

        // Problem requires sorted order
        Collections.sort(res);

        return res;
    }
}