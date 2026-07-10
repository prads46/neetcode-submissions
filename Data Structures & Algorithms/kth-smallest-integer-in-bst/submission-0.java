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
    List<Integer> list = new ArrayList();
    public int kthSmallest(TreeNode root, int k) {
        list = helper(root,list);
        Collections.sort(list);
        return list.get(k-1);

    }
    public List<Integer> helper(TreeNode root,List<Integer> list){
        if(root == null){
            return list;
        }
        list.add(root.val);
        helper(root.left,list);
        helper(root.right,list);
        return list;
    }
}
