class Solution {
    boolean[] visited;

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        visited = new boolean[n];

        int res = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                res++;
                dfs(isConnected, i);
            }
        }

        return res;
    }

    private void dfs(int[][] graph, int node) {
        visited[node] = true;

        for (int neighbour = 0; neighbour < graph[0].length; neighbour++){
            if (graph[node][neighbour] == 1 && !visited[neighbour]) {
                dfs(graph, neighbour);
            }
        }
    }
}