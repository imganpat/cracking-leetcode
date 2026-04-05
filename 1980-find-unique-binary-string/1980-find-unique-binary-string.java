// Approach: Backtracking (Generate Binary Strings + Set Lookup)
// 1. Store all given binary strings in a HashSet for O(1) lookup.
// 2. Use backtracking to generate all binary strings of length n:
//    - At each position, try '0' and '1'.
// 3. When a full string of length n is formed:
//    - If it is NOT in the set, return it immediately.
// 4. Use early return to stop recursion once a valid string is found.
// 5. If no valid string found in a branch, return null.
//
// Time complexity: O(2^n)
//   - In worst case, explore all binary strings
// Space complexity: O(n)
//   - Recursion depth + StringBuilder

class Solution {

    Set<String> map;

    public String backtrack(String[] nums,
                            StringBuilder curr,
                            int i) {

        // Base case: full string formed
        if (i == nums.length) {
            if (!map.contains(curr.toString())) {
                return curr.toString();
            }
            return null;
        }

        // Choice 1: add '0'
        curr.append('0');
        String res = backtrack(nums, curr, i + 1);
        if (res != null) {
            return res; // early return if valid found
        }
        curr.deleteCharAt(curr.length() - 1);

        // Choice 2: add '1'
        curr.append('1');
        res = backtrack(nums, curr, i + 1);
        if (res != null) {
            return res;
        }
        curr.deleteCharAt(curr.length() - 1);

        return null;
    }

    public String findDifferentBinaryString(String[] nums) {

        // Step 1: Store all strings in set
        map = new HashSet<>();
        for (String s : nums) {
            map.add(s);
        }

        // Step 2: Generate and find missing string
        return backtrack(nums, new StringBuilder(), 0);
    }
}