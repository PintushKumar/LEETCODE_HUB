/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }
        int curr = root.val;
        int n1 = p.val;
        int n2 = q.val;
        if(curr<n1 && curr <n2){
            return lowestCommonAncestor(root.right , p , q);
        }
        else if(curr>n1 && curr >n2){
            return lowestCommonAncestor(root.left , p , q);
        }
        return root;
    }
}