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
    int maxDepth = -1;
    TreeNode res = null;
    List<TreeNode> leaves = new ArrayList<>();

    void dfs(TreeNode node, int depth) {
        if (node == null) return;

        if (node.left == null && node.right == null) {
            if (depth > maxDepth) {
                maxDepth = depth;
                leaves.clear();
            }
        
            if (depth == maxDepth) 
                leaves.add(node);
            
            return;
        }

        dfs(node.left, depth + 1);
        dfs(node.right, depth + 1);
    }

    public int helper(TreeNode node, TreeNode p, TreeNode q){
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

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        dfs(root, 0);
        if (leaves.size() == 1) return leaves.get(0);
        helper(root, leaves.get(0) , leaves.get(leaves.size()-1));

        return res;
    }
}