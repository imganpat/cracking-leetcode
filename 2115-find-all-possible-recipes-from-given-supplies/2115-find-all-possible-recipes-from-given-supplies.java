class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Map<String, List<Integer>> graph = new HashMap<>();
        int[] indegree = new int[recipes.length];

        for (int i = 0; i < recipes.length; i++) {
            indegree[i] = ingredients.get(i).size();

            for (String ing : ingredients.get(i)) {
                if (!graph.containsKey(ing)) {
                    graph.put(ing,new ArrayList<>());
                }
                graph.get(ing).add(i);
            }
        }

        Deque<String> queue = new ArrayDeque<>();

        for (String supply : supplies) {
            queue.offer(supply);
        }

        List<String> res = new ArrayList<>();

        while (!queue.isEmpty()) {
            String curr = queue.poll();
            
            if (!graph.containsKey(curr)) {
                continue;
            }

            for (int next : graph.get(curr)) {
                indegree[next]--;

                if (indegree[next] == 0)  {
                    String r  = recipes[next];
                    res.add(r);
                    
                    queue.offer(r);
                }
            }
        }

        return res;
    }
}