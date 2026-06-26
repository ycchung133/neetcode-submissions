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
        // Find the middle
        ListNode slow  = head;
        ListNode fast = head;
        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse from middle to end
        ListNode head1 = head;
        ListNode head2 = slow.next;
        ListNode temp = null;
        ListNode prev = null;
        while (head2 != null) {            
            temp = head2.next;
            head2.next = prev;
            prev = head2;
            head2 = temp;
        }
        
        head2 = prev;
        slow.next = null;

        // Merge head1 and head2
        while (head1 != null && head2 != null) {
            ListNode temp1 = head1.next;
            ListNode temp2 = head2.next;
            head1.next = head2;
            head2.next = temp1;
            head1 = temp1;
            head2 = temp2;
        }

    }
}
