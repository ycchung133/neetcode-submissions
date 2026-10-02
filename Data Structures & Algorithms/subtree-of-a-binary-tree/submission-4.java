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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        } else if ((root != null && subRoot == null) || root == null && subRoot != null) {
            return false;
        } else if (isSameTree(root, subRoot)) {
            return true;
        } else if (isSameTree(root.left, subRoot) || isSubtree(root.left, subRoot)) {
            return true;
        } else if (isSameTree(root.right, subRoot) || isSubtree(root.right, subRoot)) {
            return true;
        }
        return false;
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if ((p == null && q != null) || (p != null && q == null)) {
            return false;
        } else {
            boolean left = isSameTree(p.left, q.left);
            boolean right = isSameTree(p.right, q.right);
            return p.val == q.val && left && right;
        }
    }
}
