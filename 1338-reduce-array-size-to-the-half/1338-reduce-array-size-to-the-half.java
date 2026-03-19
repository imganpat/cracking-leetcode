class Solution {
    public int minSetSize(int[] arr) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int n : arr) {
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int f : freq.values()) {
            maxHeap.offer(f);
        }

        int setsRemoved = 0;
        int target = arr.length / 2;
        int remainingSize = arr.length;

        while (remainingSize > target) {
            remainingSize -= maxHeap.poll();
            setsRemoved++;
        }

        return setsRemoved;
    }
}