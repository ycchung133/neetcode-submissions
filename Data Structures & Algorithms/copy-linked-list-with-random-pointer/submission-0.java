/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node newHead = null;
        HashMap<Node, Node> map = new HashMap<>();
        while (head != null) {
            Node newNode = new Node(head.val);
            map.put(head, newNode);
            if (newHead == null) {
                newHead = newNode;
            }
            head = head.next;
        }
        for (Map.Entry<Node, Node> entry : map.entrySet()) {
            Node newNode = entry.getValue();
            newNode.next = map.get(entry.getKey().next);
            if (entry.getKey().random != null) {
                newNode.random = map.get(entry.getKey().random);
            }
        }
        return newHead;
    }
}
