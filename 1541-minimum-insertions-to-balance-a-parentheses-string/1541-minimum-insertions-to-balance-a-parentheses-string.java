class Solution {
    public int minInsertions(String s) {
        int inserts = 0;

        // Stores unmatched opening parentheses '('.
        Deque<Character> stack = new ArrayDeque<>();

        // Counts consecutive closing parentheses ')'.
        // Every opening parenthesis requires TWO closing parentheses.
        int count = 0;

        for (char c : s.toCharArray()) {

            if (c == '(') {

                // A single ')' was left over before this '('.
                // Insert one ')' to complete the required pair.
                if (count == 1) {
                    inserts++;

                    // Try to match the completed pair with an opening '('.
                    if (!stack.isEmpty()) {
                        stack.pop();
                    } else {
                        // No opening '(' exists, so insert one.
                        inserts++;
                    }

                    count = 0;
                }

                // This opening parenthesis still needs two ')'.
                stack.push(c);

            } else {
                count++;

                // We have collected a complete pair '))'.
                if (count == 2) {
                    if (!stack.isEmpty()) {
                        // Match the pair with an opening '('.
                        stack.pop();
                    } else {
                        // No opening '(' exists; insert one.
                        inserts++;
                    }

                    count = 0;
                }
            }
        }

        // Handle a single ')' remaining at the end.
        if (count == 1) {
            inserts++;

            if (!stack.isEmpty()) {
                stack.pop();
            } else {
                inserts++;
            }
        }

        // Every unmatched '(' needs two closing parentheses.
        inserts += stack.size() * 2;

        return inserts;
    }
}