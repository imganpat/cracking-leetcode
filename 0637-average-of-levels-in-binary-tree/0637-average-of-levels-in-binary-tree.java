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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        
        queue.offer(root);
        while( !queue.isEmpty() ){
            int levelSize = queue.size();
            double sum = 0;
            for(int i = 0; i < levelSize; i++){
                TreeNode node = queue.poll();
                sum += node.val;

                if(node.left != null){
                    queue.offer(node.left);
                }

                if(node.right != null){
                    queue.offer(node.right);
                }
            }
            res.add((double) sum / levelSize );
        }

        return res;

    }
}