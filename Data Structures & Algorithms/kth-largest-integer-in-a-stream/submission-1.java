class KthLargest {
    private int k;
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int n : nums) {
            minHeap.offer(n);
        }
    }
    
    public int add(int val) {
        minHeap.offer(val);
        while (minHeap.size() > k) {
            minHeap.poll();
        }
        return minHeap.peek();
    }
}
