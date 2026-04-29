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
    public void helper(TreeNode node, int currSum) {
        if (node == null) return;

        currSum = currSum * 10 + node.val;
        
        if(node.left == null && node.right == null) {
            sum += currSum;
        }

        helper(node.left, currSum);
        helper(node.right, currSum);
    }

    public int sumNumbers(TreeNode root) {
        helper(root, 0);
        return sum;
    }
}