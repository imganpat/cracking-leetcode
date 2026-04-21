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
    public void gst(TreeNode node){
        if(node == null){
            return;
        }

        gst(node.right);
        
        sum += node.val;
        node.val = sum;
        
        gst(node.left);
    }

    public TreeNode bstToGst(TreeNode root) {
        gst(root);
        return root;
    }
}