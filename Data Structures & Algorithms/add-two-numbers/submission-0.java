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
        while (l1 != null || l2 != null || r > 0) {
            int temp = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + r;
            r = temp / 10;
            temp = temp % 10;
            ListNode newNode = new ListNode();
            newNode.val = temp;
            if (tail == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
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