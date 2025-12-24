class Solution {
    public boolean backspaceCompare(String s, String t) {
        List<Character> stack = new ArrayList();
        List<Character> stack2 = new ArrayList();

        for (char c : s.toCharArray()) {
            if (c == '#') {
                if (!stack.isEmpty()) {
                    stack.remove(stack.size() - 1);
                }
            } else {
                stack.add(c);
            }
        }

        for (char c : t.toCharArray()) {
            if (c == '#') {
                if (!stack2.isEmpty()) {
                    stack2.remove(stack2.size() - 1);
                }
            } else {
                stack2.add(c);
            }
        }

        if (stack.size() != stack2.size()) {
            return false;
        }

        for (int i = stack.size() - 1;  i >= 0; i--) {
            if (stack.get(i) != stack2.get(i)) {
                return false;
            }
        }

        return true;
    }
}