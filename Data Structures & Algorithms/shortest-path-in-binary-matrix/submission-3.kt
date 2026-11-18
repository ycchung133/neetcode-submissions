class Solution {
    companion object {
        val DIRECTIONS = arrayOf(intArrayOf(1, 0), intArrayOf(1, 1), intArrayOf(0, 1), intArrayOf(-1, 1), intArrayOf(-1, 0), intArrayOf(-1, -1), intArrayOf(0, -1), intArrayOf(1, -1))
    }

    fun shortestPathBinaryMatrix(grid: Array<IntArray>): Int {
        if (grid[0][0] == 1 || grid[grid.size - 1][grid[0].size - 1] == 1) {
            return -1;
        }

        val queue = ArrayDeque<IntArray>()
        grid[0][0] = 1
        queue.addLast(intArrayOf(0, 0))
        
        var found = false
        var steps = 1
        while (!queue.isEmpty()) {
            val size = queue.size
            repeat (size) {
                val cell = queue.removeFirst()
                if (cell[0] == grid.size - 1 && cell[1] == grid[0].size - 1) {
                    return steps
                }
                for (direction in DIRECTIONS) {
                    val row = direction[0] + cell[0]
                    val col = direction[1] + cell[1]
                    if (row !in grid.indices || col !in grid[0].indices) {
                        continue
                    }
                    if (grid[row][col] == 0) {
                        if (cell[0] == grid.size - 1 && cell[1] == grid[0].size - 1) {
                            found = true
                        }
                        grid[row][col] = 1
                        queue.addLast(intArrayOf(row, col))
                    }
                }
            }
            steps++
        }
        
        return if (found) steps else -1
    }
}
