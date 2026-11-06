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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode i  = head;
        int n = 0;

        while  (i !=  null){
            i = i.next;
            n++;
        }

        int sizeLimit = n / k;
        int firstLimitExtra = n % k;

        i = head;

        ListNode[] res = new ListNode[k];

        for (int j =  0; j <  k; j++) {
            int size = sizeLimit;

            if (j < firstLimitExtra) {
                size++;
            }
            
            ListNode node = i;
            
            for (int count = 1; count < size && i != null; count++) {
                i = i.next;
            }

            if (i !=  null) {
                ListNode next = i.next;

                i.next = null;

                i = next;
            }

            res[j] = node;
        }

        return res;
    }
}