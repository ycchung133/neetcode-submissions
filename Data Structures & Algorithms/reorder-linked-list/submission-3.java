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
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
            fast = fast.next;
        }

        ListNode second = slow.next;
        slow.next = null;
        ListNode previous = null;
        ListNode curr = second;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = previous;
            previous = curr;
            curr = next;
        }

        ListNode list1 = head;
        ListNode list2 = previous;
        ListNode tail = null;
        boolean isFromList1 = true;
        while (list1 != null || list2 != null) {
            ListNode temp;
            if (isFromList1) {
                if (list1 != null) {
                    temp = list1;
                    list1 = list1.next;
                } else {
                    temp = list2;
                    list2 = list2.next;    
                }
                isFromList1 = false;
            } else {
                if (list2 != null) {
                    temp = list2;
                    list2 = list2.next;    
                } else {
                    temp = list1;
                    list1 = list1.next;
                }
                isFromList1 = true;
            }
            if (tail == null) {
                tail = temp;
            } else {
                tail.next = temp;
                tail = temp;
            }
        }
    }
}
