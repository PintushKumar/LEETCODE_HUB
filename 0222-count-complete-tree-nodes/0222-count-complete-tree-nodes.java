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
    public int dfs(TreeNode root){
        if(root ==  null){
            return 0;
        }
        int count =1;
        count+=dfs(root.left);
        count+=dfs(root.right);
        return count;
    }
    public int countNodes(TreeNode root) {
        return dfs(root);
    }
}