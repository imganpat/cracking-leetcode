class Solution {
    public String removeKdigits(String num, int k) {
        Deque<Character> stack = new ArrayDeque<>();

        int i = 0;
        for (; i < num.length(); i++) {
            char d = num.charAt(i);

            while (!stack.isEmpty() && stack.peek() > d && k > 0) {
                stack.pop();
                k--;
            }

            stack.push(d);
        }

        StringBuilder res = new StringBuilder();

        while (!stack.isEmpty()) {
            res.append(stack.pop());
        }

        res.reverse();

        for (; i < num.length(); i++) {
            res.append(num.charAt(i));
        }

        while (k-- > 0) {
            res.deleteCharAt(res.length() - 1);
        }

        while (res.length() > 0 && res.charAt(0) == '0') {
            res.deleteCharAt(0);
        }

        if (res.length() == 0) {
            return "0";
        }

        return res.toString();
    }
}