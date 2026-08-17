// Approach: Kahn's Algorithm (BFS Topological Sort)
// 1. Build a directed graph:
//      prerequisite -> course
// 2. Calculate indegree of every course.
//    indegree[x] = number of prerequisites still required by x.
// 3. Add every course with indegree 0 to the queue.
//    These courses can be taken immediately.
// 4. Repeatedly:
//      - Remove a course from the queue.
//      - Add it to the result.
//      - "Complete" it by decreasing the indegree of
//        every course depending on it.
//      - If a course's indegree becomes 0,
//        add it to the queue.
// 5. If all courses are processed, we found a valid ordering.
// 6. If some courses remain, there is a cycle,
//    so return an empty array.
//
// Time complexity: O(V + E)
//   V = number of courses
//   E = number of prerequisites
//
// Space complexity: O(V + E)
//   Graph + indegree + queue + result

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[numCourses];

        // Create graph
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // Build edges:
        // prerequisite -> course
        for (int[] pre : prerequisites) {

            int course = pre[0];
            int prerequisite = pre[1];

            graph.get(prerequisite).add(course);

            indegree[course]++;
        }

        // Courses that have no remaining prerequisites
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        List<Integer> res = new ArrayList<>();

        // Topological sort
        while (!queue.isEmpty()) {
            int course = queue.poll();
            res.add(course);

            // Remove this course as a prerequisite
            for (int nextCourse : graph.get(course)) {
                indegree[nextCourse]--;
                if (indegree[nextCourse] == 0) {
                    queue.offer(nextCourse);
                }
            }
        }

        // Not all courses could be processed
        // -> cycle exists
        if (res.size() != numCourses) {
            return new int[0];
        }

        return res.stream()
                  .mapToInt(Integer::intValue)
                  .toArray();
    }
}