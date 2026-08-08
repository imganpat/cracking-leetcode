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
    public ListNode doubleIt(ListNode head) {
        head = reverse(head);

        ListNode curr = head;
        int carry = 0;

        while (curr != null) {
            int value = curr.val * 2 + carry;

            curr.val = value % 10;
            carry = value / 10;

            curr = curr.next;
        }

        if (carry > 0) {
            ListNode newNode = new ListNode(carry);

            curr = head;
            while  (curr.next != null) {
                curr  = curr.next;
            }
            curr.next = newNode;
        }

        return reverse(head);
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}