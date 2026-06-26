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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode head1 = dummy;
        ListNode head2 = dummy;

        for (int i = 0; i <= n; ++i) {
            head2 = head2.next;
        }

        while (head2 != null) {
            head1 = head1.next;
            head2 = head2.next;
        }

        head1.next = head1.next.next;

        return dummy.next;
    }
}
