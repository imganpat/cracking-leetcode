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
    int sum = 0;
    public void helper(TreeNode node, String currSum){
        if (node == null) return;
        currSum += node.val;
        
        if(node.left == null && node.right == null) {
            sum += (Integer.parseInt(currSum));
        }

        helper(node.left, currSum);
        helper(node.right, currSum);
    }

    public int sumNumbers(TreeNode root) {
        helper(root, "");
        return sum;
    }
}