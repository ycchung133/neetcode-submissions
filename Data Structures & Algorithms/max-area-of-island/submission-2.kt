class Solution {
    companion object {
        val DIRECTIONS: Array<IntArray> = arrayOf(intArrayOf(1, 0), intArrayOf(-1, 0), intArrayOf(0, 1), intArrayOf(0, -1))
    }

    fun maxAreaOfIsland(grid: Array<IntArray>): Int {
        var max = 0;
        for (row in grid.indices) {
            for (col in grid[row].indices) {
                if (grid[row][col] == 1) {
                    max = maxOf(max, bfs(grid, row, col))
                }
            }
        }
        return max
    }

    private fun bfs(grid: Array<IntArray>, startRow: Int, startCol: Int): Int {
        var count = 1
        val queue = ArrayDeque<IntArray>()
        grid[startRow][startCol] = 0
        queue.addLast(intArrayOf(startRow, startCol))
        while (!queue.isEmpty()) {
            val cell = queue.removeFirst()
            for (direction in DIRECTIONS) {
                val row = cell[0] + direction[0]
                val col = cell[1] + direction[1]
                if (row !in grid.indices || col !in grid[0].indices) {
                    continue
                }
                if (grid[row][col] == 1) {
                    grid[row][col] = 0
                    queue.addLast(intArrayOf(row, col))
                    count++
                }
            }
        }
        return count
    } 
}
