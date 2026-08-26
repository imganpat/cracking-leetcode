class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        List<List<Integer>> rowGraph = new  ArrayList<>();
        List<List<Integer>> colGraph = new  ArrayList<>();

        int[] rowInDegree = new int[k + 1];
        int[] colInDegree = new int[k + 1];

        for (int i = 0; i <= k; i++) {
            rowGraph.add(new ArrayList<>());
            colGraph.add(new ArrayList<>());
        }

        buildGraph(rowConditions, rowGraph, rowInDegree); 
        buildGraph(colConditions, colGraph, colInDegree); 

        List<Integer> rowOrder = topologicalSort(k, rowGraph, rowInDegree);
        List<Integer> colOrder = topologicalSort(k, colGraph, colInDegree);

        if  (rowOrder.isEmpty() || colOrder.isEmpty()){
            return new int[0][0];
        }

        int[][] matrix  = new int[k][k];

        for (int num = 1; num <= k;  num++){
            int rowIndex = rowOrder.indexOf(num);
            int colIndex = colOrder.indexOf(num);

            matrix[rowIndex][colIndex] = num;
        }
        
        return matrix;
    }

    private void buildGraph(int[][] conditions, List<List<Integer>>graph, int[] indegree) {
        for (int[] condition: conditions)  {
            graph.get(condition[0]).add(condition[1]);
            indegree[condition[1]]++;
        }
    }

    private List<Integer> topologicalSort(int k, List<List<Integer>> graph, int[] indegree) {
        Deque<Integer> queue =  new ArrayDeque<>();
        for (int i = 1; i <= k; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        List<Integer> topologicalOrder = new ArrayList<>();
        while  (!queue.isEmpty()) {
            int current = queue.poll();
            topologicalOrder.add(current);

            for (int neighbor : graph.get(current))  {
                indegree[neighbor]--;

                if (indegree[neighbor] == 0){
                    queue.offer(neighbor);
                }
            }
        }

        if (topologicalOrder.size() != k)  {
            return new ArrayList<>();
        }

        return topologicalOrder;

    }
}