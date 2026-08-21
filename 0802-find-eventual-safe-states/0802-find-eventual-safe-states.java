class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> reversed = new ArrayList<>();
        int[] outdegree = new int[n] ;

        
        for (int i = 0 ; i < n; i++) {
            reversed.add(new ArrayList<>());
        }

        for (int i =0; i < n; i++) {
            outdegree[i]  = graph[i].length;
            
            for (int j : graph[i]) {
                reversed.get(j).add(i);
            }
        }

        Deque<Integer> queue = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < n;  i++) {
            if (outdegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int top = queue.poll();
            res.add(top);

            for (int next : reversed.get(top)) {
                outdegree[next]--;

                if (outdegree[next] == 0) {
                    queue.add(next);
                }
            }
        }

        Collections.sort(res);

        return res;

    }
}