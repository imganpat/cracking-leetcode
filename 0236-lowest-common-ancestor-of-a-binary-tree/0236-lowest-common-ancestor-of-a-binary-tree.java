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
    TreeNode res = null;

    public int helper(TreeNode node, TreeNode p, TreeNode q){
        if(node == null){
            return 0;
        }
        
        int count = 0;
        if(node == p || node == q){
            count = 1;
        }

        int left = helper(node.left, p, q);
        int right = helper(node.right, p, q);

        int total = count + left + right;
        
        if(total == 2 && res == null){
            res = node;
        }

        return total;

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        helper(root, p , q);
        return res;
    }
}