// Approach: Backtracking (Include / Exclude)
// 1. At each index, we have two choices:
//    - Exclude the current element.
//    - Include the current element.
// 2. Recursively explore both choices for every index.
// 3. When we reach the end of the array (i == nums.length),
//    add the current subset to the result.
// 4. Use backtracking:
//    - Add element → recurse → remove element (undo choice).
// 5. This generates all possible subsets (power set).
//
// Time complexity: O(2^n)
//   - Each element has 2 choices (include/exclude)
//   - Total subsets = 2^n
// Space complexity: O(n)
//   - Recursion depth + temporary subset storage

class Solution {

    public void backtrack(int i, int[] nums, Stack<Integer> curr, List<List<Integer>> res) {
        // Base case: reached end → store subset
        if (i == nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }

        // Choice 1: Exclude current element
        backtrack(i + 1, nums, curr, res);

        // Choice 2: Include current element        
        curr.push(nums[i]);
        backtrack(i + 1, nums, curr, res);

        // Choice 2: Include current element
        curr.pop();

    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        backtrack(0, nums, new Stack<>(), res);

        return res;
    }
}