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
    int count=0;
    public int goodNodes(TreeNode root) {
        if(root==null){
            return 0;
        }
        int ans=-(int)1e9;
        
        helper(root ,ans);
        return count;
        
    }
    public void helper(TreeNode node,int max){
        if(node==null){
            return;
        }
        if(node.val>=max){
            count++;
        }
        helper(node.left,Math.max(node.val,max));
        helper(node.right,Math.max(node.val,max));
    }
}
