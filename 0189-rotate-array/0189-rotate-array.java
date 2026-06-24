class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        int[] arr = new int[n];
        int[] rotate = new int[k];

        int e = n - 1;
        for (int i = k - 1; i >= 0; i--) {
            rotate[i] = nums[e--];
        }

        for (int i = 0; i < k; i++) {
            arr[i] = rotate[i];
        }

        for (int i = k; i < n; i++) {
            arr[i] = nums[i - k];
        }

        for(int i = 0; i < n; i++) {
            nums[i] = arr[i];
        }
    }
}