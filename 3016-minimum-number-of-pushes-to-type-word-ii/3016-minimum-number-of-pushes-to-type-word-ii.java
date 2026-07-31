// Approach: Greedy Frequency Assignment
// 1. Count the frequency of every character.
// 2. Sort the frequencies in ascending order.
// 3. Process the frequencies from largest to smallest.
// 4. Assign the most frequent letters to the positions
//    requiring the fewest button presses.
//      - First 8 letters  -> 1 push
//      - Next 8 letters   -> 2 pushes
//      - Next 8 letters   -> 3 pushes
//      - Remaining letters-> 4 pushes
// 5. Multiply each frequency by its assigned number
//    of pushes and accumulate the total.
// 6. Return the minimum number of pushes.
//
// Time complexity: O(n + 26 log 26)
//   - O(n) to count frequencies
//   - Sorting only 26 elements is constant time
// Space complexity: O(1)
//   - Frequency array of fixed size (26)

class Solution {
    public int minimumPushes(String word) {
        // Frequency of each character
        int[] freq = new int[26];

        for (char c : word.toCharArray()) {
            freq[c - 'a']++;
        }

        Arrays.sort(freq);

        int res = 0;
        // Position among assigned characters
        int rank = 0;

        // Process highest frequencies first
        for (int i = 25; i >= 0; i--) {

            if (freq[i] == 0) {
                break;
            }

            // Every group of 8 letters
            // requires one extra push
            int pushes = rank / 8 + 1;
            res += pushes * freq[i];
            rank++;
        }

        return res;
    }
}