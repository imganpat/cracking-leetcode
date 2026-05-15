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
    Map<Integer, TreeNode> map = new HashMap<>();
    Set<Integer> hasParent = new HashSet<>();

    public TreeNode createBinaryTree(int[][] descriptions) {
        for (int[] desc: descriptions) {
            int parentVal = desc[0];
            int childVal = desc[1];
            int isLeft = desc[2];

            TreeNode parentNode = map.computeIfAbsent(
                parentVal, k -> new TreeNode(k)
            );

            TreeNode childNode = map.computeIfAbsent(
                childVal, k -> new TreeNode(k)
            );

            if (isLeft == 1) parentNode.left = childNode;
            else parentNode.right = childNode;

            hasParent.add(childVal);
        }

        for (int nodeVal: map.keySet()) {
            if (!hasParent.contains(nodeVal)) 
                return map.get(nodeVal);
        }

        return null;
    }
}