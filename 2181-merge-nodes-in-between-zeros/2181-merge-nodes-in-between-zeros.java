// Approach: Traverse + Segment Sum
// 1. The linked list starts and ends with 0.
// 2. Nodes between two consecutive 0's form one segment.
// 3. Traverse the list starting after the first 0.
// 4. Maintain a running sum for the current segment.
// 5. For each node:
//    - If value != 0:
//         add it to the running sum.
//    - If value == 0:
//         create a new node containing the segment sum,
//         append it to the result list,
//         reset the sum to 0.
// 6. Continue until the end of the list.
// 7. Return the head of the newly constructed list.
//
// Time complexity: O(n)
//   - Each node visited once
// Space complexity: O(m)
//   - m = number of segments (new output list)

class Solution {
    public ListNode mergeNodes(ListNode head) {
        ListNode head2 = null;
        ListNode temp = null;

        // Skip the initial zero
        ListNode t = head.next;

        int sum = 0;

        while (t != null) {

            // End of current segment
            if (t.val == 0) {
                ListNode node = new ListNode(sum);

                if (head2 == null) {
                    head2 = node;
                    temp = node;
                } else {
                    temp.next = node;
                    temp = temp.next;
                }

                // Reset for next segment
                sum = 0;
            }

            // Continue accumulating
            else {
                sum += t.val;
            }

            t = t.next;
        }

        return head2;
    }
}