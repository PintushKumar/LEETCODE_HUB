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
    TreeNode tempRootNode = new TreeNode(0);
    public void helper(TreeNode node){
        if(node == null){
            return;
        }
        helper(node.left);
        node.left = null;
        tempRootNode.right = node;
        tempRootNode = node;
        helper(node.right);
    }
    public TreeNode increasingBST(TreeNode root) {
        TreeNode finalRoot = tempRootNode;
        helper(root);
        return finalRoot.right;
    }
}