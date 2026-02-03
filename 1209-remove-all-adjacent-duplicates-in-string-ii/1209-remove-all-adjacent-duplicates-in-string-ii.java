class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Character> stack = new Stack<>();
        Stack<Integer> count = new Stack<>();

        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == c) {
                count.push(count.pop() + 1);
            } else {
                stack.push(c);
                count.push(1);
            }

            if (count.peek() == k) {
                stack.pop();
                count.pop();
            }
        }

        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            char c = stack.pop();
            int freq = count.pop();
            while (freq > 0) {
                res.append(c);
                freq--;
            }
        }

        return res.reverse().toString();
    }
}