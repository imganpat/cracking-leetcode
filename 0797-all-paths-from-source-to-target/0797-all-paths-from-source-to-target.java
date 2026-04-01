class Solution {
    public void backtrack(List<List<Integer>> res, List<Integer> curr, int i, int[][] graph){
        curr.add(i);

        if(i == graph.length - 1){
            res.add(new ArrayList<>(curr));
        } else{
            for(int n: graph[i]){
                backtrack(res, curr, n, graph);
                curr.remove(curr.size() - 1);
            }
        }


    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), 0, graph);
        return res;
    }
}