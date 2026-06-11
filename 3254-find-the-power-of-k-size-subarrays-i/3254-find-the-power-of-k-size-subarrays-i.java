class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int index = 0;
        int [] res = new int[n - k + 1];

        for (int start = 0, end = 0; end < n; end++) {

            if (end - start + 1 == k) {                
                boolean isValid = true;

                for (int i = start; i < end; i++) {
                    if (nums[i] + 1 != nums[i + 1]) {
                        isValid = false;
                        break;
                    }
                }

                int power = isValid ? nums[end] : -1;

                res[index++] = power;
                start++;
            }
        }

        return res;
    }
}