class Solution {
    public List<Boolean> checkIfPrerequisite(
            int numCourses,
            int[][] prerequisites,
            int[][] queries) {

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] pre : prerequisites) {
            int prerequisite = pre[0];
            int course = pre[1];

            graph.get(prerequisite).add(course);
        }

        boolean[][] reachable = new boolean[numCourses][numCourses];

        for (int i = 0; i < numCourses; i++) {
            dfs(i, i, graph, reachable);
        }

        List<Boolean> result = new ArrayList<>();

        for (int[] query : queries) {
            result.add(reachable[query[0]][query[1]]);
        }

        return result;
    }

    private void dfs(
            int src,
            int node,
            List<List<Integer>> graph,
            boolean[][] reachable) {
        
        reachable[src][node] = true;

        for (int next : graph.get(node)) {
            if (!reachable[src][next]) {
                dfs(src, next, graph, reachable);
            }
        }
    }
}