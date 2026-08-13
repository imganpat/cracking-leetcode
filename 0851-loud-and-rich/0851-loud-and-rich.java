// Approach: DFS + Memoization on a Directed Graph
// 1. Create a directed graph where:
//      person -> people richer than that person.
// 2. For every person, run DFS to find the quietest person
//    among:
//      - themselves
//      - everyone richer than them
//      - everyone richer than those people
// 3. Use `answer[person]` as memoization:
//      - answer[person] == 0 means the state has not been computed.
//      - Otherwise, it stores the index of the quietest known person.
// 4. Initially, assume the person themselves is the answer.
// 5. For every richer person:
//      - Recursively find the quietest person reachable from them.
//      - Compare that person's quietness with the current answer.
// 6. Store the best result in answer[person].
// 7. Return the answer array.
//
// Time complexity: O(n + r)
//   - n = number of people
//   - r = number of richer relationships
//   - With memoization, each person is fully processed once.
//
// Space complexity: O(n + r)
//   - Graph + answer array + recursion stack

class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        List<List<Integer>> graph = new ArrayList<>();

        // Create adjacency list
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // person -> richer people
        for (int[] pair : richer) {

            int richerPerson = pair[0];
            int poorerPerson = pair[1];

            graph.get(poorerPerson).add(richerPerson);
        }

        int[] answer = new int[n];

        // Find the quietest reachable person
        for (int i = 0; i < n; i++) {
            answer[i] = dfs(i, graph, quiet, answer);
        }

        return answer;
    }

    private int dfs(int person,
                    List<List<Integer>> graph,
                    int[] quiet,
                    int[] answer) {

        // Already computed
        if (answer[person] != 0) {
            return answer[person];
        }

        // Initially, the person themselves is the answer
        answer[person] = person;

        // Check everyone richer than this person
        for (int richerPerson : graph.get(person)) {

            int candidate =
                    dfs(richerPerson,
                        graph,
                        quiet,
                        answer);

            // Choose the quieter person
            if (quiet[candidate] <
                quiet[answer[person]]) {

                answer[person] = candidate;
            }
        }

        return answer[person];
    }
}