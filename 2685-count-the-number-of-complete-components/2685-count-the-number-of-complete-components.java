class Solution {
    int vertexCount = 0;
    int degreeSum = 0;
    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        int m = edges.length;
        int res = 0;

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge: edges) {
            int u = edge[0];
            int v = edge[1];
            
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] visited = new boolean[adj.size()];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                vertexCount = 0;
                degreeSum = 0;

                dfs(adj, i, visited);

                int e = degreeSum / 2;
                int expect = vertexCount * (vertexCount - 1) / 2;

                if (e == expect) {
                    res++;
                }
            }
        }

        return res;
    }

    private void dfs(List<List<Integer>> adj, int node, boolean[] visited) {
        visited[node] = true;
        vertexCount++;
        degreeSum += adj.get(node).size();

        for (int neighbour: adj.get(node)) {
            if (!visited[neighbour]) {
                dfs(adj, neighbour, visited);
            }
        }
    }
}