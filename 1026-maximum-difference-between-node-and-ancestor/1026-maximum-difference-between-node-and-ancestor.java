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
    int res = 0;
    public void helper(TreeNode node, int v1, int v2) {
        if (node == null) return;
        
        int min = Math.min(node.val, v1);
        int max = Math.max(node.val, v2);
        
        res = Math.max(res, max - min);

        helper(node.left, min, max);
        helper(node.right, min, max);


    }
    public int maxAncestorDiff(TreeNode root) {
        helper(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
        return res;
    }
}