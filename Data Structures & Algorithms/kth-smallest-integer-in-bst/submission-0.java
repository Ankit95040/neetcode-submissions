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
    public int kthSmallest(TreeNode root, int k) {
        if(root==null){
            return 0;
        }
       List<Integer>list=new ArrayList<>();
       helper(list,root);
       return list.get(k-1);
        
    }
    public void helper(List<Integer> list,TreeNode node){
        if(node==null){
            return;
        }
        helper(list,node.left);
        list.add(node.val);
        helper(list,node.right);

    }
}
