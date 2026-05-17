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

// Approach: DFS + Path Tracking (Min / Max on Root-to-Node Path)
// 1. Traverse the tree using DFS.
// 2. For each root-to-current-node path, maintain:
//    - minimum value seen so far
//    - maximum value seen so far
// 3. At current node:
//    - Update path minimum and maximum.
// 4. The maximum ancestor difference on this path is:
//    max - min
// 5. Update global result with this difference.
// 6. Continue DFS for left and right children.
//
// Time complexity: O(n)
//   - Each node visited once
// Space complexity: O(h)
//   - Recursion stack (h = height of tree)

class Solution {

    int res = 0;

    public void helper(TreeNode node,
            int minVal,
            int maxVal) {

        // Base case
        if (node == null) {
            return;
        }

        // Update path min and max
        minVal = Math.min(node.val, minVal);
        maxVal = Math.max(node.val, maxVal);

        // Update answer
        res = Math.max(res, maxVal - minVal);

        // Explore children
        helper(node.left, minVal, maxVal);
        helper(node.right, minVal, maxVal);
    }

    public int maxAncestorDiff(TreeNode root) {
        helper(root,
                Integer.MAX_VALUE,
                Integer.MIN_VALUE);

        return res;
    }
}