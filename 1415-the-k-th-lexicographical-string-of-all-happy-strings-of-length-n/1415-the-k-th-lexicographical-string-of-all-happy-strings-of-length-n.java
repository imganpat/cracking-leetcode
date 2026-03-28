class Solution {
    public void backtrack(List<String> res, StringBuilder curr, int n, int k){ 
        if(curr.length() == n){
            res.add(curr.toString());
            return;
        }

        for(char c= 'a'; c <= 'c'; c++){
            if(curr.length() > 0 && curr.charAt(curr.length() - 1) == c){
                continue;
            }

            curr.append(c);
            backtrack(res, curr, n, k);
            curr.deleteCharAt(curr.length() - 1);
        }
        return;
    }
    
    public String getHappyString(int n, int k) {
        List<String> res = new ArrayList<>();
        backtrack(res, new StringBuilder(), n , k);

        return k <= res.size() ? res.get(k - 1): "";
    }
}