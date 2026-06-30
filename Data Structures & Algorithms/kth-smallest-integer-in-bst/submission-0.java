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
    ArrayDeque<Integer> queue = new ArrayDeque<>();
    
    public int kthSmallest(TreeNode root, int k) {
        inOrder(root);
        for (int i = 0; i < k - 1; ++i) {
            queue.poll();
        }
        return queue.poll();
    }

    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        inOrder(root.left);
        queue.offer(root.val);
        inOrder(root.right);
    }
}
