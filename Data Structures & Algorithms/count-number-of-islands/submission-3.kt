class Solution {
    companion object {
        val DIRECTIONS: Array<IntArray> = arrayOf(intArrayOf(1, 0), intArrayOf(-1, 0), intArrayOf(0, 1), intArrayOf(0, -1))
    }

    fun numIslands(grid: Array<CharArray>): Int {
        var count = 0;
        for (row in grid.indices) {
            for (col in grid[row].indices) {
                if (grid[row][col] == '1') {
                    bfs(grid, row, col)
                    count++
                }
            }
        }
        return count
    }

    fun bfs(grid: Array<CharArray>, startRow: Int, startCol: Int) {
        val queue = ArrayDeque<IntArray>()
        grid[startRow][startCol] = '0'
        queue.addLast(intArrayOf(startRow, startCol))
        while (!queue.isEmpty()) {
            val cell = queue.removeFirst()
            for (direction in DIRECTIONS) {
                val row = cell[0] + direction[0]
                val col = cell[1] + direction[1]
                if (row !in grid.indices || col !in grid[row].indices) {
                    continue
                }
                if (grid[row][col] == '1') {
                    grid[row][col] = '0'
                    queue.addLast(intArrayOf(row, col))
                }
            }
        }
    }
}
