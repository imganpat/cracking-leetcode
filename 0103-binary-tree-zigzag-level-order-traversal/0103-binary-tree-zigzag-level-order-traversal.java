// Approach: BFS (Level Order) + Zigzag Ordering
// 1. Perform normal level order traversal using a queue (BFS).
// 2. Maintain a boolean flag `leftToRight` to control direction.
// 3. For each level:
//    - Create a list of size = levelSize (pre-filled).
//    - For each node at index i:
//        • If leftToRight → place at index i.
//        • Else → place at index (levelSize - 1 - i).
// 4. Add children to queue as usual.
// 5. After finishing the level, toggle the direction.
// 6. Add level list to result.
//
// Time complexity: O(n)
//   - Each node is processed once
// Space complexity: O(n)
//   - Queue + result storage

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();

        // Edge case
        if (root == null) {
            return res;
        }

        // Queue for BFS
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        boolean leftToRight = true;

        while (!queue.isEmpty()) {

            int levelSize = queue.size();

            // Pre-fill list to allow index-based placement
            List<Integer> levelEle =
                    new ArrayList<>(Collections.nCopies(levelSize, 0));

            for (int i = 0; i < levelSize; i++) {

                TreeNode node = queue.poll();

                // Place value based on direction
                if (leftToRight) {
                    levelEle.set(i, node.val);
                } else {
                    levelEle.set(levelSize - 1 - i, node.val);
                }

                // Add children
                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            res.add(levelEle);

            // Flip direction
            leftToRight = !leftToRight;
        }

        return res;
    }
}   