/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// Approach: DFS (Postorder) + Count Propagation
// 1. Traverse the tree using DFS (postorder).
// 2. For each node:
//    - Check if current node is either p or q → count = 1 if yes.
//    - Recursively get counts from left and right subtrees.
// 3. Total count at a node = self + left + right.
// 4. If total count becomes 2 for the first time:
//    - That node is the Lowest Common Ancestor (LCA).
// 5. Store result only once (res == null check).
// 6. Return count upwards to parent.
//
// Time complexity: O(n)
//   - Each node visited once
// Space complexity: O(h)
//   - Recursion stack (h = height of tree)

class Solution {

    TreeNode res = null;

    public int helper(TreeNode node, TreeNode p, TreeNode q) {

        // Base case
        if (node == null) {
            return 0;
        }

        // Check if current node is p or q
        int count = (node == p || node == q) ? 1 : 0;

        // Traverse left and right
        int left = helper(node.left, p, q);
        int right = helper(node.right, p, q);

        // Aggregate counts
        count += left + right;

        // First node where both found → LCA
        if (count == 2 && res == null) {
            res = node;
        }

        return count;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        helper(root, p, q);

        return res;
    }
}