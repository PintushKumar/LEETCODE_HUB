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

    class Pair {
        TreeNode node;
        boolean isLeft; // New variable to track if it's a left child

        Pair(TreeNode node, boolean isLeft) {
            this.node = node;
            this.isLeft = isLeft;
        }
    }

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Stack<Pair> st = new Stack<>();
        st.push(new Pair(root, false));
        int sum = 0;

        while (!st.isEmpty()) {
            Pair top = st.pop();

            // Check if it's a leaf node and a left child
            if (top.node.left == null && top.node.right == null && top.isLeft) {
                sum += top.node.val;
            }

            if (top.node.right != null) {
                st.push(new Pair(top.node.right, false));
            }
            if (top.node.left != null) {
                st.push(new Pair(top.node.left, true));
            }
        }
        return sum;
    }
}
