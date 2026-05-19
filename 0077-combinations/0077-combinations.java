class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public void backtrack(List<Integer> curr, int c, int k, int n) {
        if (curr.size() == k) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int i = c + 1; i <= n; i++) {
            curr.add(i);
            backtrack(curr, i, k, n);
            curr.remove(curr.size()-1);
        }
    }
    
    public List<List<Integer>> combine(int n, int k) {
        backtrack(new ArrayList<>(), 0, k, n);
        return res;
    }
}