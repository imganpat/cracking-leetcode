/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// Approach: BST Property + DFS (Directed Search)
// 1. Use BST property: left < root < right.
// 2. For current node:
//    - If both p and q are smaller → LCA lies in left subtree.
//    - If both p and q are greater → LCA lies in right subtree.
//    - Otherwise → current node is the split point → LCA.
// 3. Traverse accordingly until LCA is found.
//
// Time complexity: O(h)
//   - h = height of tree (O(log n) for balanced, O(n) worst case)
// Space complexity: O(h)
//   - recursion stack

class Solution {

    TreeNode res;

    public void helper(TreeNode node, TreeNode p, TreeNode q) {

        if (node == null) {
            return;
        }

        // Both nodes lie in left subtree
        if (node.val > p.val && node.val > q.val) {
            helper(node.left, p, q);
        }

        // Both nodes lie in right subtree
        else if (node.val < p.val && node.val < q.val) {
            helper(node.right, p, q);
        }

        // Split point → this is LCA
        else {
            res = node;
            return;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        helper(root, p, q);

        return res;
    }
}