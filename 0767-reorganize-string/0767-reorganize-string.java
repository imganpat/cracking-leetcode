// Approach: Greedy + Max Heap
// 1. Count the frequency of each character in the string.
// 2. Insert all characters with their frequencies into a max heap
//    so the character with the highest frequency is always selected first.
// 3. Repeatedly:
//    - Take the character with the highest frequency.
//    - Append it to the result string.
//    - Decrease its frequency.
// 4. Keep track of the previously used character (prev).
//    - Do not immediately push it back into the heap to avoid placing
//      the same character consecutively.
//    - After using a different character, push the previous one back
//      if it still has remaining frequency.
// 5. Continue until the heap becomes empty.
// 6. If the final string length equals the original string length,
//    return the result; otherwise return "" (reorganization not possible).
//
// Time complexity: O(n log k)
//   - n = length of string
//   - k = number of unique characters (≤ 26)
// Space complexity: O(k) – heap and frequency array

class Solution {
    public String reorganizeString(String s) {

        // Step 1: Count frequencies
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        // Step 2: Max heap storing {frequency, characterIndex}
        PriorityQueue<int[]> maxHeap =
                new PriorityQueue<>((a, b) -> b[0] - a[0]);

        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                maxHeap.offer(new int[]{freq[i], i});
            }
        }

        StringBuilder res = new StringBuilder();
        int[] prev = null;

        // Step 3: Build result string
        while (!maxHeap.isEmpty()) {
            int[] curr = maxHeap.poll();

            // Append current character
            res.append((char) (curr[1] + 'a'));
            curr[0]--;

            // Push previous character back if it still has frequency
            if (prev != null && prev[0] > 0) {
                maxHeap.offer(prev);
            }

            // Update previous character
            prev = curr;
        }

        // Step 4: Check if valid reorganization
        if (res.length() != s.length()) {
            return "";
        }

        return res.toString();
    }
}