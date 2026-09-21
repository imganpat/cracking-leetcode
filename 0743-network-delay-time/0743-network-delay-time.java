// Approach: Build a weighted directed graph using an adjacency list.
// Use Dijkstra's algorithm with a min-heap to find the shortest
// distance from the starting node k to every other node.
//
// Time complexity: O((V + E) log V)
// Space complexity: O(V + E)

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        // adj[node] contains:
        // [destination, weight]
        List<List<int[]>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Build the directed weighted graph.
        for (int i = 0; i < times.length; i++) {

            // Convert 1-based node numbers to 0-based indexes.
            int s = times[i][0] - 1;
            int d = times[i][1] - 1;
            int w = times[i][2];

            // Store destination and edge weight.
            adj.get(s).add(new int[] { d, w });
        }

        // Min-heap based on distance.
        //
        // [distance, node]
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );

        // Start from node k with distance 0.
        pq.offer(new int[] { 0, k - 1 });

        // distances[i] = shortest known distance from k to i.
        int[] distances = new int[n];

        Arrays.fill(distances, Integer.MAX_VALUE);

        // Distance from source to itself is 0.
        distances[k - 1] = 0;

        while (!pq.isEmpty()) {

            // Get the node with the smallest known distance.
            int[] top = pq.poll();

            int distance = top[0];
            int node = top[1];

            // If this is an outdated heap entry, ignore it.
            //
            // A node can be inserted multiple times with
            // progressively better distances.
            if (distance > distances[node]) {
                continue;
            }

            // Try to improve the shortest distance to every neighbor.
            for (int[] neighbour : adj.get(node)) {

                int neighbourNode = neighbour[0];
                int weight = neighbour[1];

                // New possible distance through current node.
                int newDistance = distance + weight;

                // Relax the edge if we found a shorter path.
                if (newDistance < distances[neighbourNode]) {

                    distances[neighbourNode] = newDistance;

                    // Add the improved distance to the min-heap.
                    pq.offer(new int[] {
                        newDistance,
                        neighbourNode
                    });
                }
            }
        }

        // The signal reaches all nodes at their shortest distances.
        // Therefore, the total delay is the maximum shortest distance.
        int max = distances[0];

        for (int i : distances) {
            max = Math.max(max, i);
        }

        // If any node is still unreachable, return -1.
        return max == Integer.MAX_VALUE ? -1 : max;
    }
}