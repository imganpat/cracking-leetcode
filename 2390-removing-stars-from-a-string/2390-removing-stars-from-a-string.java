class Solution {
    public String removeStars(String s) {
        // Stack<Character> stack = new Stack<>();
        // for (char c : s.toCharArray()) {
        //     if (c == '*') {
        //         stack.pop();
        //         continue;
        //     }
        //     stack.push(c);
        // }

        // StringBuilder res = new StringBuilder();
        // while (!stack.isEmpty()) {
        //     res.append(stack.pop());
        // }

        // return res.reverse().toString();

        StringBuilder res = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '*') {
                res.deleteCharAt(res.length() - 1);
                continue;
            }
            res.append(c);
        }

        return res.toString();
    }
}