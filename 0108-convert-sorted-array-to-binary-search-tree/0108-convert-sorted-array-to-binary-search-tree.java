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
    public TreeNode constructTree(int[] nums, int l, int r) {
        // Check if the left index is greater than the right index
        if (l > r) {
            // If so, return null since there are no elements to construct the tree
            return null;
        }
        
        // Calculate the middle index
        int midIndx = (l + r) / 2;
        
        // Create a new TreeNode with the value at the middle index
        TreeNode root = new TreeNode(nums[midIndx]);
        
        // Recursively construct the left subtree using the left portion of the array
        root.left = constructTree(nums, l, midIndx - 1);
        
        // Recursively construct the right subtree using the right portion of the array
        root.right = constructTree(nums, midIndx + 1, r);
        
        // Return the root of the constructed binary search tree
        return root;
    }
    
    public TreeNode sortedArrayToBST(int[] nums) {
        // Construct the binary search tree using the entire nums array
        TreeNode root = constructTree(nums, 0, nums.length - 1);
        
        // Return the root of the constructed binary search tree
        return root;
    }
}
