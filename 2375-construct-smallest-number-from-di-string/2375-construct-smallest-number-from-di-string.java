class Solution {
    public String smallestNumber(String pattern) {
        Stack<Integer> stack = new Stack<>();
        StringBuilder res = new StringBuilder();

        for(int i = 0; i <= pattern.length(); i++){
            stack.push(i + 1);
            if(i == pattern.length() || pattern.charAt(i) == 'I'){
                while(!stack.isEmpty()){
                    res.append(stack.pop());
                }
            }
        }

        return res.toString();
    }
}