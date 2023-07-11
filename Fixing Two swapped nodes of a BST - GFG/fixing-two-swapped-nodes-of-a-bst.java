//{ Driver Code Starts
// Initial Template for Java

import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
} class pair {
    int first;
    int second;
    pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
} class GfG {

    static Node buildTree(String str) {

        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }

        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        // Starting from the second element

        int i = 1;
        while (queue.size() > 0 && i < ip.length) {

            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= ip.length) break;

            currVal = ip[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }
    static void printInorder(Node root) {
        if (root == null) return;

        printInorder(root.left);
        System.out.print(root.data + " ");

        printInorder(root.right);
    }

    public static boolean isBST(Node n, int lower, int upper) {
        if (n == null) return true;
        if (n.data <= lower || n.data >= upper) return false;
        return (isBST(n.left, lower, n.data) && isBST(n.right, n.data, upper));
    }

    public static boolean compare(Node a, Node b, ArrayList<pair> mismatch) {
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;

        if (a.data != b.data) {
            pair temp = new pair(a.data, b.data);
            mismatch.add(temp);
        }

        return (compare(a.left, b.left, mismatch) &&
                compare(a.right, b.right, mismatch));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String s = br.readLine();
            Node root = buildTree(s);
            Node duplicate = buildTree(s);

            Solution g = new Solution();

            root = g.correctBST(root);

            // check 1: is tree now a BST
            if (isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE) == false) {
                out.println(0);
                continue;
            }

            // check 2: comparing with duplicate tree

            ArrayList<pair> mismatch = new ArrayList<pair>();
            // an arraylist to store data of mismatching nodes

            if (compare(root, duplicate, mismatch) == false) {
                // false output from this function indicates change in structure
                // of tree
                out.println(0);
                continue;
            }

            // finally, analysing the mismatching nodes
            if (mismatch.size() != 2 ||
                mismatch.get(0).first != mismatch.get(1).second ||
                mismatch.get(0).second != mismatch.get(1).first)
                out.println(0);
            else
                out.println(1);
        }
        out.close();
    }
}

// } Driver Code Ends


// User function Template for Java


/*
    class Node {
        int data;
        Node left;
        Node right;
        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }
*/

class Solution {
    public class Pair {
        Node node;
        int state;
        
        Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }
    
    public Node getNextInorder(Stack<Pair> st) {
        // Traverses the BST in in-order and returns the next node to visit
        // If state == 1, it visits the left side of the node
        // If state == 2, it visits the right side of the node
        // If state == 3, it removes itself from the stack
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
    
    public Node correctBST(Node root) {
        // Fixes the BST by swapping back the two wrong nodes without changing the structure
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(root, 1));
        
        Node curr = getNextInorder(st); // Gets the first node of in-order traversal
        Node prev = null;
        Node a = null, b = null;
        
        while (curr != null) {
            if (prev == null) {
                prev = curr; // Updates the prev to the current node
                curr = getNextInorder(st); // Advances to the next node in in-order traversal
            } else if (prev.data > curr.data) {
                // This is a potential pair where the nodes are not sorted
                // Indicates a wrong node in the BST
                
                if (a == null) {
                    // First wrong node is found
                    a = prev;
                }
                b = curr; // Second wrong node is found
                prev = curr; // Updates the prev to the current node
                curr = getNextInorder(st); // Advances to the next node in in-order traversal
            } else {
                prev = curr; // Updates the prev to the current node
                curr = getNextInorder(st); // Advances to the next node in in-order traversal
            }
        }
        
        // Swaps the correct values between the nodes
        int temp = a.data;
        a.data = b.data;
        b.data = temp;
        
        // Returns the corrected BST
        return root;
    }
}

