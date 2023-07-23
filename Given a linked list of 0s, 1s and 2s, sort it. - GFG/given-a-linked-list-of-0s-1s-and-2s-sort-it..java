//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

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

class Driverclass
{
    public static void main (String[] args) throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine().trim());
        
        while(t-- > 0)
        {
            int n =Integer.parseInt(in.readLine().trim());
            String s[] = in.readLine().trim().split(" ");
            Node head = new Node(Integer.parseInt(s[0]));
            Node tail = head;
            for (int i = 1; i < n; i++) {
                tail.next = new Node(Integer.parseInt(s[i]));
                tail = tail.next;
            }

            head = new Solution().segregate(head);
            printList(head, out);
            out.println();
        }
        out.close();
    }
    
    public static void printList(Node head,PrintWriter out)
    {
        if(head == null)
           return;
           
        Node temp = head;
        while(temp != null)
        {
            out.print(temp.data + " ");
            temp = temp.next;
        }
    }
    
    
}




// } Driver Code Ends


//User function Template for Java

/*
class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data = data;
        next = null;
    }
}
*/
class Solution {
    // Function to sort a linked list of 0s, 1s, and 2s.
    static Node segregate(Node head) {
        // Creating three pointers for the three groups
        int z =0 , o = 0 , t = 0;
        Node current = head;
        while (current != null) {
            if (current.data == 0) {
               z++;
            } else if (current.data == 1) {
               o++;
            } else {
               t++;
            }
            current = current.next;
        }
        
        Node resHead = new Node(-1);
        Node tempResHead = resHead;
        for(int i=1;i<=z;i++){
            tempResHead.next = new Node(0);
            tempResHead = tempResHead.next;
        }
        for(int i=1;i<=o;i++){
            tempResHead.next = new Node(1);
            tempResHead = tempResHead.next;
        }
        for(int i=1;i<=t;i++){
            tempResHead.next = new Node(2);
            tempResHead = tempResHead.next;
        }
        return resHead.next;
    }
}



