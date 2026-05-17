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
    public int helper(TreeNode node, int v1, int v2) {
        if (node == null) return v2 - v1;
        
        int min = Math.min(node.val, v1);
        int max = Math.max(node.val, v2);
        
        int left  = helper(node.left, min, max);
        int right = helper(node.right, min, max);

        return Math.max(left, right);
    }
    public int maxAncestorDiff(TreeNode root) {
        return helper(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
        // return res;
    }
}