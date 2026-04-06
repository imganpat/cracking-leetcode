class Solution {
    public void backtrack(
            List<List<Integer>> res, 
            List<Integer> curr, 
            int i,
            int sum, 
            int[] candidates, 
            int target)
    {
        if(sum == target){
            res.add(new ArrayList<>(curr));
            return;
        }
        if(sum > target){
            return;
        }
        for(int j = i; j < candidates.length; j++){
            
            curr.add(candidates[j]);
            sum += candidates[j];
            backtrack(res, curr, j,  sum, candidates, target);
            sum  -= candidates[j];
            curr.remove(curr.size() - 1);
        }
        
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), 0, 0, candidates, target);
        
        return res;
    }
}