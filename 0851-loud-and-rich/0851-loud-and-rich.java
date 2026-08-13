class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList());
        }

        for (int[] pair : richer) {
            graph.get(pair[1]).add(pair[0]);
        }

        int[] answer = new int[n];

        for (int i = 0; i < n; i++) {
            answer[i] = dfs(i, graph, quiet, answer);
        }

        return answer;
    }

    private int dfs(int person, List<List<Integer>> graph, int[] quiet, int[] answer) {

        if (answer[person] != 0) {
            return answer[person];
        }

        answer[person] = person;

        for (int richerPerson: graph.get(person)) {
            int candidate = dfs(richerPerson, graph, quiet, answer);

            if (quiet[candidate] < quiet[answer[person]]) {
                answer[person] = candidate;
            }

        }

        return answer[person];
    } 
}