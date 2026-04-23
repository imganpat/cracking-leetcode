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
 
// Approach: Linked List Simulation + Carry Handling
// 1. Traverse both linked lists simultaneously.
// 2. At each step:
//    - Take values from l1 and l2 (0 if null).
//    - Add them along with carry.
// 3. Compute:
//    - digit = sum % 10
//    - carry = sum / 10
// 4. Create a new node with the digit and attach to result list.
// 5. Move pointers forward.
// 6. After loop, if carry remains, add a final node.
// 7. Return head of the new list.
//
// Time complexity: O(max(n, m))
//   - Traverse both lists once
// Space complexity: O(max(n, m))
//   - New list created

class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode head = null, curr = null;
        int carry = 0;

        // Traverse both lists
        while (l1 != null || l2 != null) {

            int val1 = (l1 != null) ? l1.val : 0;
            int val2 = (l2 != null) ? l2.val : 0;

            int sum = carry + val1 + val2;

            int digit = sum % 10;
            carry = sum / 10;

            ListNode node = new ListNode(digit);

            // Initialize head
            if (head == null) {
                head = curr = node;
            } else {
                curr.next = node;
                curr = node;
            }

            // Move pointers
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        // If carry remains
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }

        return head;
    }
}