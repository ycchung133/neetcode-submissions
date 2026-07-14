class Solution {
    
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> queue = new ArrayDeque<>();
        for (int r = 0; r < grid.length; ++r) {
            for (int c = 0; c < grid[0].length; ++c) {
                if (grid[r][c] == 0) {
                    queue.offer(new int[]{r, c});
                }
            }
        }
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            for (int[] d : dirs) {
                int r = cell[0] + d[0];
                int c = cell[1] + d[1];
                if (r < 0 || r >= grid.length) {
                    continue;
                }
                if (c < 0 || c >= grid[0].length) {
                    continue;
                }
                if (grid[r][c] != Integer.MAX_VALUE) {
                    continue;
                }
                grid[r][c] = grid[cell[0]][cell[1]] + 1;
                queue.offer(new int[]{r, c});
            }
        }
    }
}
