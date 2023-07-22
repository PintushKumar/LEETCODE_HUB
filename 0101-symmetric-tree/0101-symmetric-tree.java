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
    // Recursive function to check if a binary tree is symmetric
    public boolean helperIsSymmetric(TreeNode Left, TreeNode Right) {
        // Base case: If both nodes are null, they are symmetric.
        if (Left == null && Right == null) {
            return true;
        }
        
        // If one of the nodes is null and the other is not, they are not symmetric.
        if (Left == null || Right == null) {
            return false;
        }
        
        // If the values of the left and right nodes are different, they are not symmetric.
        if (Left.val != Right.val) {
            return false;
        }
        
        // Check if the left subtree of Left is symmetric to the right subtree of Right,
        // and if the right subtree of Left is symmetric to the left subtree of Right.
        return (helperIsSymmetric(Left.left, Right.right) && helperIsSymmetric(Left.right, Right.left));
    }
    
    // Function to check if the given binary tree is symmetric
    public boolean isSymmetric(TreeNode root) {
        // If the root is null or the tree is empty, it is considered symmetric.
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }
        
        // Call the helper function to check if the left and right subtrees of the root are symmetric.
        return helperIsSymmetric(root.left, root.right);
    }
}
