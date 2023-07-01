//{ Driver Code Starts
//Initial Template for Java

//Contributed by Sudarshan Sharma
import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class GfG {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
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
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    static void printInorder(Node root)
    {
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t-- > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
                Solution obj = new Solution();
                ArrayList <Integer> res = obj.verticalOrder(root);
                for (Integer num : res) System.out.print(num + " "); 
                System.out.println();
    	        
	        }
	}
}

// } Driver Code Ends


//User function Template for Java

class Pair {
    int hd; // horizontal distance
    Node node;

    Pair(int hd, Node node) {
        this.hd = hd;
        this.node = node;
    }
}

class Solution {
    // Function to find the vertical order traversal of Binary Tree.
    static ArrayList<Integer> verticalOrder(Node root) {
        // add your code here
        ArrayList<Integer> ans = new ArrayList<>();
        
        // Check if the root is null, return empty list.
        if (root == null) {
            return ans;
        }
        
        // Queue to perform level order traversal of the tree.
        Queue<Pair> q = new ArrayDeque<>();
        
        // Map to store the horizontal distance and list of node values at that distance.
        // We are using TreeMap to automatically sort the map entries by keys.
        Map<Integer, ArrayList<Integer>> map = new TreeMap<>();
        
        // Adding the root node with horizontal distance 0 to the queue.
        q.add(new Pair(0, root));
        
        while (q.size() > 0) {
            Pair curr = q.poll();
            
            // Check if the current horizontal distance exists in the map.
            // If it exists, append the current node value to the existing list.
            // If it doesn't exist, create a new list and add the current node value to it.
            if (map.containsKey(curr.hd)) {
                map.get(curr.hd).add(curr.node.data);
            } else {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(curr.node.data);
                map.put(curr.hd, temp);
            }
            
            // Adding the left child to the queue with horizontal distance reduced by 1.
            if (curr.node.left != null) {
                q.add(new Pair(curr.hd - 1, curr.node.left));
            }
            
            // Adding the right child to the queue with horizontal distance increased by 1.
            if (curr.node.right != null) {
                q.add(new Pair(curr.hd + 1, curr.node.right));
            }
        }
        
        // Adding the values from the map to the answer list in sorted order.
        for (Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()) {
            ans.addAll(entry.getValue());
        }
        
        return ans;
    }
}
