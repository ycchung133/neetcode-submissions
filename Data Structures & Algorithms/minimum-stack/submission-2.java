class MinStack {
    Node head = null;

    public MinStack() {
        
    }
    
    public void push(int val) {
        if (head == null) {
            head = new Node();
            head.value = val;
            head.min = val;
        } else {
            Node newNode = new Node();
            newNode.value = val;
            newNode.min = Math.min(head.min, val);
            newNode.next = head;
            head = newNode;
        }
    }
    
    public void pop() {
        if (head != null) {
            head = head.next;
        }
    }
    
    public int top() {
        return head.value;
    }
    
    public int getMin() {
        return head.min;
    }

    class Node {
        int value;
        int min;
        Node next;
    }
}
