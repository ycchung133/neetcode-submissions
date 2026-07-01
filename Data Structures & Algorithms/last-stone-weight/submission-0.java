class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int weight : stones) {
            maxHeap.add(weight);
        }

        while (maxHeap.size() > 1) {
            int x = maxHeap.poll();
            int y = maxHeap.poll();
            if (x != y) {
                maxHeap.add(Math.abs(y - x));
            }
        }
        return maxHeap.isEmpty() ? 0 : maxHeap.poll();
    }
}
