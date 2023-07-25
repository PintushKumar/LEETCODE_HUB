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
    // Helper function to calculate the maximum path sum with the given root node and update maxVal[0].
    int maxPathDepthSum(TreeNode root, int maxVal[]) {
        // Base case: If the root is null, return 0 (no contribution to the sum).
        if (root == null) {
            return 0;
        }
        
        // Recursively calculate the maximum path sum on the left subtree,
        // taking the maximum between 0 and the result (to handle negative values).
        int left = Math.max(0, maxPathDepthSum(root.left, maxVal));
        
        // Recursively calculate the maximum path sum on the right subtree,
        // taking the maximum between 0 and the result (to handle negative values).
        int right = Math.max(0, maxPathDepthSum(root.right, maxVal));
        
        // Update maxVal[0] with the maximum between the current maxVal[0],
        // the sum of the current node, left subtree, and right subtree.
        maxVal[0] = Math.max(maxVal[0], left + right + root.val);
        
        // Return the maximum between the sum of the current node and its left subtree,
        // and the sum of the current node and its right subtree.
        return Math.max(left, right) + root.val;
    }
    
    // Function to find the maximum path sum in the binary tree.
    public int maxPathSum(TreeNode root) {
        // Initialize maxVal[0] as the smallest possible integer value.
        int maxVal[] = new int[1];
        maxVal[0] = Integer.MIN_VALUE;
        
        // Call the helper function to calculate the maximum path sum with the given root.
        int ele = maxPathDepthSum(root, maxVal);
        
        // Return the maximum path sum stored in maxVal[0].
        return maxVal[0];
    }
}