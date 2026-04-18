class Solution {
    int ans = 0;

    public boolean isBalanced(TreeNode root) {
        helper(root);

        if (ans > 1) {
            return false;
        }

        return true;
    }

    public int helper(TreeNode node) {
        if (node == null) {
            return 1;
        }

        int left = 1+helper(node.left);
        int right = 1+helper(node.right);

        ans = Math.max(ans, Math.abs(right - left));

        return  Math.max(left, right);
    }
}