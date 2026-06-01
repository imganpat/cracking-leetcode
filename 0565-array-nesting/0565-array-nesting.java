class Solution {
    public int arrayNesting(int[] nums) {
        int n = nums.length;
        boolean[] visited = new boolean[n];
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            int len = 0;
            int curr = i;

            while (!visited[curr]) {
                visited[curr] = true;
                curr = nums[curr];
                len++;
            }

            maxLen = Math.max(maxLen, len);
        }

        return maxLen;
    }
}