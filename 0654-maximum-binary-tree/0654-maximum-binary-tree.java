/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
 
// Approach: Divide and Conquer + Recursion
// 1. For a given subarray [low...high]:
//    - Find the index of the maximum element.
// 2. Create a tree node with that maximum value.
// 3. Recursively build:
//    - Left subtree from elements left of max index.
//    - Right subtree from elements right of max index.
// 4. Base case:
//    - If low > high, no elements remain → return null.
// 5. Return the constructed root.
//
// Time complexity: O(n²) worst case
//   - For each recursive call, finding max may scan O(n)
//   - Worst case occurs for sorted array
// Space complexity: O(n)
//   - Recursion stack in worst case

class Solution {

    public TreeNode helper(int[] nums, int low, int high) {

        // Base case
        if (low > high) {
            return null;
        }

        // Find maximum element index
        int max = low;

        for (int i = low + 1; i <= high; i++) {
            if (nums[max] < nums[i]) {
                max = i;
            }
        }

        // Create root node
        TreeNode node = new TreeNode(nums[max]);

        // Build left and right subtrees
        node.left = helper(nums, low, max - 1);
        node.right = helper(nums, max + 1, high);

        return node;
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {

        return helper(nums, 0, nums.length - 1);
    }
}