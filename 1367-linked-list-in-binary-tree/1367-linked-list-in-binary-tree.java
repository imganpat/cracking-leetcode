/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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

// Approach: DFS + Path Matching
// 1. For every tree node, try to start matching the linked list.
// 2. Use helper function `match(head, root)`:
//    - If head == null → entire linked list matched → return true.
//    - If root == null → tree path ended before list → return false.
//    - If values differ → return false.
//    - Otherwise continue matching:
//         head.next with root.left
//         OR
//         head.next with root.right
// 3. In isSubPath():
//    - Check if matching starts at current root.
//    - If not, recursively try starting from left subtree.
//    - If not, recursively try starting from right subtree.
// 4. Return true if any starting node produces a complete match.
//
// Time complexity: O(N × M)
//   - N = number of tree nodes
//   - M = length of linked list
//   - In worst case, matching may start from many nodes
// Space complexity: O(H + M)
//   - Tree recursion depth + matching recursion depth

class Solution {

    // Checks whether linked list matches a downward tree path
    public boolean match(ListNode head, TreeNode root) {

        // Entire list matched
        if (head == null) {
            return true;
        }

        // Tree path ended
        if (root == null) {
            return false;
        }

        // Values must match
        if (head.val != root.val) {
            return false;
        }

        // Continue on either child
        return match(head.next, root.left)
                || match(head.next, root.right);
    }

    public boolean isSubPath(ListNode head, TreeNode root) {

        // No tree left
        if (root == null) {
            return false;
        }

        // Start match here OR try children
        return match(head, root)
                || isSubPath(head, root.left)
                || isSubPath(head, root.right);
    }
}