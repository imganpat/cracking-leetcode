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
            TreeNode parentNode = null;
            TreeNode childNode = null;

            if (map.containsKey(parentVal)) 
                parentNode = map.get(parentVal);
            else
                parentNode = new TreeNode(parentVal);

            if (map.containsKey(childVal))
                childNode = map.get(childVal);
            else
                childNode = new TreeNode(childVal);

            if (isLeft == 1) parentNode.left = childNode;
            else parentNode.right = childNode;

            hasParent.add(childVal);
            map.put(parentVal, parentNode);
            map.put(childVal, childNode);
        }

        for (int nodeVal: map.keySet()) {
            if (!hasParent.contains(nodeVal)) 
                return map.get(nodeVal);
        }

        return null;
    }
}