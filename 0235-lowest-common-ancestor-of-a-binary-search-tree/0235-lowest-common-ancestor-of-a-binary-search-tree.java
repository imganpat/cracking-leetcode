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
    TreeNode res;

    public void helper(TreeNode node, TreeNode p, TreeNode q){
        if (node == null){
            return;
        }

        if(node.val > p.val && node.val > q.val){
            helper(node.left, p , q);
        }

        else if (node.val < p.val && node.val < q.val){
            helper(node.right, p , q);
        }

        else {
            res = node;
            return;
        }

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // helper(root, p, q);
        // return res;
        TreeNode res;
        TreeNode curr = root;
        while(curr != null){
            if(curr.val > p.val && curr.val > q.val){
                curr = curr.left;
            }
            else if(curr.val < p.val && curr.val < q.val){
                curr = curr.right;
            }
            else{
                return curr;
            }
        }
        return null;
    }
}