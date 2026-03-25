class Solution {
    public void backtrack(List<List<Integer>> res, List<Integer> curr, int i, int[] nums){
        if(i == nums.length){
            res.add(new ArrayList<>(curr));
            return;
        }

        backtrack(res, curr, i+1, nums);
        curr.add(nums[i]);
        backtrack(res, curr, i+1, nums);
        curr.remove(curr.size() - 1);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        backtrack(res,curr,0,nums);
        return res;
    }
}