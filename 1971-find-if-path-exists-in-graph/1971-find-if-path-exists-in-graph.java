class Solution {
    private List<List<Integer>> adj;
    private boolean[] visited;

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        adj = new ArrayList<>();
        visited = new boolean[n];

        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] edge: edges) {
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        dfs(source, destination);

        return visited[destination];
    }

    private void dfs(int source, int destination) {
        visited[source] = true;

        for (int neighbour: adj.get(source)) {
            if (!visited[neighbour]) {
                dfs(neighbour, destination);
            }
        }
    }
}