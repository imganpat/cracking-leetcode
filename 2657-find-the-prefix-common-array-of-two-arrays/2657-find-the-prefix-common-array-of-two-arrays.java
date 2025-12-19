// Approach: Prefix Tracking using HashSet
// 1. Use two HashSets to keep track of elements seen so far in arrays A and B respectively.
// 2. Maintain a running count of common elements found up to the current index.
// 3. For each index i:
//    - If A[i] == B[i], it directly contributes 1 to the common count.
//    - Otherwise:
//        • If A[i] already appeared in B’s prefix, increment count.
//        • If B[i] already appeared in A’s prefix, increment count.
// 4. Add A[i] to set `a` and B[i] to set `b` after processing the checks.
// 5. Store the current count in the result array at index i.
// 6. Return the result array containing prefix common counts.
//
// Time complexity: O(n) – each element is processed once with O(1) average HashSet operations
// Space complexity: O(n) – HashSets store up to n elements in the worst case

class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        // Sets to track elements seen so far in A and B
        Set<Integer> a = new HashSet<>();
        Set<Integer> b = new HashSet<>();

        int n = A.length;
        int[] res = new int[n];
        int count = 0; // Tracks number of common elements so far

        for (int i = 0; i < n; i++) {
            // If both elements are same at index i, count once
            if (A[i] == B[i]) {
                count++;
            } else {
                // If A[i] already appeared in B's prefix
                if (b.contains(A[i])) {
                    count++;
                }
                // If B[i] already appeared in A's prefix
                if (a.contains(B[i])) {
                    count++;
                }
            }

            // Add current elements to respective sets
            a.add(A[i]);
            b.add(B[i]);

            // Store prefix common count
            res[i] = count;
        }

        return res;
    }
}
