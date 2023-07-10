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
    // Helper method to get the minimum value in the tree rooted at `root`
    public static int getMinimumValue(TreeNode root) {
        // Traverse to the leftmost node to find the minimum value
        TreeNode temp = root;
        while (temp.left != null) {
            temp = temp.left;
        }
        // Return the minimum value found
        return temp.val;
    }

    // Method to delete a node with value `key` from the tree rooted at `root`
    public TreeNode deleteNode(TreeNode root, int key) {
        // Base case: If the tree is empty, return null
        if (root == null) {
            return null;
        }

        // If the value of the current node matches the key
        if (root.val == key) {
            // Case 1: Deleting a leaf node
            if (root.left == null && root.right == null) {
                return null;
            }
            // Case 2: Deleting a node with only a left child
            else if (root.left != null && root.right == null) {
                return root.left;
            }
            // Case 3: Deleting a node with only a right child
            else if (root.left == null && root.right != null) {
                return root.right;
            }
            // Case 4: Deleting a node with both left and right children
            else {
                // Find the minimum value in the right subtree
                int minVal = getMinimumValue(root.right);
                // Replace the value of the current node with the minimum value
                root.val = minVal;
                // Recursively delete the node with the minimum value from the right subtree
                root.right = deleteNode(root.right, minVal);
            }
        }
        // If the key is greater than the current node's value, go to the right subtree
        else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        }
        // If the key is less than the current node's value, go to the left subtree
        else {
            root.left = deleteNode(root.left, key);
        }

        // Return the modified tree after deletion
        return root;
    }
}
