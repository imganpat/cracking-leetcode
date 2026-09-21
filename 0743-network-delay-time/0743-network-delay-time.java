class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < times.length; i++) {
            int s = times[i][0] - 1;
            int d = times[i][1] - 1;
            int w = times[i][2];

            adj.get(s).add(new int[] { d, w });
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> Integer.compare(a[0], b[0]));
        pq.offer(new int[] { 0, k - 1 });

        int[] distances = new int[n];

        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[k - 1] = 0;

        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int distance = top[0];
            int node = top[1];

            if (distance > distances[node]) {
                continue;
            }

            for (int[] neighbour : adj.get(node)) {
                int neighbourNode = neighbour[0];
                int weight = neighbour[1];

                if (distance + weight < distances[neighbourNode]) {
                    distances[neighbourNode] = distance + weight;
                    pq.offer(new int[] { distance + weight, neighbourNode });
                }
            }

        }

        int max = distances[0];
        for (int i : distances) {
            max = Math.max(max, i);
        }

        return max == Integer.MAX_VALUE ? - 1 :  max;
    }
}