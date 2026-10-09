class Solution {
    public int minInsertions(String s) {
        int inserts = 0;
        Deque<Character> stack = new ArrayDeque<>();

        int count = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                if (count == 1) {
                    inserts++; 
                    if (!stack.isEmpty()) {
                        stack.pop();
                    } else {
                        inserts++; 
                    }
                    count = 0;
                }
                stack.push(c);
            } else {
                count++;

                if (count == 2) {
                    if (!stack.isEmpty()) {
                        stack.pop();
                    } else {
                        inserts++;
                    }
                    
                    count = 0;
                }
            }
        }

        if (count == 1) {
            inserts++; 
            if (!stack.isEmpty()) {
                stack.pop();
            } else {
                inserts++; 
            }
        }

        inserts += stack.size() * 2;

        return inserts;
    }
}