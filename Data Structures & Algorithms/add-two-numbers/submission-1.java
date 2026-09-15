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
        int r = 0;
        ListNode head = null;
        ListNode tail = null;
        while (l1 != null || l2 != null || r != 0) {
            int temp = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + r;
            r = temp / 10;
            temp = temp % 10;
            ListNode node = new ListNode();
            node.val = temp;
            if (head == null) {
                head = node;
                tail = node;
            } else {
                tail.next = node;
                tail = node;
            }
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        return head;
    }
}
