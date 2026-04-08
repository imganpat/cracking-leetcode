class Solution {
    private void backtrack(List<List<Integer>> res, List<Integer> curr, int i, int sum, int[] candidates, int target){
        if(i == candidates.length){
            if (sum == target){
                res.add(new ArrayList<>(curr));
            }    
            return;
        }

        backtrack(res, curr, i + 1, sum, candidates, target);

        if(sum + candidates[i] <= target){
            sum += candidates[i];
            curr.add(candidates[i]);
            backtrack(res, curr, i, sum, candidates, target);
            sum-= candidates[i];
            curr.remove(curr.size()-1);
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), 0, 0, candidates, target);
        return res;
    }
}