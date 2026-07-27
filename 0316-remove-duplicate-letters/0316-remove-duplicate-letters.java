class Solution {
    public String removeDuplicateLetters(String s) {
        int[] freq = new int[26];
        
        for (char c  :  s.toCharArray()) {
            freq[c -  'a']++;
        }


        Deque<Character>  stack = new ArrayDeque<>();
        boolean[] inStack = new boolean[26];
        
        for  (char c: s.toCharArray())  {
            freq[c - 'a']--;

            if (inStack[c - 'a']) {
                continue;
            }

            while (!stack.isEmpty()
                    && stack.peek() > c 
                    && freq[stack.peek() - 'a'] >  0 )  {
                char top = stack.pop();
                inStack[top - 'a'] =  false;
            }

            stack.push(c);
            inStack[c - 'a'] =  true;
        }

        
        StringBuilder res = new StringBuilder();

        while (!stack.isEmpty()) {
            res.append(stack.pop());
        }

        return res.reverse().toString();
    }
}