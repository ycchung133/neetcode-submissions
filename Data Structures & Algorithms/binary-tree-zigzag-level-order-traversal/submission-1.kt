/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {
        if (root == null) return emptyList()

        val result = mutableListOf<List<Int>>()
        val queue = ArrayDeque<TreeNode>()
        queue.addLast(root);
        while (!queue.isEmpty()) {
            val size = queue.size
            val level = mutableListOf<Int>()
            for (i in 0..<size) {
                val node = queue.removeFirst()
                level.add(node.`val`)
                node.left?.let {
                    queue.addLast(it)
                }
                node.right?.let {
                    queue.addLast(it)
                }
            }
            if (result.size % 2 == 1) {
                level.reverse()
            }
            result.add(level)
        }
        return result
    }
}
