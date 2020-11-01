/**
 * https://leetcode.com/problems/path-sum/
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
    
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        sum -= root.val;
        if(sum == 0 && root.left == null && root.right == null){
            return true;
        }
        if(root.left != null) {
            if (hasPathSum(root.left, sum)) return true;
        }
        if(root.right != null){
            if(hasPathSum(root.right, sum)) return true;
        };
        
        
        return false;
    }
}
