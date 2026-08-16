// Approach: DFS + Cycle Detection
// 1. Build a directed graph where:
//      prerequisite -> course
//    For example, [1, 0] means:
//      0 -> 1
// 2. A cycle means we have circular prerequisites,
//    so it is impossible to finish all courses.
// 3. Use two boolean arrays:
//      visited[] -> course has already been completely explored.
//      path[]    -> course is currently present in the
//                   active DFS path.
// 4. During DFS:
//      - If path[course] is already true, we found a cycle.
//      - If visited[course] is true, this course was already
//        explored and no cycle was found through it.
// 5. Mark the current course as both visited and part of
//    the current DFS path.
// 6. Recursively explore all courses that depend on it.
// 7. After exploring all neighbors, remove the course from
//    the current DFS path using backtracking.
// 8. If no cycle is found in any component, all courses can
//    be completed.
//
// Time complexity: O(V + E)
//   - V = number of courses
//   - E = number of prerequisites
// Space complexity: O(V + E)
//   - Adjacency list + visited/path arrays + recursion stack

class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List<List<Integer>> graph = new ArrayList<>();

        // Create adjacency list
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // prerequisite -> course
        for (int[] p : prerequisites) {
            graph.get(p[1]).add(p[0]);
        }

        boolean[] visited = new boolean[numCourses];

        // Tracks the current DFS path
        boolean[] path = new boolean[numCourses];

        // Graph can be disconnected
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
            boolean[] path) {

        // Course appears again in the current DFS path
        if (path[course]) {
            return true;
        }

        // Already completely explored
        if (visited[course]) {
            return false;
        }

        visited[course] = true;
        path[course] = true;

        // Explore dependent courses
        for (int next : graph.get(course)) {

            if (hasCycle(next, graph, visited, path)) {
                return true;
            }
        }

        // Backtrack:
        // course is no longer in the current DFS path
        path[course] = false;

        return false;
    }
}