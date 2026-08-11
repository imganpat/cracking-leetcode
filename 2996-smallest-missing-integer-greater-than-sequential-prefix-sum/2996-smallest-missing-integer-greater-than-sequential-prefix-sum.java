class Solution {
    public int missingInteger(int[] nums) {
        Set<Integer> elements = new HashSet<>();
        for (int num: nums) {
            elements.add(num);
        }
        
        int sum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                sum += nums[i];
            } else {
                break;
            }
        }

        while (elements.contains(sum)) {
            sum++;
        }

        return sum;
    }
}