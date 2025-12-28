/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { thi ++++++++++s.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        ListNode slow = head, fast = head;
        ListNode mid = null;

        // find the mid of list
        while(fast != null && fast.next!= null){
            slow = slow.next;
            fast = fast.next.next;
        }
        mid = slow;

        // reverse the second half
        ListNode prev = null, curr = mid;
        while(curr != null){
            ListNode t = curr.next;
            curr.next = prev;
            prev = curr;
            curr = t;
        }


        // merge two halves
        // first half excluding mid
        // reversed second half 
        ListNode list1 = head;
        ListNode list2 = prev;

        while (list2.next != null) {
            ListNode t1 = list1.next;
            ListNode t2 = list2.next;

            list1.next = list2;
            list2.next = t1;

            list1 = t1;
            list2 = t2;
        }
    }
}