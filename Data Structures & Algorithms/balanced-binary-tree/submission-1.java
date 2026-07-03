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
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        int heightLeft = height(root.left);
        int heightRight = height(root.right);

        boolean leftBalanced = isBalanced(root.left);
        boolean rightBalanced = isBalanced(root.right);

        return leftBalanced
&& rightBalanced && Math.abs(heightLeft - heightRight) < 2;
        
    }
    public int height(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftDepth = height(root.left);
        int rightDepth = height(root.right);
        return Math.max(leftDepth, rightDepth)+1;
    }
}
