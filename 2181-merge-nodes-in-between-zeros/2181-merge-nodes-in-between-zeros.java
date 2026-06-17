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
    public ListNode mergeNodes(ListNode head) {
        ListNode head2 = null;
        ListNode temp = null;
        ListNode t = head.next;
        int sum = 0;
        
        while (t != null) {
            if (t.val == 0) {
                ListNode n = new ListNode(sum);

                if (head2 == null) {
                    head2 = n;
                    temp = n;
                } else {
                    temp.next = n;
                    temp = temp.next;
                }
                sum = 0;    

            } else {
                sum += t.val;
            }

            t = t.next;
        }

        return head2;
    }
}