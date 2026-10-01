class LRUCache {

    int capacity = 0;
    HashMap<Integer, Node> map = new HashMap<>();
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            update(key);
            return map.get(key).val;
        }

        return -1;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.get(key).val = value;
            update(key);
        } else {
            Node newNode = new Node();
            newNode.key = key;
            newNode.val = value;
            map.put(key, newNode);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
            }
        }
        if (map.size() > capacity) {
            Node newHead = head.next;
            newHead.prev = null;
            map.remove(head.key);
            head = newHead;
        }
    }

    private void update(int key) {
        Node nodeToUpdate = map.get(key);
        if (nodeToUpdate == tail) {
            return;
        }
        if (nodeToUpdate.prev != null) {
            nodeToUpdate.prev.next = nodeToUpdate.next;
        }
        if (nodeToUpdate.next != null) {
            nodeToUpdate.next.prev = nodeToUpdate.prev;
        }
        if (nodeToUpdate == head) {        
            head = nodeToUpdate.next;  
        }
        tail.next = nodeToUpdate;
        nodeToUpdate.prev = tail;
        nodeToUpdate.next = null;
        tail = nodeToUpdate;
    }

    public static class Node {
        int key;
        int val;
        Node next;
        Node prev;
    }
}
