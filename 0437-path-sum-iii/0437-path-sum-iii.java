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

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }

        return count(root, (long) targetSum)
                + pathSum(root.left, targetSum)
                + pathSum(root.right, targetSum);
    }

    private int count(TreeNode node, long target) {
        if (node == null) {
            return 0;
        }

        int ans = 0;

        if (node.val == target) {
            ans++;
        }

        ans += count(node.left, target - node.val);
        ans += count(node.right, target - node.val);

        return ans;
    }
}