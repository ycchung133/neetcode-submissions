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
    public void reorderList(ListNode head) {
        // Find the middle of the list.
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse the second list.
        ListNode second = slow.next;
        slow.next = null;
        ListNode temp = null;
        ListNode previous = null;
        while (second != null) {
            temp = second.next;
            second.next = previous;
            previous = second;
            second = temp;
        }

        // Merge two lists.
        ListNode head1 = head;
        ListNode head2 = previous;
        while (head2 != null) {
            ListNode temp1 = head1.next;
            ListNode temp2 = head2.next;
            head1.next = head2;
            head2.next = temp1;
            head1 = temp1;
            head2 = temp2;
        }
    }
}
