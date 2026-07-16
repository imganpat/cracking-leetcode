class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int[] component = new int [n]; 
        int comp = 0;
        component[0] = comp;

        for (int i = 1; i < n; i++) {
            if (nums[i] - nums[i - 1] <= maxDiff) {
                component[i] = comp;
            } else {
                comp++;
                component[i] = comp; 
            }
        }

        int qn = queries.length;
        boolean[] res = new boolean[qn];

        for (int i = 0; i < qn; i++) {
            int u = queries[i][0];
            int v = queries[i][1];

            res[i] = component[u] == component[v];
        }

        return res;
    }
}