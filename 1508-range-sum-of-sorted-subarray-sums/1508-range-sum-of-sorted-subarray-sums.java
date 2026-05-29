class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        List<Integer> sums = new ArrayList<>();
        
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                sums.add(sum);
            }
        }

        Collections.sort(sums);

        int res = 0;
        for (int i = left - 1; i < right; i++) {
            res = (res + sums.get(i)) % 1_000_000_007;
        }

        return res;
    }
}