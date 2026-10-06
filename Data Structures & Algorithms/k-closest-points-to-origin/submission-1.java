class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Integer[]> heap = new PriorityQueue<>((a, b) -> (a[0] * a[0] + a[1] * a[1]) - (b[0] * b[0] + b[1] * b[1]));
        for (int[] point : points) {
            heap.offer(new Integer[]{point[0], point[1]});
        }
        int[][] result = new int[k][2];
        for (int i = 0; i < k; ++i) {
            Integer[] point = heap.poll();
            result[i][0] = point[0];
            result[i][1] = point[1];
        }
        return result;
    }
}
