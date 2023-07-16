//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().trim().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            int m = Integer.parseInt(br.readLine().trim());

            int ans = new Solve().findZeroes(arr, n, m);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solve {
    // k is maximum of number zeroes allowed to flip
    int findZeroes(int[] arr, int n ,int k) {
        // Function to find the longest subarray with at most 'k' zeros.
    
        // Initialize two pointers 'sp' (start pointer) and 'ep' (end pointer).
        int sp = 0, ep = 0;
    
        // Initialize 'ans' to store the length of the longest subarray with at most 'k' zeros.
        int ans = 0;
    
        // Initialize 'numOfZero' to keep track of the number of zeros encountered in the current subarray.
        int numOfZero = 0;
    
        // Loop until 'ep' reaches the end of the array.
        while (ep < n) {
            // Check if the current element is a zero.
            if (arr[ep] == 0) {
                // Increment 'numOfZero' when a zero is encountered.
                numOfZero++;
            }
    
            // Check if the number of zeros in the current subarray exceeds the allowed limit 'k'.
            while (numOfZero > k) {
                // If the number of zeros exceeds 'k', move the 'sp' pointer forward
                // and decrement 'numOfZero' if the element at 'sp' is a zero.
                if (arr[sp] == 0) {
                    numOfZero--;
                }
                sp++; // Move the start pointer.
            }
    
            // Update the 'ans' to store the maximum length of subarray seen so far.
            ans = Math.max(ans, ep - sp + 1);
    
            // Move the 'ep' pointer forward to explore the next element in the array.
            ep++;
        }
    
        // Return the length of the longest subarray with at most 'k' zeros.
        return ans;
    }

}