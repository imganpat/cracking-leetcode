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
// Approach: Reverse Inorder Traversal (Right → Root → Left)
// 1. In a BST, inorder traversal gives sorted order (Left → Root → Right).
// 2. To accumulate greater values, traverse in reverse order:
//    Right → Root → Left.
// 3. Maintain a running sum of visited nodes.
// 4. For each node:
//    - First visit right subtree (greater values).
//    - Add current node value to running sum.
//    - Update node value with the sum.
//    - Then visit left subtree.
// 5. This ensures each node becomes sum of all greater-or-equal values.
//
// Time complexity: O(n)
//   - Each node visited once
// Space complexity: O(h)
//   - Recursion stack (h = height of tree)

class Solution {

    int sum = 0;

    public void helper(TreeNode node) {

        // Base case
        if (node == null) {
            return;
        }

        // Visit right (greater elements)
        helper(node.right);

        // Update running sum and node value
        sum += node.val;
        node.val = sum;

        // Visit left
        helper(node.left);
    }

    public TreeNode bstToGst(TreeNode root) {

        helper(root);

        return root;
    }
}