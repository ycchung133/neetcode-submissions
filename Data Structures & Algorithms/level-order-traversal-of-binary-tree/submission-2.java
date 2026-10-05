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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        if (root == null) {
            return result;
        }
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0;i < size; ++i) {
                TreeNode out = queue.poll();
                level.add(out.val);
                if (out.left != null) {
                    queue.offer(out.left);
                }
                if (out.right != null) {
                    queue.offer(out.right);
                }
            }
            result.add(level);
        }
        return result;
    }
}
