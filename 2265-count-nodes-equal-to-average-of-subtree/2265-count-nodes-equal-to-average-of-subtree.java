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

// ************************************************* brute force solution

// class Solution {
//     int result; // A variable to store the count of nodes meeting the condition

//     // Helper function to find the sum of values in the subtree rooted at 'root' and count the nodes
//     int findSum(TreeNode root, int count[]) {
//         if (root == null) {
//             return 0;
//         }

//         count[0]++; // Increment the count of nodes

//         int leftSum = findSum(root.left, count);  // Recursively find the sum in the left subtree
//         int rightSum = findSum(root.right, count); // Recursively find the sum in the right subtree

//         return leftSum + rightSum + root.val; // Return the total sum in the subtree
//     }

//     // Main recursive function to traverse the tree and check for nodes meeting the condition
//     void solve(TreeNode root) {
//         if (root == null) {
//             return;
//         }
//         int count[] = {0}; // An array to store the count of nodes
//         int sum = findSum(root, count); // Find the sum of values in the subtree
//         int avg = sum / count[0]; // Calculate the average of the subtree

//         // If the average equals the value of the current node, increment the result
//         if (avg == root.val) {
//             result++;
//         }

//         // Recursively process the left and right subtrees
//         solve(root.left);
//         solve(root.right);
//     }

//     // Public method to calculate the number of nodes meeting the condition
//     public int averageOfSubtree(TreeNode root) {
//         result = 0; // Initialize the result variable
//         solve(root); // Start the recursive traversal
//         return result; // Return the final count of nodes meeting the condition
//     }
// }

// ***************************Second Approach 

// Define a class to store a pair of values: sum and count of nodes
class Pair {
    int sum;
    int countNode;

    Pair(int sum, int countNode) {
        this.sum = sum;
        this.countNode = countNode;
    }
}

class Solution {
    int result; // A variable to store the count of nodes meeting the condition

    // Main recursive function to traverse the tree and check for nodes meeting the condition
    Pair solve(TreeNode root) {
        if (root == null) {
            return new Pair(0, 0);
        }
        Pair leftSubTree = solve(root.left);  // Recursively process the left subtree
        Pair rightSubTree = solve(root.right); // Recursively process the right subtree

        int totalSum = leftSubTree.sum + rightSubTree.sum + root.val; // Calculate the total sum in the subtree
        int totalCountNode = leftSubTree.countNode + rightSubTree.countNode + 1; // Calculate the total count of nodes

        int avg = totalSum / totalCountNode; // Calculate the average of the subtree

        // If the average equals the value of the current node, increment the result
        if (avg == root.val) {
            result++;
        }

        return new Pair(totalSum, totalCountNode);
    }

    // Public method to calculate the number of nodes meeting the condition
    public int averageOfSubtree(TreeNode root) {
        result = 0; // Initialize the result variable
        solve(root); // Start the recursive traversal
        return result; // Return the final count of nodes meeting the condition
    }
}