class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> numsList = new HashSet<>();
        List<Integer> res = new ArrayList<>();
        int n = nums.length + 1;

        for (int num : nums) {
            numsList.add(num);
        }

        for (int i = 1; i < n; i++) {
            if (!numsList.contains(i)) {
                res.add(i);
            }
        }

        return res;
    }
}