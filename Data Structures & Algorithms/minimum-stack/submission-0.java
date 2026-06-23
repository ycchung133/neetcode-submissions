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
            newNode.next = head;
            newNode.min = Math.min(head.min, val);
            head = newNode;
        }
        
    }
    
    public void pop() {
        head = head.next;
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
