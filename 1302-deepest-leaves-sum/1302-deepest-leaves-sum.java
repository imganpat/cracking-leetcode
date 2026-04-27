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
    List<List<Integer>> paths = new ArrayList<>();

    public void BFS(TreeNode node){
        if (node == null) return;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(node);

        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> curr = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode t = queue.poll();
                curr.add(t.val);

                if(t.left != null) queue.offer(t.left);
                if(t.right != null) queue.offer(t.right);
            }
            paths.add(curr);
        }
    }

    public int deepestLeavesSum(TreeNode root) {
        BFS(root);

        int sum = 0;
        List<Integer> lastLevel = paths.get(paths.size() - 1);

        for(int ele: lastLevel)
            sum += ele;
            
        return sum;
    }
}