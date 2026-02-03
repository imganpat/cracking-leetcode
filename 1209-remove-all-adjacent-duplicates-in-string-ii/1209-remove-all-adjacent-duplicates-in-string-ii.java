// Approach: Stack with Character Frequency
// 1. Use a stack where each element stores a character and its consecutive frequency.
// 2. Traverse the string character by character:
//    - If the current character is the same as the stack top, increment its frequency.
//    - Otherwise, push the character with frequency 1 onto the stack.
// 3. Whenever the frequency of the top element becomes equal to k,
//    remove (pop) it from the stack (duplicate removal).
// 4. After processing the string, rebuild the result by popping elements from the stack
//    and appending each character according to its remaining frequency.
// 5. Reverse the built string because the stack processes characters in reverse order.
// 6. Return the final string after all valid removals.
//
// Time complexity: O(n) – each character is pushed and popped at most once
// Space complexity: O(n) – stack and StringBuilder used for storage

class Solution {
    public String removeDuplicates(String s, int k) {
        // Stack to store {character, frequency}
        Stack<int[]> stack = new Stack<>();

        // Step 1: Process each character
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek()[0] == c) {
                // Same character as top → increase frequency
                stack.peek()[1]++;
            } else {
                // New character → push to stack
                stack.push(new int[] { c, 1 });
            }

            // If frequency reaches k, remove it
            if (stack.peek()[1] == k) {
                stack.pop();
            }
        }

        // Step 2: Rebuild the result string from the stack
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            char c = (char) stack.peek()[0];
            int freq = stack.peek()[1];

            // Append character 'freq' times
            while (freq-- > 0) {
                res.append(c);
            }
            stack.pop();
        }

        // Reverse because characters were added in reverse order
        return res.reverse().toString();
    }
}
