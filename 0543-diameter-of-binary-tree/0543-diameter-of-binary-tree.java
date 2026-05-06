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
class Solution {
    int diameter = 0;

    public int helper(TreeNode node) {
        if (node == null)
            return 0;

        int left = helper(node.left);
        int right = helper(node.right);

        int sum = left + right;

        diameter = Math.max(sum, diameter);

        return 1 + Math.max(left, right);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return diameter;
    }
}