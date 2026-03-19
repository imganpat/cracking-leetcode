// Approach: Frequency Count + Greedy (Max Heap)
// 1. Count the frequency of each unique element using a HashMap.
// 2. Store all frequencies in a max heap so we can always remove
//    the element with the highest frequency first.
// 3. The goal is to remove at least half of the array size.
// 4. Repeatedly:
//    - Remove the largest frequency from the heap.
//    - Reduce the remaining array size by that frequency.
//    - Increment the count of sets removed.
// 5. Stop when the remaining size becomes ≤ n / 2.
// 6. Return the number of sets removed.
//
// Time complexity: O(n log k)
//   - n = length of array
//   - k = number of unique elements
//   - Heap operations take O(log k)
// Space complexity: O(k) – for HashMap and heap

class Solution {
    public int minSetSize(int[] arr) {

        // Step 1: Count frequencies
        Map<Integer, Integer> freq = new HashMap<>();
        for (int n : arr) {
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }

        // Step 2: Max heap of frequencies
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        for (int f : freq.values()) {
            maxHeap.offer(f);
        }

        int setsRemoved = 0;
        int target = arr.length / 2;
        int remainingSize = arr.length;

        // Step 3: Greedily remove largest frequencies
        while (remainingSize > target) {
            remainingSize -= maxHeap.poll();
            setsRemoved++;
        }

        return setsRemoved;
    }
}