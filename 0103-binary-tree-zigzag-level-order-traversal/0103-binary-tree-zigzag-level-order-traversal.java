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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        
        if(root == null){
            return res;
        }
        
        Deque<TreeNode> queue = new ArrayDeque<>();
        
        queue.offer(root);
        
        boolean leftToRight = true;
        
        while(!queue.isEmpty()){
            int levelSize = queue.size();
            List<Integer> levelEle = new ArrayList<>(Collections.nCopies(levelSize, 0));
            
            for(int i = 0 ; i < levelSize; i++ ){
                TreeNode node = queue.poll();
                
                if(leftToRight){
                    levelEle.set(i, node.val);
                }else{
                    levelEle.set(levelSize - 1 - i, node.val);
                }
                
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
            
            res.add(levelEle);
            leftToRight = !leftToRight;
        }
        return res;
    }
}