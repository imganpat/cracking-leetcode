// Approach: Monotonic Stack + Greedy
// 1. Count the frequency of every character.
// 2. Traverse the string from left to right.
// 3. For each character:
//      - Decrease its remaining frequency.
//      - If it is already in the stack, skip it.
//      - Otherwise, while:
//          • the stack is not empty,
//          • the top character is lexicographically larger,
//          • and the top character appears again later,
//        pop it from the stack.
//      - Push the current character and mark it as present.
// 4. The stack now contains each character exactly once
//    in the smallest lexicographical order.
// 5. Since elements are popped from the top,
//    reverse the result before returning.
//
// Time complexity: O(n)
//   - Every character is pushed and popped at most once
// Space complexity: O(1)
//   - Stack, frequency array, and visited array
//   - (26 lowercase English letters)

class Solution {
    public String removeDuplicateLetters(String s) {

        // Remaining occurrences of each character
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }


        Deque<Character> stack = new ArrayDeque<>();

        // Whether a character is already in the stack
        boolean[] inStack = new boolean[26];

        for (char c : s.toCharArray()) {

            // Current occurrence is being processed
            freq[c - 'a']--;

            // Skip duplicate characters
            if (inStack[c - 'a']) {
                continue;
            }

            // Remove larger characters if they
            // can still appear later
            while (!stack.isEmpty()
                    && stack.peek() > c
                    && freq[stack.peek() - 'a'] > 0) {

                char top = stack.pop();
                inStack[top - 'a'] = false;
            }

            stack.push(c);
            inStack[c - 'a'] = true;
        }

        StringBuilder res = new StringBuilder();

        while (!stack.isEmpty()) {
            res.append(stack.pop());
        }

        return res.reverse().toString();
    }
}