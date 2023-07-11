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
    public class Pair {
        TreeNode node;
        int state;
        
        Pair(TreeNode node, int state) {
            this.node = node;
            this.state = state;
        }
    }
    
    public TreeNode getNextInorder(Stack<Pair> st) {
        // Performs in-order traversal of the BST and returns the next node to visit.
        // If the state is 1, it visits the left side of the node.
        // If the state is 2, it visits the current node.
        // If the state is 3, it removes itself from the stack.
        while (st.size() > 0) {
            Pair top = st.peek();
            if (top.state == 1) {
                // Pre-order traversal: Go to the left side of the node
                top.state++;
                if (top.node.left != null) {
                    st.push(new Pair(top.node.left, 1));
                }
            } else if (top.state == 2) {
                // In-order traversal: Visit the node
                top.state++;
                if (top.node.right != null) {
                    st.push(new Pair(top.node.right, 1));
                }
                return top.node;
            } else {
                // Post-order traversal: Go to the right side of the node
                st.pop();
            }
        }
        return null; // No more nodes to visit
    }
    public void recoverTree(TreeNode root) {
        // Fixes the BST by swapping back the two wrong nodes without changing the structure
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(root, 1));
        
        TreeNode curr = getNextInorder(st); // Gets the first node of the in-order traversal
        TreeNode prev = null;
        TreeNode a = null, b = null;
        
        while (curr != null) {
            if (prev == null) {
                prev = curr; // Updates the prev to the current node
                curr = getNextInorder(st); // Moves to the next node in the in-order traversal
            }
            // This is a potential pair where the nodes are not sorted
            // Indicates a wrong node in the BST
            else if (prev.val > curr.val) {
                if (a == null) {
                    // First wrong node is found
                    a = prev;
                }
                b = curr; // Second wrong node is found
                prev = curr; // Updates the prev to the current node
                curr = getNextInorder(st); // Moves to the next node in the in-order traversal
            } else {
                prev = curr; // Updates the prev to the current node
                curr = getNextInorder(st); // Moves to the next node in the in-order traversal
            }
        }
        
        // Swaps the correct values between the nodes
        int temp = a.val;
        a.val = b.val;
        b.val = temp;
    }
}