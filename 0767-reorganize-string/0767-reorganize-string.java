class Solution {
    public String reorganizeString(String s) {
        int[] freq = new int[26];
        for(char c: s.toCharArray()){
            freq[c - 'a']++;
        }

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for(int i = 0; i < 26; i++){
            if (freq[i] > 0) {
                maxHeap.offer(new int[]{freq[i], i});
            }
        }

        StringBuilder res = new StringBuilder();
        int[] prev = null;
        while (!maxHeap.isEmpty()) {
            int[] curr = maxHeap.poll();
            res.append((char) (curr[1] + 'a'));
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