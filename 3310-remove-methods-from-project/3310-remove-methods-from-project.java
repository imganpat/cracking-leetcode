class Solution {
    List<List<Integer>> adj;

    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        Set<Integer> visited = new HashSet<>();
        Set<Integer> suspicious = new HashSet<>();

        adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < invocations.length; i++) {
            int u = invocations[i][0];
            int v = invocations[i][1];

            adj.get(u).add(v);
        }

        getSuspicious(k, suspicious, visited);

        for (int[] invocation : invocations) {
            int u = invocation[0];
            int v = invocation[1];
            if (!suspicious.contains(u) && suspicious.contains(v)) {
                List<Integer> ans = new ArrayList<>();
                for (int method = 0; method < n; method++) {
                    ans.add(method);
                }
                return ans;
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int method = 0; method < n; method++) {
            if (!suspicious.contains(method)) {
                ans.add(method);
            }
        }

        return ans;

    }

    private void getSuspicious(int k, Set<Integer> suspicious, Set<Integer> visited) {
        visited.add(k);
        suspicious.add(k);

        for (int method : adj.get(k)) {
            if (!visited.contains(method)) {
                getSuspicious(method, suspicious, visited);
            }
        }
    }
}