class Solution {
    public int findTheCity(int n,
            int[][] edges,
            int distanceThreshold) {
        List<List<int[]>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int s = edge[0];
            int d = edge[1];
            int w = edge[2];

            adj.get(s).add(new int[] { d, w });
            adj.get(d).add(new int[] { s, w });
        }

        int resultCity = -1;
        int minCount = Integer.MAX_VALUE;

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

                if (currDist > dist[currCity]) {
                    continue;
                }

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

            int count = 0;

            for (int city = 0; city < n; city++) {
                if (city != src && dist[city] <= distanceThreshold) {
                    count++;
                }
            }

            if (count <= minCount) {
                minCount = count;
                resultCity = src;
            }
        }
        return resultCity;
    }
}