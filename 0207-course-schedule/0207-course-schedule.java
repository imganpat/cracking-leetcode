class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] p : prerequisites) {
            graph.get(p[1]).add(p[0]);
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] path = new boolean[numCourses];

        for (int course = 0; course < numCourses; course++) {
            if (hasCycle(course, graph, visited, path)) {
                return false;
            }
        }

        return true;
    }

    private boolean hasCycle(
        int course,
        List<List<Integer>> graph,
        boolean[] visited,
        boolean[] path
    ) {
        // We're visiting this course again in the same DFS path
        if (path[course]) {
            return true;
        }

        // Already completely explored
        if (visited[course]) {
            return false;
        }

        visited[course] = true;
        path[course] = true;

        for (int next : graph.get(course)) {
            if (hasCycle(next, graph, visited, path)) {
                return true;
            }
        }

        // Backtrack
        path[course] = false;

        return false;
    }
}