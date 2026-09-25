class Solution {
    public int findTheCity(int n,
            int[][] edges,
            int distanceThreshold) {

        /*
         * Approach:
         * Build an undirected weighted graph using an adjacency list.
         * Run Dijkstra's algorithm from every city to find the shortest
         * distance to all other cities.
         * Count how many cities are reachable within the given threshold.
         * If multiple cities have the same minimum count, choose the city
         * with the greater index.
         *
         * Time Complexity: O(n * (E + n) log n)
         * Space Complexity: O(n + E)
         */

        List<List<int[]>> adj = new ArrayList<>();

        // Create adjacency list for every city.
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Build the undirected weighted graph.
        for (int[] edge : edges) {
            int s = edge[0];
            int d = edge[1];
            int w = edge[2];

            adj.get(s).add(new int[] { d, w });
            adj.get(d).add(new int[] { s, w });
        }

        int resultCity = -1;
        int minCount = Integer.MAX_VALUE;

        // Run Dijkstra from every city.
        for (int src = 0; src < n; src++) {

            int[] dist = new int[n];
            Arrays.fill(dist, Integer.MAX_VALUE);

            dist[src] = 0;

            PriorityQueue<int[]> pq = new PriorityQueue<>(
                    (a, b) -> Integer.compare(a[0], b[0]));

            pq.offer(new int[] { 0, src });

            while (!pq.isEmpty()) {
                int[] curr = pq.poll();

                int currDist = curr[0];
                int currCity = curr[1];

                // Ignore outdated entries.
                if (currDist > dist[currCity]) {
                    continue;
                }

                // Relax all neighbouring cities.
                for (int[] edge : adj.get(currCity)) {
                    int nextCity = edge[0];
                    int weight = edge[1];

                    int newDist = currDist + weight;

                    if (newDist < dist[nextCity]) {
                        dist[nextCity] = newDist;
                        pq.offer(new int[] { newDist, nextCity });
                    }
                }
            }

            // Count cities reachable within the threshold.
            int count = 0;

            for (int city = 0; city < n; city++) {
                if (city != src && dist[city] <= distanceThreshold) {
                    count++;
                }
            }

            // Use <= so that a larger city index replaces the previous one
            // when both have the same number of reachable cities.
            if (count <= minCount) {
                minCount = count;
                resultCity = src;
            }
        }

        return resultCity;
    }
}