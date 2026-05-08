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
    TreeNode head = null;

    public void inOrderTraversal(List<Integer> res, TreeNode curr){
        if(curr == null){
            return;
        }
        inOrderTraversal(res, curr.left);
        res.add(curr.val);
        inOrderTraversal(res, curr.right);
    }

    public TreeNode helper(List<Integer> arr, int start, int end) {
        if (start > end) return null;

        int mid = (end + start) / 2;
        TreeNode node = new TreeNode(arr.get(mid));
        
        if (head == null) {
            head = node;
        }

        node.left = helper(arr, start, mid- 1);
        node.right = helper(arr, mid +1, end);

        return node;
    }

    public TreeNode balanceBST(TreeNode root) {
        List<Integer> arr = new ArrayList<>();
        inOrderTraversal(arr, root);
        return helper(arr, 0, arr.size() - 1);
    }
}