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

 // Approach: DFS (Recursion) + Mirror Comparison
// 1. A tree is symmetric if its left and right subtrees are mirror images.
// 2. Define a helper function isSame(p, q):
//    - If both nodes are null → symmetric → return true.
//    - If one is null → not symmetric → return false.
//    - If values differ → not symmetric → return false.
// 3. Recursively check mirror condition:
//    - Left subtree of p with right subtree of q.
//    - Right subtree of p with left subtree of q.
// 4. Return true only if both mirror checks are true.
//
// Time complexity: O(n)
//   - Each node is visited once
// Space complexity: O(h)
//   - Recursion stack (h = height of tree)

class Solution {

    public boolean isSame(TreeNode p, TreeNode q) {

        // Both null → symmetric
        if (p == null && q == null) {
            return true;
        }

        // One null → not symmetric
        if (p == null || q == null) {
            return false;
        }

        // Values must match
        if (p.val != q.val) {
            return false;
        }

        // Mirror check:
        // left of p ↔ right of q
        boolean r1 = isSame(p.left, q.right);

        // right of p ↔ left of q
        boolean r2 = isSame(p.right, q.left);

        return r1 && r2;
    }

    public boolean isSymmetric(TreeNode root) {

        // Edge case: empty tree is symmetric
        if (root == null) {
            return true;
        }

        return isSame(root.left, root.right);
    }
}