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

    public int diameterOfBinaryTree(TreeNode root) {
        return height(root)[1];    
    }

    public int[] height(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        int[] left = height(root.left);
        int[] right = height(root.right);
        int max = Math.max(Math.max(left[1], right[1]), left[0] + right[0]);
        return new int[] {Math.max(left[0], right[0]) + 1, max};
    }
}
