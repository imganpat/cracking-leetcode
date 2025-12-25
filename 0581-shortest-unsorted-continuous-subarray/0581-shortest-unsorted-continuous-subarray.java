class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int[] arr = nums.clone();
        Arrays.sort(arr);

        int i = 0;
        while (i < n) {
            if (arr[i] != nums[i]) {
                break;
            }
            i++;
        }

        int j = n - 1;
        while (j > 0) {
            if (arr[j] != nums[j]) {
                break;
            }
            j--;
        }

        if (i == n && j == 0) {
            return 0;
        }

        return j - i + 1;
    }
}