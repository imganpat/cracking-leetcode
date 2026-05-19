class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public void backtrack(List<Integer> curr, int i, int k, int n) {
        if (i > n) {
            if (curr.size() == k) {
                res.add(new ArrayList<>(curr));
                return;
            }
            return;
        }

        curr.add(i);
        backtrack(curr, i + 1, k, n);
        curr.remove(curr.size()-1);
        backtrack(curr, i + 1, k, n);
    }
    
    public List<List<Integer>> combine(int n, int k) {
        backtrack(new ArrayList<>(), 1, k, n);
        return res;
    }
}