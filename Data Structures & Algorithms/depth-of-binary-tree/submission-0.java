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
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        return helper(root);
    }
    public int helper(TreeNode node){
        if(node.left==null && node.right==null){
            return 1;
        }
        int left=-(int)1e9;
        if(node.left!=null){
        left=1+helper(node.left);
        }
        int right=-(int)1e9;
        if(node.right!=null){
         right=1+helper(node.right);
        }

        return Math.max(left,right);
    }
}
