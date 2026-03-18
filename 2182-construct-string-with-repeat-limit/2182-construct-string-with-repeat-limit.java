class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                maxHeap.offer(new int[] { i + 'a', freq[i] });
            }
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

                maxHeap.offer(new int[] { c, f });
            }
        }

        return res.toString();
    }
}