class Solution {
    Map<Character, String> map; 
    public Solution(){
        map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }
    
    public void backtrack(List<String> res, StringBuilder curr, int i, String digits){
        if(i == digits.length()){
            res.add(curr.toString());
            return;
        }

        String choices = map.get(digits.charAt(i));
        for(int j = 0; j < choices.length(); j++){
            curr.append(choices.charAt(j));
            backtrack(res, curr, i+1, digits);
            curr.deleteCharAt(curr.length() - 1);
        }        
        return;

    }
    
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        StringBuilder curr = new StringBuilder();

        backtrack(res, curr, 0, digits);

        return res;
    }
}