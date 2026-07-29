// Approach: DFS + Two Coloring
// 1. A graph is bipartite if its vertices can be divided
//    into two groups such that no two adjacent vertices
//    belong to the same group.
// 2. Maintain a color array:
//      -1 -> unvisited
//       0 -> first color
//       1 -> second color
// 3. Since the graph may be disconnected,
//    start a DFS from every unvisited node.
// 4. During DFS:
//      - Assign the current color to the node.
//      - For every neighbor:
//          • If it already has the same color,
//            the graph is not bipartite.
//          • Otherwise, if it is unvisited,
//            color it with the opposite color
//            and continue DFS.
// 5. If no coloring conflict is found,
//    the graph is bipartite.
//
// Time complexity: O(V + E)
//   - Every vertex and edge is visited once
// Space complexity: O(V)
//   - Color array + recursion stack

class Solution {

    boolean res = true;

    public boolean isBipartite(int[][] graph) {

        int n = graph.length;

        // -1 = unvisited
        //  0 = first color
        //  1 = second color
        List<Integer> colors = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            colors.add(-1);
        }

        // Handle disconnected graphs
        for (int i = 0; i < n; i++) {

            if (colors.get(i) == -1) {
                dfs(graph, i, 0, colors);
            }
        }

        return res;
    }

    private void dfs(int[][] graph,
                     int node,
                     int color,
                     List<Integer> colors) {

        colors.set(node, color);

        for (int neighbour : graph[node]) {

            // Adjacent nodes cannot have the same color
            if (colors.get(neighbour) != -1
                    && colors.get(neighbour) == color) {

                res = false;
                return;
            }

            // Color unvisited neighbor
            if (colors.get(neighbour) == -1) {

                dfs(graph,
                    neighbour,
                    1 - color,
                    colors);
            }
        }
    }
}