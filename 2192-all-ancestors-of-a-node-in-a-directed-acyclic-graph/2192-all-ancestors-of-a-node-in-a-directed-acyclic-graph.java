class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[n];

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }   

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            indegree[edge[1]]++;
        }

        Deque<Integer> queue = new ArrayDeque<>();
        List<Set<Integer>> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
            res.add(new HashSet<>());
        }

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            
            for  (int next : graph.get(curr)) {
                indegree[next]--;
                
                res.get(next).add(curr);

                for (int ancestor : res.get(curr)) {
                    res.get(next).add(ancestor);
                }

                if (indegree[next] == 0)  {
                    queue.offer(next);
                }
            }
        }
        
       List<List<Integer>> answer = new ArrayList<>();

        for (Set<Integer> set : res) {
            List<Integer> list = new ArrayList<>(set);
            Collections.sort(list);
            answer.add(list);
        }

        return answer;

    }
}