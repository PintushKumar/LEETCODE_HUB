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
    public void inOrder(TreeNode root , int prev[]){
        if(root == null){
            return;
        }
        inOrder(root.left , prev);
        if(prev[1] != -1){
            prev[0]= Math.min(prev[0] , Math.abs(prev[1]-root.val));
        }
        prev[1]=root.val;
        inOrder(root.right , prev);
    }
    public int getMinimumDifference(TreeNode root) {
        int minDif [] = new int[2];
        minDif[0]=Integer.MAX_VALUE;
        minDif[1]=-1;
        inOrder(root , minDif);
        return minDif[0];
    }
}