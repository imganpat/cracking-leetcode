class Solution {
    List<List<Integer>> graph;

    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (List<Integer> edge: edges) {
            int u = edge.get(0);
            int v = edge.get(1);

            graph.get(u).add(v);
        }

        int[] indegree = new int[n];
        for (int u = 0; u < n; u++) {
            for (int v: graph.get(u)) {
                indegree[v]++;
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                res.add(i);
            }
        }

        return res;
    }
}