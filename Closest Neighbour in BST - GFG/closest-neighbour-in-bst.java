//{ Driver Code Starts
//Initial Template for Java

import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int key;
    Node left;
    Node right;
    Node(int x){
        this.key = x;
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
	            int N=Integer.parseInt(br.readLine());
    	    	Node root = buildTree(s);
        	    Tree g = new Tree();
			    System.out.println(g.findMaxForN(root,N));
                t--;
            
        }
    }
  
}


// } Driver Code Ends


//User function Template for Java

/*class Node
{
    int key;
    Node left, right;
    
    Node(int x)
    {
        key = x;
        left = right = null;
    }
    
}*/
class Tree
{
    public static void helper(Node root ,int val , int[]ans){
        if(root == null){
            return;
        }
        
        if(root.key<=val){
            ans[0]=root.key;
            helper(root.right , val , ans);
        }else{
            helper(root.left , val , ans);
        }
        
    }
    
    public static int findMaxForN(Node node, int val)
    {
    //Add your code here.
        Node res = null;
        if(node == null) return 0;
        while(node != null){
            if(node.key == val) return node.key;
            else if(node.key <= val){
                res = node;
                node = node.right;
            }
            else{
                node = node.left;
            }
        }
        return res.key;
        
        // int ans[]={0};
        // helper(node ,val , ans);
        // return ans[0];
    }
}