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
    public boolean dfs(TreeNode root , HashSet<Integer> set){
        if(root == null){
            return true;
        }
        set.add(root.val);
        if(set.size()>1){
            return false;
        }
        boolean left = dfs(root.left , set);
        boolean right = dfs(root.right , set);
        return left || right;
    }
    public boolean isUnivalTree(TreeNode root) {
        HashSet<Integer> set = new HashSet<>();
        dfs(root , set);
        // if(set.size()==1){
        //     return true;
        // }
        // return false;
        return dfs(root , set);
    }
}