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
// Approach: Postorder DFS + Aggregate (sum, count)
// 1. Traverse the tree in postorder (Left → Right → Root).
// 2. For each node, gather from children:
//    - left[0] = sum of left subtree, left[1] = count of nodes
//    - right[0] = sum of right subtree, right[1] = count
// 3. Compute for current node:
//    - sum = leftSum + rightSum + node.val
//    - count = leftCount + rightCount + 1
//    - avg = sum / count  (integer division)
// 4. If avg == node.val → increment result.
// 5. Return {sum, count} to parent.
//
// Time complexity: O(n)
//   - Each node processed once
// Space complexity: O(h)
//   - Recursion stack (h = height of tree)

class Solution {

    int res = 0;

    public int[] helper(TreeNode node) {

        // Base case
        if (node == null) return new int[]{0, 0};

        // Postorder: process children first
        int[] left = helper(node.left);
        int[] right = helper(node.right);

        int sum = left[0] + right[0] + node.val;
        int count = left[1] + right[1] + 1;

        int avg = sum / count;

        // Check condition
        if (avg == node.val) {
            res++;
        }

        // Return sum and count upward
        return new int[]{sum, count};
    }

    public int averageOfSubtree(TreeNode root) {
        helper(root);
        return res;
    }
}