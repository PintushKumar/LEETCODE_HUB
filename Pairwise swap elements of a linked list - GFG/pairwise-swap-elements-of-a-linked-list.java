//{ Driver Code Starts
import java.util.*;
import java.io.*;

class Node{
    int data;
    Node next;
    
    Node(int x){
        data = x;
        next = null;
    }
    
}
class GFG{
	static void printList(Node node) 
	{ 
		while (node != null) 
		{ 
			System.out.print(node.data + " "); 
			node = node.next; 
		} 
		System.out.println(); 
	}
	
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t > 0){
        	int n = sc.nextInt();
            
            Node head = new Node(sc.nextInt());
            Node tail = head;
            HashMap<Node, Integer> mp = new HashMap<Node, Integer>();
            mp.put(head, head.data); 
            for(int i=0; i<n-1; i++)
            {
                tail.next = new Node(sc.nextInt());
                tail = tail.next;
                mp.put(tail, tail.data); 
            }
            
            Node failure = new Node(-1);
            
            Solution g = new Solution();
            head = g.pairwiseSwap(head);
            
            Node temp = head;
            int f = 0;
            while (temp != null) 
    		{ 
    			if(mp.get(temp) != temp.data){
    			    f = 1;
    			}
    			temp = temp.next; 
    		} 
            
            if(f==1){
                printList(failure); 
            }
            else{
                printList(head); 
            }
            t--;
        }
    } 
} 
   

// } Driver Code Ends


/* node class of the linked list

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

*/


class Solution {
    // Function to pairwise swap elements of a linked list.
    // It should return the head of the modified list.
    public Node pairwiseSwap(Node head) {
        // Create a dummy node to simplify handling edge cases and as the new head.
        Node dummy = new Node(-1);
        dummy.next = head;  // Initialize the dummy node's next to the original head.
        
        Node point = dummy;  // Initialize a pointer to the dummy node.
        
        // While there are at least two more nodes to swap.
        while (point.next != null && point.next.next != null) {
            Node swap1 = point.next;  // First node to swap.
            Node swap2 = point.next.next;  // Second node to swap.
            
            // Swap the nodes by adjusting their next pointers.
            swap1.next = swap2.next;
            swap2.next = swap1;
            
            point.next = swap2;  // Update the previous node's next pointer to the new swapped node.
            point = swap1;  // Move the pointer to the last swapped node.
        }
        
        return dummy.next;  // Return the head of the modified list.
    }
}
