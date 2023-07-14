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


// class Solution {
//     class Pair{
//         boolean isBst;
//         int maxi ;
//         int mini;
//         Pair(boolean isBst , int maxi , int mini){
//             this.isBst = isBst;
//             this.maxi = maxi;
//             this.mini = mini;
//         }
//     }
//     Pair validate (TreeNode node){
//         if(node == null){
//             return new Pair(true ,Integer.MIN_VALUE , Integer.MAX_VALUE);
//         }
//         Pair leftSubTree = validate(node.left);
//         Pair rightSubTree = validate(node.right);
//         boolean amIBst = leftSubTree.isBst && rightSubTree.isBst && node.val > leftSubTree.maxi && node.val < rightSubTree.mini;
//         if(!amIBst){
//             return new Pair(false , 0 ,0);
//         }
//         int maxi = Math.max(node.val , rightSubTree.maxi);
//         int mini = Math.min(node.val , leftSubTree.mini);
//         return new Pair(true , maxi , mini);
//     }
//     public boolean isValidBST(TreeNode root) {
//         if(root == null){
//             return true;
//         }
//         if(root.left == null && root.right == null){
//             return true;
//         }
//         if(root.left != null || root.right == null){
//             if(root.left.val <root.val){
//                 return true;
//             }else{
//                 return false;
//             }
//         }
//         if(root.left == null || root.right != null){
//             if(root.right.val > root.val){
//                 return true;
//             }else{
//                 return false;
//             }
//         }
//         if(root.left != null && root.right != null){
//             Pair ans = validate(root);
//             return ans.isBst;
//         }
//         return true;
//     }
// }

class Solution {
   public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    public boolean isValidBST(TreeNode root, long minVal, long maxVal) {
        if (root == null) return true;
        if (root.val >= maxVal || root.val <= minVal) return false;
        return isValidBST(root.left, minVal, root.val) && isValidBST(root.right, root.val, maxVal);
    }
}
