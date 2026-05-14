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
// Approach: Recursion + Divide & Conquer + Memoization
// 1. A full binary tree (FBT) means every node has either:
//    - 0 children, or
//    - 2 children.
// 2. Therefore, total number of nodes must always be odd.
//    - If n is even → no valid trees.
// 3. Base case:
//    - If n == 1, only one tree exists: a single node.
// 4. For n > 1:
//    - Root uses 1 node.
//    - Remaining (n - 1) nodes are split into:
//        leftNodes + rightNodes = n - 1
//    - Both leftNodes and rightNodes must be odd.
// 5. Recursively generate all left and right subtree combinations.
// 6. Combine every left subtree with every right subtree.
// 7. Use memoization to avoid recomputing results for same n.
//
// Time complexity: Exponential (Catalan-like), greatly reduced by memoization
// Space complexity: O(number of generated trees + recursion stack)

class Solution {

    // Memoization: n -> all possible trees with n nodes
    Map<Integer, List<TreeNode>> cache = new HashMap<>();

    public List<TreeNode> allPossibleFBT(int n) {

        // Return cached result
        if (cache.containsKey(n)) {
            return cache.get(n);
        }

        List<TreeNode> res = new ArrayList<>();

        // Even number of nodes → impossible
        if (n % 2 == 0) {
            return res;
        }

        // Base case: single node
        if (n == 1) {
            res.add(new TreeNode(0));

            cache.put(n, res);

            return res;
        }

        // Try all odd splits
        for (int leftNodes = 1;
             leftNodes < n;
             leftNodes += 2) {

            int rightNodes = n - 1 - leftNodes;

            List<TreeNode> leftTrees =
                    allPossibleFBT(leftNodes);

            List<TreeNode> rightTrees =
                    allPossibleFBT(rightNodes);

            // Combine all left-right pairs
            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {

                    TreeNode root =
                            new TreeNode(0, left, right);

                    res.add(root);
                }
            }
        }

        // Cache result
        cache.put(n, res);

        return res;
    }
}