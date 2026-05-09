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
    int wCount = 0;
    
    TreeNode prev = null;
    
    TreeNode w10 = null;
    TreeNode w11 = null;

    TreeNode w20 = null;
    TreeNode w21 = null;
    
    public void helper(TreeNode node) {
        if (node == null) return;

        helper(node.left);

        if (prev == null) {
            prev = node;
        }
        else {
            if(node.val <= prev.val) {
                wCount++;
                if (wCount == 1) {
                    w10 = prev;
                    w11 = node;
                } else {
                    w20 = prev;
                    w21 = node;
                }
            }
            prev = node;
        }

        helper(node.right);

    }

    public void recoverTree(TreeNode root) {
        helper(root);
         if (wCount == 1) {
            int temp = w10.val;
            w10.val = w11.val;
            w11.val = temp;
        } else {
            int temp = w10.val;
            w10.val = w21.val;
            w21.val = temp;
        }
    }
}