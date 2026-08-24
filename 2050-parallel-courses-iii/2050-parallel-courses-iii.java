class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[n];

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] rel : relations) {
            int u = rel[0] - 1;
            int v = rel[1] - 1;

            graph.get(u).add(v);

            indegree[v]++;
        }

        Deque<Integer> queue = new ArrayDeque<>();
        int[] timeTaken = new int[n];
        int res = 0;

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
                timeTaken[i] = time[i];
            }
        }

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            for (int next: graph.get(curr)) {
                timeTaken[next] = Math.max(timeTaken[next], timeTaken[curr] + time[next]);

                indegree[next]--;

                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        
            res = Math.max(timeTaken[curr], res);
        }

        return res;

    }
}