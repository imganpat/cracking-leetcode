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
// Approach: Inorder Traversal + Detect Inversions
// 1. Inorder traversal of a BST should produce strictly increasing values.
// 2. If two nodes are swapped, this sorted order breaks.
// 3. During inorder traversal, compare current node with previous node.
// 4. If current.val <= prev.val, an inversion is found.
// 5. Two cases:
//    Case 1: Adjacent nodes swapped
//      Example: 1 3 2 4
//      → Only one inversion.
//
//    Case 2: Non-adjacent nodes swapped
//      Example: 1 5 3 4 2 6
//      → Two inversions.
//
// 6. Record:
//    - First inversion → first = prev, second = curr
//    - Second inversion → update second = curr
// 7. After traversal, swap values of first and second.
//
// Time complexity: O(n)
//   - Each node visited once
// Space complexity: O(h)
//   - Recursion stack

class Solution {

    TreeNode prev = null;

    TreeNode first = null;
    TreeNode second = null;

    public void helper(TreeNode node) {

        if (node == null) {
            return;
        }

        // Inorder traversal
        helper(node.left);

        // Detect inversion
        if (prev != null && node.val <= prev.val) {

            // First inversion
            if (first == null) {
                first = prev;
            }

            // Always update second
            second = node;
        }

        prev = node;

        helper(node.right);
    }

    public void recoverTree(TreeNode root) {

        helper(root);

        // Swap misplaced nodes
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
}