//{ Driver Code Starts
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int value) {
        data = value;
        left = null;
        right = null;
    }
}

class InorderPostorderToTree {
    public void preOrder(Node root) {
        if (root == null) return;

        System.out.print(root.data + " ");
        preOrder(root.left);

        preOrder(root.right);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        InorderPostorderToTree ip = new InorderPostorderToTree();
        int T = sc.nextInt();
        while (T > 0) {
            int n = sc.nextInt();
            int inorder[] = new int[n];
            int postorder[] = new int[n];
            for (int i = 0; i < n; i++) inorder[i] = sc.nextInt();
            for (int i = 0; i < n; i++) postorder[i] = sc.nextInt();
            GfG g = new GfG();
            Node root = g.buildTree(inorder, postorder, n);
            ip.preOrder(root);
            System.out.println();

            T--;
        }
    }
}

// } Driver Code Ends


/* Tree node structure
class Node
{
    int data;
    Node left;
    Node right;

        Node(int value)
    {
        data = value;
        left = null;
        right = null;
    }
}*/


class GfG
{
    //Function to return a tree created from postorder and inoreder traversals.
    public static int findPosition(int in[], int inorderStart, int inorderEnd, int element) {
        for (int i = inorderStart; i <= inorderEnd; i++) {
            if (in[i] == element) {
                return i;
            }
        }
        return -1; // If the element is not found, return -1
    }

    // Recursive function to construct the binary tree from inorder and preorder arrays
    public static Node solve(int in[], int pre[], int[] preIndex, int inorderStart, int inorderEnd) {
        // Base case: If preIndex is out of range or the inorder indices are invalid, return null
        if ((preIndex[0] < 0) || (inorderStart > inorderEnd)) {
            return null;
        }

        int element = pre[preIndex[0]]; // Get the current element from the preorder array
        Node root = new Node(element); // Create a new node with the current element
        preIndex[0]--; // Move to the next element in the preorder array

        // Find the position of the current element in the inorder array
        int position = findPosition(in, inorderStart, inorderEnd, element);

        // Recursively construct the left and right subtrees
        root.right = solve(in, pre, preIndex,  position + 1 , inorderEnd);
        root.left = solve(in, pre, preIndex, inorderStart, position-1);

        // Return the root of the current subtree
        return root;
    }

    // Main function to build the binary tree from inorder and preorder arrays
    public static Node buildTree(int in[], int pos[], int n) {
        int[] preorderIndex = { 0 }; // Initialize the preorder index as 0
        preorderIndex[0] = n-1;
        Node ans = solve(in, pos, preorderIndex, 0, n - 1); // Call the solve function
        return ans; // Return the root of the constructed binary tree
    }
}
