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
    Map<TreeNode, TreeNode> map = new HashMap<>();
    int res = -1;

    public void createMap(TreeNode node) {
        if (node == null) return;
        
        if (node.left != null)
            map.put(node.left, node);

        if (node.right != null)
            map.put(node.right, node);
        
        createMap(node.left);
        createMap(node.right);
    }

    public TreeNode getStartNode(TreeNode node, int target) {
        if (node == null) return null;

        if (node.val == target) return node;

        TreeNode left = getStartNode(node.left, target);
        if (left != null) return left;

        return getStartNode(node.right, target);
    }

    public void bfs(TreeNode node) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        Set<TreeNode> visited = new HashSet<>();

        queue.offer(node);
        visited.add(node);

        while (!queue.isEmpty()) {
            int lvlSize = queue.size();
            for (int i = 0; i < lvlSize; i++) {
                TreeNode t = queue.poll();

                if (t.left != null && !visited.contains(t.left)) {
                    queue.offer(t.left);
                    visited.add(t.left);
                }

                if (t.right != null && !visited.contains(t.right)) {
                    queue.offer(t.right);
                    visited.add(t.right);
                }

                TreeNode parent = map.get(t);

                if(parent != null && !visited.contains(parent)) {
                    queue.offer(parent);
                    visited.add(parent);
                }
            }
            res++;
        }
    }

    public int amountOfTime(TreeNode root, int start) {
        createMap(root);
        TreeNode startNode = getStartNode(root, start);
        bfs(startNode);
        return res;
    }
}