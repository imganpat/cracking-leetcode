class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        map.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            int r = sum % k;

            if (r < 0) {
                r += k;
            }

            if (map.containsKey(r)) {
                int prev = map.get(r);
                if (i - prev >= 2) {
                    return true;
                }
            } else {
                map.put(r, i);
            }
        }
        return false;
    }
}