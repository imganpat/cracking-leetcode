class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
            int key = e.getKey();
            int val = e.getValue();
            pq.add(new int[] { key, val });
        }

        ArrayList<Integer> l = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            l.add(pq.poll()[0]);
        }

        int[] res = new int[l.size()];
        for (int i = 0; i < k; i++) {
            res[i] = l.get(i);
        }

        return res;

    }
}