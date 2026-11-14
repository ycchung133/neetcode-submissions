/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        if (root == null) {
            return result;
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; ++i) {
                TreeNode cell = queue.poll();
                if (cell.left != null) {
                    queue.offer(cell.left);
                }
                if (cell.right != null) {
                    queue.offer(cell.right);
                }
                level.add(cell.val);
            }
            if (result.size() % 2 == 1) {
                Collections.reverse(level);
            }
            result.add(level);
        }
        return result;
    }
}