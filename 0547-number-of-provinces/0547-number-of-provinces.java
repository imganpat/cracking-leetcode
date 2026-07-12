class Solution {
    int m;
    int n;
    List<List<Integer>> adj;
    boolean[] visited;

    public int findCircleNum(int[][] isConnected) {
        m = isConnected.length;
        n = isConnected[0].length;
        adj = new ArrayList<>();
        visited = new boolean[m];

        for (int i = 0; i < m; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && isConnected[i][j] == 1) {
                    adj.get(i).add(j);
                }
            }
        }

        int res = 0;

        for (int i = 0; i < m; i++) {
            if (!visited[i]) {
                res++;
                dfs(i);
            }
        }

        return res;
    }

    private void dfs(int node) {
        visited[node] = true;

        for (int neighbour: adj.get(node)){
            if (!visited[neighbour]) {
                dfs(neighbour);
            }
        }
    }
}