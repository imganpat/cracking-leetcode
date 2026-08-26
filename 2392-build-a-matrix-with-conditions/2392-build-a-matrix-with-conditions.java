// Approach: Two Topological Sorts
//
// 1. rowConditions tell us the relative ordering of numbers
//    along the rows.
//
// 2. colConditions tell us the relative ordering of numbers
//    along the columns.
//
// 3. Build two separate directed graphs:
//      rowGraph -> row constraints
//      colGraph -> column constraints
//
// 4. Perform topological sort on both graphs.
//
// 5. If either graph contains a cycle, no valid matrix exists.
//
// 6. The topological orders tell us where each number should
//    be placed:
//      rowIndices[num] = row position
//      colIndices[num] = column position
//
// 7. Place every number at:
//      matrix[rowIndices[num]][colIndices[num]] = num
//
// Time complexity: O(k + R + C)
//   R = number of row conditions
//   C = number of column conditions
//
// Space complexity: O(k + R + C)

class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        List<List<Integer>> rowGraph = new ArrayList<>();
        List<List<Integer>> colGraph = new ArrayList<>();
        int[] rowInDegree = new int[k + 1];
        int[] colInDegree = new int[k + 1];

        // Build empty graphs
        for (int i = 0; i <= k; i++) {
            rowGraph.add(new ArrayList<>());
            colGraph.add(new ArrayList<>());
        }

        // Build row and column graphs
        buildGraph(rowConditions, rowGraph, rowInDegree);

        buildGraph(colConditions, colGraph, colInDegree);

        // Find valid ordering for rows and columns
        List<Integer> rowOrder = topologicalSort(k, rowGraph, rowInDegree);
        List<Integer> colOrder = topologicalSort(k, colGraph, colInDegree);

        // A cycle in either graph makes the matrix impossible
        if (rowOrder.isEmpty() || colOrder.isEmpty()) {
            return new int[0][0];
        }

        // Store the position of each number
        int[] rowIndices = new int[k + 1];
        int[] colIndices = new int[k + 1];

        for (int i = 0; i < k; i++) {
            rowIndices[rowOrder.get(i)] = i;
            colIndices[colOrder.get(i)] = i;
        }

        int[][] matrix = new int[k][k];

        // Every number gets exactly one position
        for (int num = 1; num <= k; num++) {
            matrix[rowIndices[num]][colIndices[num]] = num;
        }

        return matrix;
    }

    private void buildGraph(int[][] conditions, List<List<Integer>> graph, int[] indegree) {

        for (int[] condition : conditions) {
            int before = condition[0];
            int after = condition[1];

            graph.get(before).add(after);
            indegree[after]++;
        }
    }

    private List<Integer> topologicalSort(int k, List<List<Integer>> graph, int[] indegree) {
        Deque<Integer> queue = new ArrayDeque<>();

        // Nodes with no prerequisites
        for (int i = 1; i <= k; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        List<Integer> order = new ArrayList<>();

        while (!queue.isEmpty()) {
            int current = queue.poll();
            order.add(current);

            for (int neighbor : graph.get(current)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        // Not all nodes were processed -> cycle
        if (order.size() != k) {
            return new ArrayList<>();
        }

        return order;
    }
}