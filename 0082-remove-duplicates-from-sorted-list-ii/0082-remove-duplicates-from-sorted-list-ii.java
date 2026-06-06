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

// Approach: Two Pointers + Duplicate Group Removal
// 1. Use a dummy node to handle edge cases
//    (especially when duplicates appear at the beginning).
// 2. Maintain:
//      prev → last confirmed unique node
//      curr → current node being processed
// 3. For each group of nodes:
//    - Move curr forward while duplicates exist.
// 4. After loop:
//    Case 1: Duplicates found
//        prev.next != curr
//        → skip entire duplicate group.
//
//    Case 2: No duplicates
//        → move prev forward.
// 5. Continue until list ends.
// 6. Return dummy.next.
//
// Time complexity: O(n)
//   - Each node visited once
// Space complexity: O(1)

class Solution {

    public ListNode deleteDuplicates(ListNode head) {

        // Dummy node for easier deletion handling
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode curr = head;

        while (curr != null) {

            // Move curr to end of duplicate group
            while (curr.next != null && curr.val == curr.next.val) {

                curr = curr.next;
            }

            // Duplicate group detected
            if (prev.next != curr) {

                // Skip entire group
                prev.next = curr.next;
            }

            // Current node is unique
            else {
                prev = prev.next;
            }

            curr = curr.next;
        }

        return dummy.next;
    }
}