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

 
// Approach: Monotonic Stack + Rebuild Linked List
// 1. Traverse the linked list and use a stack to maintain nodes in decreasing order of values.
// 2. For each current node:
//    - While the stack is not empty and the value at the top of the stack is smaller than
//      the current node’s value, pop the stack.
//    - This ensures that nodes with a greater value on their right are removed.
// 3. Push the current node onto the stack.
// 4. After traversal, the stack contains only nodes that should remain, but in reverse order.
// 5. Rebuild the linked list by popping nodes from the stack and adjusting their `next` pointers.
// 6. Return the rebuilt list as the result.
//
// Time complexity: O(n) – each node is pushed and popped at most once
// Space complexity: O(n) – stack stores up to n nodes

class Solution {
    public ListNode removeNodes(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode curr = head;

        // Step 1: Traverse list and maintain monotonic stack
        while (curr != null) {
            // Remove nodes smaller than current node
            while (!stack.isEmpty() && stack.peek().val < curr.val) {
                stack.pop();
            }
            stack.push(curr);
            curr = curr.next;
        }

        // Step 2: Rebuild the result list from stack
        ListNode res = null;
        while (!stack.isEmpty()) {
            ListNode node = stack.pop();
            node.next = res;
            res = node;
        }

        return res;
    }
}
