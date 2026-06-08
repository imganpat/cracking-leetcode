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

    public void helper(TreeNode node) {

        // Base case
        if (node == null) {
            return;
        }

        // Visit right (greater elements)
        helper(node.right);

        // Update running sum and node value
        sum += node.val;
        node.val = sum;

        // Visit left
        helper(node.left);
    }
    
    public TreeNode convertBST(TreeNode root) {
        helper(root);

        return root;
    }
}