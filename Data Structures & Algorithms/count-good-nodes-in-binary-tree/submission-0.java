class Solution {
    public int goodNodes(TreeNode root) {
        return helper(root, root.val);
    }

    public int helper(TreeNode root, int max) {
        if (root == null) {
            return 0;
        }

        int count = 0;

        if (root.val >= max) {
            count = 1;
        }

        max = Math.max(max, root.val);

        int left = helper(root.left, max);
        int right = helper(root.right, max);

        return count + left + right;
    }
}