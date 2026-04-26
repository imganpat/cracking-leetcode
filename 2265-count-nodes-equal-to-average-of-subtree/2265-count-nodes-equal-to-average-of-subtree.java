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
    int res = 0;
    public int[] helper(TreeNode node){
        if (node == null) return new int[]{0,0};
        
        int[] left = helper(node.left);
        int[] right = helper(node.right);

        int sum = left[0] + right[0] + node.val;
        int count = left[1] + right[1] + 1;
        int avg = (int) (sum / count);

        if(avg == node.val){
            res++;
        }

        return new int[]{sum, count};

    }

    public int averageOfSubtree(TreeNode root) {
        helper(root);
        return res;
    }
}