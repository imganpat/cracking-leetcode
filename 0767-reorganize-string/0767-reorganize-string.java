class Solution {
    public String reorganizeString(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (Map.Entry<Character, Integer> e : freq.entrySet()) {
            maxHeap.offer(new int[] { e.getValue(), e.getKey() });
        }

        StringBuilder res = new StringBuilder();
        int[] prev = null;
        while (!maxHeap.isEmpty()) {
            int[] curr = maxHeap.poll();
            res.append((char) curr[1]);
            curr[0]--;

            if (prev != null && prev[0] > 0) {
                maxHeap.offer(prev);
            }

            prev = curr;
        }

        if (res.length() != s.length()) {
            return "";
        }
        return res.toString();

    }
}