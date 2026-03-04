// Approach: Frequency Map + Max Heap (Priority Queue)
// 1. Count the frequency of each character using a HashMap.
// 2. Insert each character and its frequency into a max heap (priority queue)
//    so that the character with the highest frequency comes first.
// 3. Repeatedly remove the element with the highest frequency from the heap.
// 4. Append that character to the result string as many times as its frequency.
// 5. Continue until the heap becomes empty.
// 6. The constructed string will have characters sorted by decreasing frequency.
//
// Time complexity: O(n log k)
//   - n = length of the string
//   - k = number of unique characters
//   - Heap operations take O(log k)
// Space complexity: O(k) – for HashMap and PriorityQueue

class Solution {
    public String frequencySort(String s) {

        // Step 1: Count character frequencies
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        // Step 2: Max heap based on frequency
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));

        // Insert (frequency, character) pairs into heap
        for (Map.Entry<Character, Integer> e : freq.entrySet()) {
            int count = e.getValue();
            char c = e.getKey();

            pq.add(new int[] { count, c });
        }

        // Step 3: Build result string
        StringBuilder res = new StringBuilder();
        while (!pq.isEmpty()) {
            int[] m = pq.poll();

            // Append character m[1] m[0] times
            for (int i = m[0]; i > 0; i--) {
                res.append((char) m[1]);
            }
        }

        return res.toString();
    }
}