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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode head = null;
        ListNode tail = null;
        while (l1 != null || l2 != null || carry > 0) {
            int value = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            carry = value / 10;
            value = value % 10;
            if (head == null) {
                head = new ListNode();
                head.val = value;
                tail = head;
            } else {
                ListNode newNode = new ListNode();
                newNode.val = value;
                tail.next = newNode;
                tail = newNode;
            }
        }
        return head;
    }
}
