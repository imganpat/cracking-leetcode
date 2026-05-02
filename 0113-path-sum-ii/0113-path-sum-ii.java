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
    public void backtrack(List<List<Integer>> res, List<Integer> curr, TreeNode node, int sum, int targetSum){
        if(node == null){
            return;
        }
        sum += node.val;
        curr.add(node.val);

        if(node.left == null && node.right == null && sum == targetSum){
            res.add(new ArrayList<>(curr));
        }
        else{
            backtrack(res, curr, node.left, sum, targetSum);
            backtrack(res, curr, node.right, sum, targetSum);
        }
        curr.remove(curr.size() - 1);
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), root, 0, targetSum);
        return res;
    }
}