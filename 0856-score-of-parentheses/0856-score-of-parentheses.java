class Solution {
    public int scoreOfParentheses(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);

        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(0);
            } else {
                int curr = stack.pop();
                int score = curr == 0 ? 1 : curr * 2;

                stack.push(stack.pop() + score);
            }

        }

        return stack.pop();
    }
}