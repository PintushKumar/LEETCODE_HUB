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
    public TreeNode constructTree(int []nums , int l , int r){
        if(l>r){
            return null;
        }
        int midIndx = (l+r)/2;
        TreeNode root = new TreeNode(nums[midIndx]);
        root.left = constructTree(nums , l , midIndx-1);
        root.right = constructTree(nums ,midIndx+1 , r);
        return root;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = constructTree(nums , 0 , nums.length-1);
        return root;
    }
}