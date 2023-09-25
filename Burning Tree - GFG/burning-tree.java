//{ Driver Code Starts
//Initial Template for Java


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
}

class GfG {

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
			if (i >= ip.length)
				break;

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
		if (root == null)
			return;

		printInorder(root.left);
		System.out.print(root.data + " ");

		printInorder(root.right);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		while (t > 0) {
			String s = br.readLine();
			int target = Integer.parseInt(br.readLine());
			Node root = buildTree(s);

			Solution g = new Solution();
			System.out.println(g.minTime(root, target));
			t--;

		}
	}
}



// } Driver Code Ends


//User function Template for Java

 /*class Node {
    	int data;
    	Node left;
    	Node right;
    
    	Node(int data) {
    		this.data = data;
    		left = null;
    		right = null;
    	}
    }*/

class Solution
{
    // Helper function to traverse the tree and create a map of child to parent nodes.
    public static void traverse(Node root, HashMap<Node, Node> map) {
        if (root == null) {
            return;
        }
        
        if (root.left != null) {
            map.put(root.left, root);  // Store the parent of the left child in the map.
        }
        
        if (root.right != null) {
            map.put(root.right, root);  // Store the parent of the right child in the map.
        }
        
        traverse(root.left, map);  // Recursively traverse the left subtree.
        traverse(root.right, map); // Recursively traverse the right subtree.
    }

    // Helper function to find a node with a specific target value.
    public static Node find(Node root, int target) {
        if (root == null) {
            return null;
        }
        if (root.data == target) {
            return root;  // If the current node has the target value, return it.
        }
        
        Node fiL = find(root.left, target);  // Recursively search for the target in the left subtree.
        if (fiL != null) {
            return fiL;
        }
        
        Node fiR = find(root.right, target);  // Recursively search for the target in the right subtree.
        if (fiR != null) {
            return fiR;
        }
        return null;  // If the target is not found in the current subtree, return null.
    }

    public static int minTime(Node root, int target) 
    {
        // Your code goes here
        
        // Step 1: Store child with parent in a HashMap (map).
        // Step 2: Find the target Node (source).
        // Step 3: Check if the target node exists or not.
        // Step 4: Create a HashSet (visited) to keep track of visited nodes.
        // Step 5: Create a Queue of Node type.
        // Step 6: Apply BFS to calculate the minimum time.
        
        HashMap<Node, Node> map = new HashMap<>();
        traverse(root, map);  // Step 1: Create a map of child to parent nodes.
        Node source = find(root, target);  // Step 2: Find the target Node.
        
        if (source == null) {
            return 0;  // Step 3: If the target node doesn't exist, return 0.
        }
        
        HashSet<Node> visited = new HashSet();  // Step 4: Create a set to track visited nodes.
        Queue<Node> q = new ArrayDeque<>();  // Step 5: Create a Queue for BFS.
        
        q.add(source);
        visited.add(source);
        
        int level = 0;
        int time = 0;
        
        while (q.size() > 0) {
            int size = q.size();
            while (size-- > 0) {
                Node rnode = q.remove();
                
                // Check left child.
                if (rnode.left != null && !visited.contains(rnode.left)) {
                    q.add(rnode.left);
                    visited.add(rnode.left);
                }
                
                // Check right child.
                if (rnode.right != null && !visited.contains(rnode.right)) {
                    q.add(rnode.right);
                    visited.add(rnode.right);
                }
                
                // Check the parent node using the map.
                if (map.containsKey(rnode) && !visited.contains(map.get(rnode))) {
                    q.add(map.get(rnode));
                    visited.add(map.get(rnode));
                }
            }
            level++;
        }
        
        if (level == 0) {
            return 0;
        }
        
        time = level - 1;  // Calculate time based on the BFS level.
        
        return time;
    }
}
