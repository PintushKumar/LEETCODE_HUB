//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {

            int n;
            n = sc.nextInt();

            int k;
            k = sc.nextInt();

            int[] v = new int[n];
            for (int i = 0; i < n; i++) v[i] = sc.nextInt();

            Solution obj = new Solution();
            int res = obj.solve(n, k, v);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    // Function to check if we can place cows with given minimum distance
    public static boolean canWePlace(int[] stalls, int dist, int cows) {
        int cntCows = 1;  // Counter for placed cows
        int last = stalls[0];  // Position of the last placed cow
        
        // Iterate over the remaining stalls
        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - last >= dist) {  // Check if current stall is far enough from the last placed cow
                cntCows++;  // Increment the counter for placed cows
                last = stalls[i];  // Update the position of the last placed cow
            }
            
            if (cntCows >= cows) {  // If we have placed all the cows, return true
                return true;
            }
        }
        
        return false;  // Return false if we cannot place all the cows
    }
    
    public static int solve(int n, int cows, int[] stalls) {
        Arrays.sort(stalls);  // Sort the stalls in ascending order
        
        int low = 1;  // Minimum possible distance between cows
        int high = stalls[n - 1] - stalls[0];  // Maximum possible distance between cows
        int ans = -1;  // Variable to store the maximum possible distance
        
        // Perform binary search to find the maximum possible distance
        while (low <= high) {
            int mid = (low + high) / 2;  // Calculate the middle distance
            
            if (canWePlace(stalls, mid, cows)) {  // Check if we can place cows with the middle distance
                low = mid + 1;  // Update the lower bound and store the current distance as the potential answer
                ans = mid;
            } else {
                high = mid - 1;  // Update the upper bound
            }
        }
        
        return ans;  // Return the maximum possible distance
    }
}
