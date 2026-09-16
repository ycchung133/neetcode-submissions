class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int n : stones) {
            minHeap.offer(n);
        }
        while (minHeap.size() > 1) {
            int x = minHeap.poll();
            int y = minHeap.poll();
            if (x != y) {
                minHeap.offer(Math.abs(y - x));
            }
        }
        return minHeap.isEmpty() ? 0 : minHeap.peek();
    }
}
