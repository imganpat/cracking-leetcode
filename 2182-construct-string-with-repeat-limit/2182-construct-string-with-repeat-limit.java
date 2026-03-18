class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        for (Map.Entry<Character, Integer> e : freq.entrySet()) {
            maxHeap.offer(new int[] { e.getKey(), e.getValue() });
        }

        StringBuilder res = new StringBuilder();

        while (!maxHeap.isEmpty()) {
            int[] top = maxHeap.poll();
            char c = (char) top[0];
            int f = top[1];

            int use = Math.min(f, repeatLimit);

            for (int i = 0; i < use; i++) {
                res.append(c);
            }

            f -= use;

            if (f > 0) {
                if (maxHeap.isEmpty()) {
                    break;
                }

                int[] sTop = maxHeap.poll();
                res.append((char) sTop[0]);
                sTop[1]--;

                if (sTop[1] > 0) {
                    maxHeap.offer(sTop);
                }

                maxHeap.offer(new int[]{c, f});
            }
        }

        return res.toString();
    }
}