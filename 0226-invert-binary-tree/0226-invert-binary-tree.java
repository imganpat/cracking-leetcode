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
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return root;
        }
        
        TreeNode curr = root;
        Deque<TreeNode> queue = new ArrayDeque<>();
        
        queue.offer(curr);
        
        while(!queue.isEmpty()){
            TreeNode i = queue.poll();
            
            TreeNode temp = i.left;
            i.left = i.right;
            i.right = temp;

            if(i.left != null){
                queue.offer(i.left);
            }

            if(i.right != null){
                queue.offer(i.right);
            } 
        }
        
        return root;
    }
}