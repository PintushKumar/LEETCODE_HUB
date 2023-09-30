//{ Driver Code Starts
//Initial template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG
{
    public static void main (String[] args)
	{
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0)
        {
            int n = sc.nextInt();
            int arr[]= new int[n];
            for(int i=0; i<n; i++)
                arr[i] = sc.nextInt();
            Solution ob = new Solution();
            if(ob.recreationalSpot(arr,n))
                System.out.println("True");
            else
                System.out.println("False");
        }
	}
}
// } Driver Code Ends


//User function template for C++

class Solution{
    static boolean recreationalSpot(int[] nums , int n){
        
        int nums3 = Integer.MIN_VALUE; // Initialize nums3 to a minimum value.
        Stack<Integer> st = new Stack<>(); // Create a stack to store elements.

        // Traverse the input array in reverse order.
        for (int i = n - 1; i >= 0; i--) {
            // If we find a number smaller than nums3, it means we've found a 132 pattern.
            if (nums[i] < nums3) {
                return true;
            }

            // While the stack is not empty and the top element is smaller than the current number.
            while (!st.isEmpty() && st.peek() < nums[i]) {
                nums3 = st.pop(); // Update nums3 to the popped element.
            }

            st.push(nums[i]); // Push the current number onto the stack.
        }

        return false; // If no 132 pattern is found, return false.
    }
};