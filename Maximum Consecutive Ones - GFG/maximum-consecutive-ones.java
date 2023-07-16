//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            int[] nums = IntArray.input(br, n);
            
            
            int k;
            k = Integer.parseInt(br.readLine());
            
            Solution obj = new Solution();
            int res = obj.longestOnes(n, nums, k);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
     public static int longestOnes(int n, int[] arr, int k) {
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
        
