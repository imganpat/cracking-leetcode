class Solution {
    public int maxDepth(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        int count = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push('(');
                count = Math.max(count, stack.size());
            } else if (c == ')') {
                stack.pop();
            }
        }

        return count;
    }
}