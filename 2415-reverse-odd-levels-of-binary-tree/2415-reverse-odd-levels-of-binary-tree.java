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

// Approach: BFS (Level Order) + Reverse Values on Odd Levels
// 1. Traverse the tree level by level using a queue (BFS).
// 2. Maintain a boolean flag `reverse` to track odd levels.
// 3. For each level:
//    - Collect all nodes of that level in a list.
//    - Add their children to the queue for next level.
// 4. If it's an odd level (reverse == true):
//    - Swap values of nodes using two pointers (i, j).
// 5. Toggle the flag after each level.
// 6. Return the modified root.
//
// Time complexity: O(n)
//   - Each node visited once
// Space complexity: O(n)
//   - Queue + level storage

class Solution {

    public TreeNode reverseOddLevels(TreeNode root) {

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        boolean reverse = false;

        while (!queue.isEmpty()) {

            int levelSize = queue.size();
            List<TreeNode> levelNodes = new ArrayList<>();

            // Collect current level nodes
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                levelNodes.add(node);

                if (node.left != null)
                    queue.offer(node.left);

                if (node.right != null)
                    queue.offer(node.right);
            }

            // Reverse values on odd levels
            if (reverse) {
                int i = 0, j = levelNodes.size() - 1;

                while (i < j) {
                    int temp = levelNodes.get(i).val;
                    levelNodes.get(i).val = levelNodes.get(j).val;
                    levelNodes.get(j).val = temp;
                    i++;
                    j--;
                }
            }

            // Toggle level
            reverse = !reverse;
        }

        return root;
    }
}