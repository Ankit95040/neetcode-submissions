class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        
        if (root == null) {
            return false;
        }

        if (check(root, subRoot)) {
            return true;
        }

        return isSubtree(root.left, subRoot) 
            || isSubtree(root.right, subRoot);
    }

    public boolean check(TreeNode node1, TreeNode node2) {
        
        if (node1 == null && node2 == null) {
            return true;
        }

        if (node1 == null || node2 == null) {
            return false;
        }

        if (node1.val != node2.val) {
            return false;
        }

        return check(node1.left, node2.left)
            && check(node1.right, node2.right);
    }
}