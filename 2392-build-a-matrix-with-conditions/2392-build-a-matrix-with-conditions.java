class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        List<List<Integer>> rowOrder = new  ArrayList<>();
        List<List<Integer>> colOrder = new  ArrayList<>();

        int[] rowIndegree = new int[k + 1];
        int[] colIndegree = new int[k + 1];

        for (int i = 0; i <= k; i++) {
            rowOrder.add(new ArrayList<>());
            colOrder.add(new ArrayList<>());
        }

        getOrder(rowConditions, rowOrder, rowIndegree); 
        getOrder(colConditions, colOrder, colIndegree); 

        List<Integer> rowSeq = topologicalSort(k, rowOrder, rowIndegree);
        List<Integer> colSeq = topologicalSort(k, colOrder, colIndegree);

        if  (rowSeq.isEmpty() || colSeq.isEmpty()){
            return new int[0][0];
        }

        int[][] res  = new int[k][k];

        for (int i = 1; i <= k;  i++){
            int rowPos = rowSeq.indexOf(i);
            int colPos = colSeq.indexOf(i);

            res[rowPos][colPos] = i;
        }
        
        return res;
    }

    private void getOrder(int[][] conditions, List<List<Integer>>order, int[] indegree) {
        for (int[] con: conditions)  {
            order.get(con[0]).add(con[1]);
            indegree[con[1]]++;
        }
    }

    private List<Integer> topologicalSort(int k, List<List<Integer>> graph, int[] indegree) {
        Deque<Integer> queue =  new ArrayDeque<>();
        for (int i = 1; i <= k; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        List<Integer> order = new ArrayList<>();
        while  (!queue.isEmpty()) {
            int curr = queue.poll();
            order.add(curr);

            for (int next : graph.get(curr))  {
                indegree[next]--;

                if (indegree[next] == 0){
                    queue.offer(next);
                }
            }
        }

        if (order.size() != k)  {
            return new ArrayList<>();
        }

        return order;

    }
}