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
        Node temp = head;
        Node newHead = null;
        HashMap<Node, Node> map = new HashMap<>();
        while (temp != null) {
            Node newNode = new Node(temp.val);
            map.put(temp, newNode);
            temp = temp.next;
            if (newHead == null) {
                newHead = newNode;
            }
        }
        for (Map.Entry<Node, Node> entry : map.entrySet()) {
            Node newNode = map.get(entry.getKey());
            newNode.next = map.get(entry.getKey().next);
            newNode.random = map.get(entry.getKey().random);
        }
        return newHead;
    }
}
