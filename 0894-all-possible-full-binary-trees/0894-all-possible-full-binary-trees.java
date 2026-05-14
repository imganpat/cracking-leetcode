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
    Map<Integer, List<TreeNode>> cache = new HashMap<>();

    public List<TreeNode> allPossibleFBT(int n) {
        if (cache.containsKey(n)) return cache.get(n);

        List<TreeNode> res = new ArrayList<>();
        
        if (n % 2 == 0) return res;


        if (n == 1) {
            res.add(new TreeNode(0));
            cache.put(n, res);
            return res;
        }

        for (int leftNodes = 1 ; leftNodes < n; leftNodes += 2) {
            int rightNodes = n - 1 - leftNodes;

            List<TreeNode> leftTrees = allPossibleFBT(leftNodes);
            List<TreeNode> rightTrees = allPossibleFBT(rightNodes);

            for (TreeNode left: leftTrees) {
                for (TreeNode right: rightTrees) {

                    TreeNode root = new TreeNode(0, left, right);

                    res.add(root);
                }
            }
        }

        cache.put(n, res);

        return res;
    }
}