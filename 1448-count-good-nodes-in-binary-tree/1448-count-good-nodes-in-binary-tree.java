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
    int count = 0;
    public void helper(TreeNode node, int max) {
        if (node == null) return;

        if(max <= node.val) {
            count++;
            max = node.val;
        }

        helper(node.left, max);
        helper(node.right, max);
    }

    public int goodNodes(TreeNode root) {
        helper(root, Integer.MIN_VALUE);

        return count;
    }
}