// Approach: Backtracking (Permutation Generation using 'used' array)
// 1. We build permutations by choosing elements one by one.
// 2. Use a boolean[] `used` to track which elements are already included.
// 3. At each recursion level:
//    - Loop through all elements.
//    - If an element is already used, skip it.
//    - Otherwise:
//        • Mark it as used.
//        • Add it to current permutation.
//        • Recurse to build further.
//        • Backtrack (remove + mark unused).
// 4. When current list size == nums.length, a full permutation is formed.
// 5. Add it to the result.
//
// Time complexity: O(n! * n)
//   - n! permutations, each takes O(n) to copy
// Space complexity: O(n)
//   - recursion depth + used array

class Solution {

    public void backtrack(List<List<Integer>> res,
                          List<Integer> curr,
                          int[] nums,
                          boolean[] used) {

        // Base case: full permutation formed
        if (curr.size() == nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }

        // Try all elements
        for (int i = 0; i < nums.length; i++) {

            // Skip already used elements
            if (used[i]) {
                continue;
            }

            // Choose
            used[i] = true;
            curr.add(nums[i]);

            // Explore
            backtrack(res, curr, nums, used);

            // Backtrack (undo choice)
            curr.remove(curr.size() - 1);
            used[i] = false;
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        backtrack(res, new ArrayList<>(), nums, new boolean[nums.length]);

        return res;
    }
}