class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int n : stones) {
            heap.offer(n);
        }
        while (heap.size() > 1) {
            int x = heap.poll();
            int y = heap.poll();
            if (x != y) {
                heap.offer(Math.abs(y - x));
            }
        }
        return heap.isEmpty() ? 0 : heap.poll();
    }
}
