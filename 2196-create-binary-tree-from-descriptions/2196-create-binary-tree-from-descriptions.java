// Approach: HashMap + Parent Tracking
// 1. Each description contains:
//    - parent value
//    - child value
//    - whether child is left or right
// 2. Use a HashMap:
//    - value → TreeNode
//    - Ensures each value maps to exactly one node object.
// 3. For every description:
//    - Create/get parent node.
//    - Create/get child node.
//    - Connect child to left/right based on isLeft.
// 4. Track all child nodes in a set.
// 5. After building the tree:
//    - The root is the only node that never appears as a child.
// 6. Return that root.
//
// Time complexity: O(n)
//   - One pass to build + one pass to find root
// Space complexity: O(n)
//   - HashMap + HashSet

class Solution {

    // value -> TreeNode
    Map<Integer, TreeNode> map = new HashMap<>();

    // Nodes that appear as children
    Set<Integer> hasParent = new HashSet<>();

    public TreeNode createBinaryTree(int[][] descriptions) {

        // Step 1: Build nodes and connect them
        for (int[] desc : descriptions) {

            int parentVal = desc[0];
            int childVal = desc[1];
            int isLeft = desc[2];

            // Create/get parent node
            TreeNode parentNode = map.computeIfAbsent(
                    parentVal,
                    k -> new TreeNode(k));

            // Create/get child node
            TreeNode childNode = map.computeIfAbsent(
                    childVal,
                    k -> new TreeNode(k));

            // Connect nodes
            if (isLeft == 1) {
                parentNode.left = childNode;
            } else {
                parentNode.right = childNode;
            }

            // Child has a parent
            hasParent.add(childVal);
        }

        // Step 2: Root = node that never appears as child
        for (int nodeVal : map.keySet()) {
            if (!hasParent.contains(nodeVal)) {
                return map.get(nodeVal);
            }
        }

        return null;
    }
}