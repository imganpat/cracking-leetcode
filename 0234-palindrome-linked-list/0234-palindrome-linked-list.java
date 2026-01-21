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
    public boolean isPalindrome(ListNode head) {
        List<Integer> stack = new ArrayList<>();
        ListNode ptr = head;
        while(ptr != null){
            stack.add(ptr.val);
            ptr = ptr.next;
        }

        ptr = head;
        while(ptr != null){
            if(stack.remove(stack.size() -1 ) != ptr.val){
                return false;
            }
            ptr = ptr.next;
        }

        return true;

    }
}