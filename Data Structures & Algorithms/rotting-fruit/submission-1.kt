class Solution {
    companion object {
        val DIRECTIONS = arrayOf(intArrayOf(1, 0), intArrayOf(-1, 0), intArrayOf(0, 1), intArrayOf(0, -1))
    }

    fun orangesRotting(grid: Array<IntArray>): Int {
        var fresh = 0
        val queue = ArrayDeque<IntArray>()
        for (row in grid.indices) {
            for (col in grid[row].indices) {
                if (grid[row][col] == 2) {
                    queue.addLast(intArrayOf(row, col))
                } else if (grid[row][col] == 1) {
                    fresh++
                }
            }
        }

        var steps = 0
        while (!queue.isEmpty() && fresh > 0) {
            val size = queue.size
            repeat (size) {
                val cell = queue.removeFirst()
                for (direction in DIRECTIONS) {
                    val row = cell[0] + direction[0]
                    val col = cell[1] + direction[1]
                    if (row !in grid.indices || col !in grid[0].indices) {
                        continue
                    }
                    if (grid[row][col] == 1) {
                        grid[row][col] = 2
                        fresh--
                        queue.addLast(intArrayOf(row, col))
                    }
                }
            }
            steps++
        }
        return if (fresh == 0) steps else -1
    }
}
