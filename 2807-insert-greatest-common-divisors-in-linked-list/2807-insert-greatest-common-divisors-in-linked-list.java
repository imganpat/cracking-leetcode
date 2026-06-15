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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode p = head;
        ListNode q = head.next;

        while (q != null) {
            int v = getGCD(p.val, q.val);

            ListNode newNode = new ListNode(v);
            p.next = newNode;
            newNode.next = q;

            p = q;
            q = p.next;
        }

        return head;
    }

    public int getGCD(int x, int y) {
        while (y != 0) {
            int t = y;
            y = x % y;
            x = t;
        }
        return x;
    }
}