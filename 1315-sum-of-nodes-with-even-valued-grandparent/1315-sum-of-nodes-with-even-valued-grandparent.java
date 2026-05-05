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

    public int dfs(TreeNode node){
        if (node == null) return 0;

        int sum = 0;

        if (node.val % 2 == 0) {
            if (node.left != null) {
                if (node.left.left != null)
                    sum += node.left.left.val;
                if (node.left.right != null)
                    sum += node.left.right.val;
            }
            
            if (node.right != null) {
                if (node.right.left != null)
                    sum += node.right.left.val;
                if (node.right.right != null)
                    sum += node.right.right.val;
            }
        }

        return sum + dfs(node.left) + dfs(node.right);
    }

    public int sumEvenGrandparent(TreeNode root) {
        return dfs(root);
    }
}