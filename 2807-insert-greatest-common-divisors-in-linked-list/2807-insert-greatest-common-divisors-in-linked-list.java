// Approach: Linked List Traversal + Euclidean GCD
// 1. Traverse the linked list using adjacent pointers:
//      p -> current node
//      q -> next node
// 2. For every adjacent pair:
//      (p.val, q.val)
//    compute their Greatest Common Divisor (GCD).
// 3. Create a new node containing the GCD.
// 4. Insert that node between p and q.
// 5. Move pointers forward to process next original pair.
// 6. Return the modified linked list.
//
// Time complexity: O(n * log(maxValue))
//   - n = number of nodes
//   - Euclidean GCD is logarithmic
// Space complexity: O(1)
//   - Ignoring output nodes

class Solution {

    public ListNode insertGreatestCommonDivisors(ListNode head) {

        ListNode p = head;
        ListNode q = head.next;

        while (q != null) {

            // Compute GCD
            int v = getGCD(p.val, q.val);

            // Create new node
            ListNode newNode = new ListNode(v);

            // Insert between p and q
            p.next = newNode;
            newNode.next = q;

            // Move to next original pair
            p = q;
            q = p.next;
        }

        return head;
    }

    // Euclidean Algorithm
    public int getGCD(int x, int y) {

        while (y != 0) {

            int t = y;

            y = x % y;

            x = t;
        }

        return x;
    }
}