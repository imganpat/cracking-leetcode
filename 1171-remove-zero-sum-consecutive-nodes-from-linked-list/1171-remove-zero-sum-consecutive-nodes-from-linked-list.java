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
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode i = dummy;
        while (i != null) {
            int sum = 0;

            ListNode j = i.next;
            while (j != null) {
                sum += j.val;

                if (sum == 0) {
                    i.next = j.next;
                }

                j = j.next;
            }

            i = i.next;
        }

        return dummy.next;
    }
}