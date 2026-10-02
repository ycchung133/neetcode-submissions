class LRUCache {

    int capacity = 0;
    Node head;
    Node tail;
    private HashMap<Integer, Node> map = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            update(key);
            return map.get(key).value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.get(key).value = value;
            update(key);
            return;
        }

        Node newNode = new Node();
        newNode.key = key;
        newNode.value = value;
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        map.put(key, newNode);
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
        
        if (nodeToUpdate == head) {
            Node newHead = head.next;
            newHead.prev = null;
            head = newHead;
        }
        if (nodeToUpdate.next != null) {
            nodeToUpdate.next.prev = nodeToUpdate.prev;
        }
        if (nodeToUpdate.prev != null) {
            nodeToUpdate.prev.next = nodeToUpdate.next;
        }

        tail.next = nodeToUpdate;
        nodeToUpdate.prev = tail;
        nodeToUpdate.next = null;
        tail = nodeToUpdate;
    }

    private static class Node {
        int key;
        int value;
        Node prev;
        Node next;
    }
}
