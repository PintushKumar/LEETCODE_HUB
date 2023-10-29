//{ Driver Code Starts
// driver code

import java.util.*;
import java.io.*;
import java.lang.*;

class Node
{
    int data;
    Node next;
}

class GFG
{
    public static Node newNode(int data){
        Node temp = new Node();
        temp.data = data;
        temp.next = null;
        return temp;
    }
    
    public static void makeLoop(Node head, int x){
        if (x == 0)
            return;
        Node curr = head;
        Node last = head;

        int currentPosition = 1;
        while (currentPosition < x)
        {
            curr = curr.next;
            currentPosition++;
        }
        
        while (last.next != null)
            last = last.next;
        last.next = curr;
    }
    
    public static boolean detectLoop(Node head){
        Node hare = head.next;
        Node tortoise = head;
        while( hare != tortoise )
        {
            if(hare==null || hare.next==null) return false;
            hare = hare.next.next;
            tortoise = tortoise.next;
        }
        return true;
    }
    
    public static int length(Node head){
        int ret=0;
        while(head!=null)
        {
            ret += 1;
            head = head.next;
        }
        return ret;
    }
    
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t--> 0)
        {
            int n = sc.nextInt();
            
            int num = sc.nextInt();
            Node head = newNode(num);
            Node tail = head;
            
            for(int i=0; i<n-1; i++)
            {
                num = sc.nextInt();
                tail.next = newNode(num);
                tail = tail.next;
            }
            
            int pos = sc.nextInt();
            makeLoop(head, pos);
            
            Solution x = new Solution();
            x.removeLoop(head);
            
            if( detectLoop(head) || length(head)!=n )
                System.out.println("0");
            else
                System.out.println("1");
        }
    }
}

// } Driver Code Ends


/*
class Node
{
    int data;
    Node next;
}
*/

class Solution {
    // Function to remove a loop in the linked list.
    public static void removeLoop(Node head) {
        // Initialize two pointers, slow and fast, both starting at the head.
        Node slow = head, fast = head;

        // Detect the loop using Floyd's cycle detection algorithm
        while (fast != null && fast.next != null) {
            slow = slow.next;        // Move the slow pointer by one step
            fast = fast.next.next;   // Move the fast pointer by two steps
            if (slow == fast) {
                break; // If slow and fast pointers meet, a loop is detected, exit the loop.
            }
        }

        // If there is no loop, return
        if (slow != fast) {
            return; // No loop found, return without making any changes.
        }

        // Create a check node to traverse from the node where the loop is detected.
        Node check = fast;

        // Find the start of the loop by moving check until it reaches the last node of the loop.
        while (head == fast) {
            if (check.next == head) {
                check.next = null; // Remove the link from the last node to break the loop.
                return;
            }
            check = check.next;
        }

        // Reset slow to the head and move it and fast until they meet at the start of the loop.
        slow = head;
        while (slow.next != fast.next) {
            slow = slow.next;
            fast = fast.next;
        }

        // Remove the link from the last node of the loop to break the loop.
        fast.next = null;
    }
}
