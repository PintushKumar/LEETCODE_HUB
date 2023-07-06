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

//*************  Recursive Solution   TC O(N) SC O(N)  ************************* */
    TreeNode prev = null;
    public void flatten(TreeNode root) {
        if(root==null){
            return;
        }
        flatten(root.right);
        flatten(root.left);
        root.right=prev;
        root.left = null;
        prev = root;
    }

// ************* Iterative Solution TC O(N) SC O(N) ********************

//    public void flatten(TreeNode root) {
//         if (root == null) {
//             return;
//         }
        
//         Stack<TreeNode> stack = new Stack<>();
//         stack.push(root);
        
//         while (!stack.isEmpty()) {
//             TreeNode current = stack.pop();
            
//             if (current.right != null) {
//                 stack.push(current.right);
//             }
            
//             if (current.left != null) {
//                 stack.push(current.left);
//             }
            
//             if (!stack.isEmpty()) {
//                 current.right = stack.peek();
//             }
            
//             current.left = null;
//         }
//     }

// ***************** Morce Traversal TC O(N) SC O(1) ***********************
//    public void flatten(TreeNode root) {
//         TreeNode curr = root;

//         while (curr != null) {
//             if (curr.left != null) {
//                 TreeNode prev = curr.left;

//                 while (prev.right != null) {
//                     prev = prev.right;
//                 }

//                 prev.right = curr.right;
//                 curr.right = curr.left;
//                 curr.left = null;
//             }

//             curr = curr.right;
//         }
//     }
}