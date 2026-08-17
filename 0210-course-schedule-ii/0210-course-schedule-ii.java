class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] pre : prerequisites) {
            int course = pre[0];
            int prerequisie = pre[1];

            graph.get(prerequisie).add(course);
            indegree[course]++;
        }

        Deque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i]  == 0) {
                queue.offer(i);
            }
        }

        List<Integer> res = new ArrayList<>();

        while (!queue.isEmpty()) {
            int t = queue.poll();
            res.add(t);

            for  (int nextCourse : graph.get(t)) {
                indegree[nextCourse]--;

                if(indegree[nextCourse] == 0) {
                    queue.offer(nextCourse);
                }
            }
        }

        if (res.size() != numCourses) {
            return new int[0];
        }

        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}