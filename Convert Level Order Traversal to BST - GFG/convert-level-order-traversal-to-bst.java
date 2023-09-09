//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left, right;
    
    public Node(int data){
        this.data = data;
        left = right = null;
    }
}

public class Main {
    
	public static void main (String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i=0; i<n; i++){
                arr[i] = sc.nextInt();
            }
            GFG obj = new GFG();
            Node tree = obj.constructBST(arr);
            preorder(tree);
            System.out.println();
        }
	}
	
	 public static void preorder(Node root){
        if(root == null){
            return;
        }
        
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
}


// } Driver Code Ends


//User function Template for Java

class Pair{
    Node parent = null;
    int lb = -(int) 1e9;
    int rb = (int) 1e9;
    Pair(Node parent , int lb , int rb ){
        this.parent = parent;
        this.lb = lb;
        this.rb = rb;
    }
    Pair(){
        
    }
}
class GFG 
{
    //Function to construct the BST from its given level order traversal.
    public Node constructBST(int[] arr)
    {
        //Write your code here 
        int indx =0;
        LinkedList<Pair> q = new LinkedList<>();
        q.add(new Pair());
        Node root = null;
        while(q.size()>0 && indx<arr.length){
            Pair temp = q.removeFirst();
            int ele = arr[indx];
            if(ele <temp.lb || ele>temp.rb){
                continue;
            }
            
            Node node = new Node(ele);
            indx++;
            if(root == null){
                root = node;
            }else{
                Node pr = temp.parent;
                if(ele <pr.data){
                    pr.left = node;
                }else{
                    pr.right = node;
                }
            }
            
            q.add(new Pair(node , temp.lb , ele));
            q.add(new Pair(node , ele , temp.rb));
        }
        return root;
    }
}