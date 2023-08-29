//{ Driver Code Starts
import java.util.*;

class Node
{

    int data;
    Node next;

    Node(int d)
    {
        data = d;
        next = null;
    }
}


public class LinkedList
{
    
 

    /* Function to print linked list */
   public static void print(Node root)
    {
        Node temp = root;
        while(temp!=null)
        {
            System.out.print(temp.data + " ");
            temp=temp.next;
        }
    }


    /* Driver program to test above functions */
    public static void main(String args[])
    {

        /* Constructed Linked List is 1.2.3.4.5.6.
         7.8.8.9.null */
        int value;
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0 && sc.hasNextInt() )
        {
            int n = sc.nextInt();
            
            //int n=Integer.parseInt(br.readLine());
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            Node tail = head;

            for (int i = 1; i < n && sc.hasNextInt() ; i++)
            {
                int a = sc.nextInt();
                tail.next = new Node(a);
                tail = tail.next;
            }


            Node result = new Solution().compute(head);
            print(result);
            System.out.println();
            t--;
        }
    }
}
// } Driver Code Ends


/*
class Node {
   int data;
   Node next;

  Node(int data) {
      this.data = data;
  }
}
*/
// class Solution {
//     Node compute(Node head) {
//         Node orgdummy = new Node(0); // Create a dummy node to simplify the code
//         Node dummy = orgdummy;
//         Node temp = head;

//         while (temp != null && temp.next != null) {
//             boolean gr = false;
//             // Find the first greater value node on the right
//             if (temp.next != null && temp.next.data < temp.data) {
//                 temp = temp.next;
//                 gr = true;
//             }

//             if (gr) {
//                 // Skip nodes with smaller values
//                 Node x = new Node(temp.data);
//                 dummy.next = x;
//                 dummy = dummy.next;
//             } else {
//                 // No greater value node on the right, move to the next node
//                 Node x = new Node(temp.data);
//                 dummy.next = x;
//                 dummy = dummy.next;
//                 temp = temp.next;
//             }
//         }

//         return orgdummy.next; // Return the modified list starting from the next of the dummy node
//     }
// }

class Solution {
    Node compute(Node head) {
        Node dummy = new Node(0);
        dummy.next = head;
        Node current = dummy;

        while (current != null && current.next != null) {
            Node nextNode = current.next;

            // Flag to check if a greater value node is found on the right
            boolean hasGreaterNode = false;

            // Iterate through nodes on the right to find a greater value
            Node runner = nextNode;
            while (runner != null) {
                if (runner.data > nextNode.data) {
                    hasGreaterNode = true;
                    break;
                }
                runner = runner.next;
            }

            // If a greater value node is found on the right, skip the current node
            if (hasGreaterNode) {
                current.next = nextNode.next;
            } else {
                current = current.next;
            }
        }

        return dummy.next;
    }
}

