/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode res;
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        helper(cloned, target);
        return res;
    }

    public void helper(TreeNode cloned, TreeNode target) {
        if (cloned == null) {
            return;
        } 
        
        if (cloned.val == target.val) {
            res = cloned;
            return;
        }

        helper(cloned.left, target);
        helper(cloned.right, target);
    }
}