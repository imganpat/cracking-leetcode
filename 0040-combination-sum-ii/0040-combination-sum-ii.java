class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public void backtrack(List<Integer> curr, int[] candidates, int i, int sum, int target) {
        if (sum == target) {
            res.add(new ArrayList<>(curr));
            return;
        }

        if (i >= candidates.length || sum > target) {
            return;
        }


        curr.add(candidates[i]);
        backtrack(curr, candidates, i + 1, sum + candidates[i], target);

        curr.remove(curr.size() - 1);

        int next = i + 1;
        while (next < candidates.length &&
               candidates[next] == candidates[i]) {
            next++;
        }

        backtrack(curr, candidates, next, sum, target);

    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(new ArrayList<>(), candidates, 0, 0, target);
        return res;
    }
}