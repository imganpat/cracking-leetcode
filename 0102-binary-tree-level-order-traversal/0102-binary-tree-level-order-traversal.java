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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        if(root == null){
            return res;
        }
        queue.offer(root);
        while(!queue.isEmpty()){
            int levelSize = queue.size();
            List<Integer> levelEle = new ArrayList<>();
            while(levelSize > 0){
                TreeNode t = queue.poll();
                levelEle.add(t.val);

                if(t.left != null){
                    queue.offer(t.left);
                }
                
                if(t.right != null){
                    queue.offer(t.right);
                }

                levelSize--;
            }
            res.add(levelEle);
        }
        return res;
    }
}