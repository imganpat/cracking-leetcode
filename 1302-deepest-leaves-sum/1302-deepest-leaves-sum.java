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
    int res;
    public void BFS(TreeNode node){
        if (node == null) return;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(node);

        int sum = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            sum = 0;
            for(int i = 0; i < size; i++){
                TreeNode t = queue.poll();
                sum += t.val;

                if(t.left != null) queue.offer(t.left);
                if(t.right != null) queue.offer(t.right);
            }
        }
        res = sum;
    }

    public int deepestLeavesSum(TreeNode root) {
        BFS(root);
        return res;
    }
}