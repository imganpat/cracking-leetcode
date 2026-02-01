class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();

        stack.push(n - 1);
        res[n - 1] = 0;

        // Traverse from right to left
        for (int i = n - 2; i >= 0; i--) {
            // Remove indices with temperatures less than or equal to current
            while (!stack.isEmpty() && temperatures[i] >= temperatures[stack.peek()]) {
                stack.pop();
            }

            // If stack is empty, no warmer day exists
            // else day = top index - current
            res[i] = stack.isEmpty() ? 0 : stack.peek() - i;

            // If stack is empty, no warmer day exists
            stack.push(i);
        }

        return res;
    }
}