//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java

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
  
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
    	    	Solution g = new Solution();
                ArrayList<Integer> res = g.inOrder(root);
                for (int i = 0; i < res.size (); i++)
                    System.out.print (res.get (i) + " ");
                System.out.print("\n");
                t--;
        }
    }
}

// } Driver Code Ends


//User function Template for Java

/* A Binary Tree node 

class Node {
    int data;
    Node left, right;
   Node(int item)    {
        data = item;
        left = right = null;
    }
} */
class Solution {
    // Return a list containing the inorder traversal of the given tree
    
    
// ****************** this class created by me *****************************************


// ***************** if callNUm ==0 call left Side of Node **********************
// ***************** if callNUm ==1 call right Side of Node **********************
// ***************** if callNUm ==2 remove Yourself means node  **********************
    class Pair {
        Node node;
        int callNum;

        Pair(Node node, int callNum) {
            this.node = node;
            this.callNum = callNum;
        }
    }
//*******************************************************************************
    ArrayList<Integer> inOrder(Node root) {
        // Create an ArrayList to store the inorder traversal
        ArrayList<Integer> list = new ArrayList<>();

        // If the root is null, return the empty list
        if (root == null) {
            return list;
        }

        // Create a stack to simulate the function call stack
        Stack<Pair> callStack = new Stack<>();

        // Push the root node onto the stack with callNum 0
        callStack.push(new Pair(root, 0));

        // Perform iterative inorder traversal
        while (callStack.size() > 0) {
            Pair rpair = callStack.peek();
            if (rpair.callNum == 0) {
                // If callNum is 0, it means the left subtree of the node is not yet visited
                rpair.callNum = 1;
                if (rpair.node.left != null) {
                    // Push the left child onto the stack with callNum 0
                    callStack.push(new Pair(rpair.node.left, 0));
                }
            } else if (rpair.callNum == 1) {
                // If callNum is 1, it means the left subtree is visited, so add the node to the list
                list.add(rpair.node.data);
                rpair.callNum = 2;
                if (rpair.node.right != null) {
                    // Push the right child onto the stack with callNum 0
                    callStack.push(new Pair(rpair.node.right, 0));
                }
            } else {
                // If callNum is 2, it means both subtrees are visited, so pop the node from the stack
                callStack.pop();
            }
        }

        // Return the inorder traversal list
        return list;
    }
}
