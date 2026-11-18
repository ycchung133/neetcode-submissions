class Solution {
    private static final int[][] DIRECTIONS = {{1, 0}, {1, 1}, {0, 1}, {-1, 1}, {-1, 0}, {-1, -1}, {0, -1}, {1, -1}};

    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1 || grid[grid.length - 1][grid[0].length - 1] == 1) {
            return -1;
        }

        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0});

        boolean found = false;
        int steps = 1;
        while (!queue.isEmpty() && !found) {
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                int[] cell = queue.poll();
                if (cell[0] == grid.length - 1
                        && cell[1] == grid[0].length - 1) {
                    return steps;
                }
                for (int[] direction : DIRECTIONS) {
                    int row = cell[0] + direction[0];
                    int col = cell[1] + direction[1];
                    if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) {
                        continue;
                    }
                    if (grid[row][col] == 0) {
                        if (row == grid.length - 1 && col == grid[0].length - 1) {
                            found = true;
                        }
                        grid[row][col] = 1;
                        queue.offer(new int[]{row, col});
                    }
                }
            }
            steps++;
        }

        return found ? steps : -1;
    }
}