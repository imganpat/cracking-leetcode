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
    boolean res = false;

    public void helper(TreeNode node, int target, int sum){
        if(node == null){
            return;
        }

        sum += node.val;
        
        if(node.left == null && node.right == null && sum == target){
            res = true;
            return ;
        }
        
        helper(node.left, target, sum);
        helper(node.right, target, sum);
    }
    
    public boolean hasPathSum(TreeNode root, int targetSum) {
        helper(root, targetSum, 0);
        return res;
    }
}