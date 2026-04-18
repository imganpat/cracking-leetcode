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
    public void invert(TreeNode node){
        if(node == null){
            return;
        }
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;

        invert(node.left);
        invert(node.right);
    }

    public TreeNode invertTree(TreeNode root) {
        invert(root);
        
        return root;
        // if(root == null){
        //     return root;
        // }
        
        // Deque<TreeNode> queue = new ArrayDeque<>();
        
        // queue.offer(root);
        
        // while(!queue.isEmpty()){
        //     TreeNode curr = queue.poll();
            
        //     TreeNode temp = curr.left;
        //     curr.left = curr.right;
        //     curr.right = temp;

        //     if(curr.left != null){
        //         queue.offer(curr.left);
        //     }

        //     if(curr.right != null){
        //         queue.offer(curr.right);
        //     } 
        // }
        
        // return root;
    }
}