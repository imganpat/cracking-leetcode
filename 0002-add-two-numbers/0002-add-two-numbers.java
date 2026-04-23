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
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null, curr = null;

        int carry = 0;
        while (l1 != null || l2 != null) {
            int val1 = (l1 != null) ? l1.val : 0;
            int val2 = (l2 != null) ? l2.val : 0;

            int add = carry + val1 + val2;
            int digit = add % 10;
            
            carry = add / 10;

            ListNode node = new ListNode(digit, null);
            
            if (head == null) {
                head = curr = node;
            }
            else {
                curr.next = node;
                curr = node;

            }
            
            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;
        }

        if (carry == 1) {
            ListNode node = new ListNode(carry, null);
            curr.next = node;
            curr = node;
        }

        return head;
    }
}