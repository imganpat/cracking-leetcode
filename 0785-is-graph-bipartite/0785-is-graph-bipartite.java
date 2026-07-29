class Solution {
    boolean res = true;

    public boolean isBipartite(int[][] graph) {
        List<Integer> colors = new ArrayList<>();
        int n = graph.length;

        for (int i = 0; i < n; i++) {
            colors.add(-1);
        }


        for (int i = 0; i < n; i++) {
            if (colors.get(i) == -1) {
                dfs(graph, i, 0, colors);
            }
        }

        return res;
    }

    private void dfs(int[][] graph, int node, int color, List<Integer> colors) {
        colors.set(node, color);

        for (int neighbour: graph[node]) {
            if (colors.get(neighbour) != -1 && colors.get(neighbour) == color){
                res = false;
                return;
            }

            if (colors.get(neighbour) == -1) {
                dfs(graph, neighbour, 1 - color, colors);
            }
        }
    }
}