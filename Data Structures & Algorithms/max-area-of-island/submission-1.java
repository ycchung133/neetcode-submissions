class Solution {
    private static final int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for (int row = 0; row < grid.length; ++row) {
            for (int col = 0; col < grid[0].length; ++col) {
                if (grid[row][col] == 1) {
                    max = Math.max(max, bfs(grid, row, col));
                }
            }
        }
        return max;
    }

    public int bfs(int[][] grid, int startRow, int startCol) {
        int count = 1;
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        grid[startRow][startCol] = 0;
        queue.offer(new int[]{startRow, startCol});
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            for (int[] direction : DIRECTIONS) {
                int row = cell[0] + direction[0];
                int col = cell[1] + direction[1];
                if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
                    continue;
                }
                if (grid[row][col] == 1) {
                    count++;
                    grid[row][col] = 0;
                    queue.offer(new int[]{row, col});
                }
            }
        }
        return count;
    }
}
