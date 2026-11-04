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
    List<Integer> arr;

    public int kthSmallest(TreeNode root, int k) {
        arr = new ArrayList<>();
        inorderTraversal(root);
        return arr.get(k - 1);
    }

    private void inorderTraversal(TreeNode node) {
        if(node == null) {
            return;
        }

        inorderTraversal(node.left);
        arr.add(node.val);
        inorderTraversal(node.right);
    }
}