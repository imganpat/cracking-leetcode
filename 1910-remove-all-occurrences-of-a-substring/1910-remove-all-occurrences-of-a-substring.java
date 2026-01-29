class Solution {
    public String removeOccurrences(String s, String part) {
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            stack.push(c);
            
            if (stack.size() >= part.length()) {
                boolean match = true;
  
                for (int i = 0; i < part.length(); i++) {
                    if (stack.get(stack.size() - part.length() + i) != part.charAt(i)) {
                        match = false;
                        break;
                    }
                }

                if (match) {
                    for (int i = 0; i < part.length(); i++) {
                        stack.pop();
                    }
                }
            }
        }

        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.append(stack.pop());
        }

        return res.reverse().toString();
    }
}